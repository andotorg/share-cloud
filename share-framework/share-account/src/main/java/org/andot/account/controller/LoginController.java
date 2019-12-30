package org.andot.account.controller;

import cn.hutool.core.util.StrUtil;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.Api;
import org.andot.account.service.BaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@Api(tags = "登录控制器", description = "多种平台登录方式")
@RequestMapping("/login")
@RestController
public class LoginController extends BaseController {

    @Autowired
    private BaseUserService baseUserService;

    @PostMapping("/login1")
    public String login(Authentication authentication){
        String header = request.getHeader("Authorization");
        String token = StrUtil.subAfter(header, "bearer ", false);
        System.err.println(Jwts.parser()
                .setSigningKey("lucas".getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody());
        System.err.println(super.request.getHeader("X-Id"));
        return super.request.getHeader("X-Id");
    }

    @GetMapping("/status")
    public String loginStatus(){
        return "is login";
    }
}
