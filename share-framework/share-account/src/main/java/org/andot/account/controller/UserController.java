package org.andot.account.controller;

import org.andot.graphene.common.domain.Authorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Andot
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/authorize")
    public Authorize getUserAuthorize(Long userId){
        System.err.println("被调用了：id="+userId);
        Authorize authorize = new Authorize();
        List<Long> list =  new ArrayList<>();
        list.add(1L);
        authorize.setResources(list);
        authorize.setRoles(list);
        return authorize;
    }
    @GetMapping("/name")
    public String getUserName(Long userId){
        System.err.println("被调用了：id="+userId);

        return "小米来了";
    }
}
