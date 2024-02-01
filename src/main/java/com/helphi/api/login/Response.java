package com.helphi.api.login;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class Response {
    private final String accessToken;
    private final String refreshToken;
    private final UUID authenticatedUserId;
    private final boolean authenticated;
}
