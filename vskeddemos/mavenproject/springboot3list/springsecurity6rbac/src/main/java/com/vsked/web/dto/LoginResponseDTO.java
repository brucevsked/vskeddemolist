package com.vsked.web.dto;

public record LoginResponseDTO(
        String token,
        String username,
        String password,
        String role,
        String roleId,
        String[] permissions) {
}
