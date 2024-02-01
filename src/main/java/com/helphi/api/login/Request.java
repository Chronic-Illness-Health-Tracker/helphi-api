package com.helphi.api.login;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Request {
    private final String username;
    private final String password;
}
