package org.andot.share.oauth.server.resource.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("test")
    public Object test(@AuthenticationPrincipal(expression = "name")String name){
        return name;
    }
}
