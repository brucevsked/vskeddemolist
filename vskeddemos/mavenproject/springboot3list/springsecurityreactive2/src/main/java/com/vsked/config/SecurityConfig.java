package com.vsked.config;

import com.vsked.repository.model.Role;
import com.vsked.repository.RoleRepository;
import com.vsked.repository.UserRepository;
import com.vsked.jwt.JwtTokenAuthenticationFilter;
import com.vsked.jwt.JwtTokenProvider;
import com.vsked.repository.UserRoleRepository;
import com.vsked.security.CustomAuthorizationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.security.web.server.context.NoOpServerSecurityContextRepository;
import reactor.core.publisher.Mono;

@Configuration
public class SecurityConfig {
    private final CustomAuthorizationManager customAuthorizationManager;

    public SecurityConfig(CustomAuthorizationManager customAuthorizationManager) {
        this.customAuthorizationManager = customAuthorizationManager;
    }

    @Bean
    SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http, JwtTokenProvider tokenProvider, ReactiveAuthenticationManager reactiveAuthenticationManager) {

        return http.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
                .authenticationManager(reactiveAuthenticationManager)
                .securityContextRepository(NoOpServerSecurityContextRepository.getInstance())
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers("/auth/login").permitAll() // 忽略 /auth/login 路径
                        .anyExchange().access(customAuthorizationManager) // 使用自定义授权管理器
                )
                .addFilterAt(new JwtTokenAuthenticationFilter(tokenProvider), SecurityWebFiltersOrder.HTTP_BASIC)
                .build();

    }

    private Mono<AuthorizationDecision> currentUserMatchesPath(Mono<Authentication> authentication, AuthorizationContext context) {

        return authentication.map(a -> context.getVariables().get("user").equals(a.getName()))
                .map(AuthorizationDecision::new);

    }

    @Bean
    public ReactiveUserDetailsService userDetailsService(UserRepository users, UserRoleRepository userRoles, RoleRepository roles) {
        return username -> users.findByName(username)
                .flatMap(user -> userRoles.findByUserId(user.id())
                        .flatMap(ur -> roles.findById(ur.roleId()))
                        .map(Role::name) // "ADMIN" → "ROLE_ADMIN"
                .collectList()
                        .map(authorities -> User.withUsername(user.name()).password(user.password()).authorities(authorities.stream()
                                .map(role -> "ROLE_" + role).toArray(String[]::new))
                                .accountExpired(!user.active()).credentialsExpired(!user.active())
                                .disabled(!user.active())
                                .accountLocked(!user.active()).build()));
    }

    @Bean
    public ReactiveAuthenticationManager reactiveAuthenticationManager(ReactiveUserDetailsService userDetailsService) {
        var authenticationManager = new UserDetailsRepositoryReactiveAuthenticationManager(userDetailsService);
        authenticationManager.setPasswordEncoder(new BCryptPasswordEncoder());
        return authenticationManager;
    }

}
