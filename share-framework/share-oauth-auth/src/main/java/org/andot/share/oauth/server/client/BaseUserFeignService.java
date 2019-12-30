package org.andot.share.oauth.server.client;

import org.andot.graphene.common.domain.Authorize;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/***
 * 通过远程调用获取用户操作
 * @author Andot
 */
@FeignClient(value = "share-account", url="http://192.168.196.74:8087")
public interface BaseUserFeignService {

    /***
     * 根据用户id获取用户角色、资源权限
     * @param userId
     * @return
     */
    @GetMapping("/user/authorize")
    Authorize getAuthorize(@RequestParam("userId") Long userId);

    @GetMapping("/user/name")
    String getUsername(@RequestParam("userId") Long userId);
}
