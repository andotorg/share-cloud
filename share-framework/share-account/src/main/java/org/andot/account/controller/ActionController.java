package org.andot.account.controller;

import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import org.andot.account.entity.Action;
import org.andot.account.service.ActionService;
import org.andot.account.vo.in.InActionVo;
import org.andot.account.vo.out.OutActionVo;
import org.andot.graphene.common.mybatis.CommonPage;
import org.andot.graphene.common.out.JsonCom;
import org.andot.graphene.common.out.JsonSuccess;
import org.andot.graphene.common.out.RequestParamters;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/***
 * @author lucas
 */
@Api(tags = "操作方法控制器", description = "操作方法请求控制器")
@RequestMapping("/action")
@RestController
public class ActionController extends BaseController<Action> {

    @Resource
    private ActionService actionService;

    @GetMapping("/list")
    public JsonCom getList(InActionVo inActionVO) {
        List<OutActionVo> list = actionService.getActionInfoList(inActionVO);
        return new JsonSuccess(list, "查询列表");
    }

    @GetMapping("/page/list")
    public JsonCom getPageList(InActionVo inActionVO,
                               @RequestParam(value = "页码", defaultValue = "1") int pageNum,
                               @RequestParam(value = "行数", defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        try {
            List<OutActionVo> list = actionService.getActionInfoList(inActionVO);
            return JsonCom.success(CommonPage.restPage(list), "获取操作项成功");
        }catch (Exception e){
            return JsonCom.fail("获取操作项失败，失败原因："+e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public JsonCom getList(@PathVariable("id") Long id) {
        actionService.getActionInfo(id.intValue());
        return null;
    }

    @PostMapping("/create")
    public JsonCom create(@RequestBody RequestParamters requestParamters) {
        return null;
    }

    @PutMapping("/{id}")
    public JsonCom update(@PathVariable("id") Long id, @RequestBody RequestParamters requestParamters) {
        return null;
    }

    @DeleteMapping("/{id}")
    public JsonCom delete(@PathVariable("id") Long id, @RequestBody RequestParamters requestParamters) {
        return null;
    }

    @DeleteMapping("/batch")
    public JsonCom batchDelete(@RequestBody List<Long> ids) {
        return null;
    }
}
