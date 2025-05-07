package com.vsked.web;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import java.util.Map;

@RestController
@RequestMapping("/system/user")
public class CurrentUserController {

    @GetMapping()
    public Mono<ResponseEntity<?>> current(@AuthenticationPrincipal Mono<UserDetails> principal) {
        return principal.map(user -> {
            var userDetails = Map.of(
                    "name", user.getUsername(),
                    "roles", AuthorityUtils.authorityListToSet(user.getAuthorities())
            );
            return ResponseEntity.ok()
                    .body(Map.of("code", 200,
                            "msg", "success",
                            "data", userDetails));
        });
    }

}
