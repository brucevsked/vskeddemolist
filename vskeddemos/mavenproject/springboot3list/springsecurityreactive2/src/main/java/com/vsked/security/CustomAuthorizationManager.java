package com.vsked.security;

import com.vsked.repository.MenuRepository;
import com.vsked.repository.RoleMenuRepository;
import com.vsked.repository.UserRepository;
import com.vsked.repository.UserRoleRepository;
import com.vsked.repository.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.ReactiveAuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.authorization.AuthorizationContext;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CustomAuthorizationManager implements ReactiveAuthorizationManager<AuthorizationContext> {

    private static final Logger log = LoggerFactory.getLogger(CustomAuthorizationManager.class);

    private final UserRoleRepository userRoleRepository;
    private final RoleMenuRepository roleMenuRepository;
    private final MenuRepository menuRepository;
    private final UserRepository userRepository;

    public CustomAuthorizationManager(UserRoleRepository userRoleRepository,
                                      RoleMenuRepository roleMenuRepository,
                                      MenuRepository menuRepository,UserRepository userRepository) {
        this.userRoleRepository = userRoleRepository;
        this.roleMenuRepository = roleMenuRepository;
        this.menuRepository = menuRepository;
        this.userRepository=userRepository;
    }

    @Override
    public Mono<AuthorizationDecision> check(Mono<Authentication> authentication, AuthorizationContext context) {
        log.trace("request path is:{}",context.getExchange().getRequest().getPath());
        return authentication
                .flatMap(auth -> {
                    String username = auth.getName();
                    String requestPath =context.getExchange().getRequest().getPath().value();

                    // 查询用户 ID（假设用户名唯一）
                    return userRoleRepository.findByUserId(getUserIdByUsername(username))
                            .flatMap(userRole -> roleMenuRepository.findByRoleId(userRole.roleId()))
                            .flatMap(roleMenu -> menuRepository.findById(roleMenu.menu_id()))
                            .any(menu -> matches(requestPath, menu.url()))
                            .map(AuthorizationDecision::new);
                })
                .defaultIfEmpty(new AuthorizationDecision(false)); // 默认拒绝访问
    }

    private boolean matches(String requestPath, String menuUrl) {
        // 简单的路径匹配逻辑，可以使用 AntPathMatcher 或其他工具
        if (menuUrl == null || menuUrl.isEmpty()) {
            return false;
        }
        return requestPath.matches(menuUrl.replace("*", ".*"));
    }

    private Mono<Long> getUserIdByUsername(String username) {
        log.trace("find user by user name :{}",username);
        return userRepository.findByName(username)
                .map(User::id) // 提取用户 ID
                .switchIfEmpty(Mono.error(new RuntimeException("User not found"))); // 如果用户不存在，抛出异常
    }
}
