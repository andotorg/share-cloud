package org.andot.account.vo.in;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/***
 * 操作项查询条件
 * @author  andot
 * @date 2019-10-18 13:47:17
 * @since 1.0
 * @see org.andot.account.entity.Action
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(value = "操作项视图对象入参", description = "操作项页面展示视图对象")
public class InActionVo implements Serializable {
    @ApiModelProperty(value = "操作项名称", dataType="string")
    private String actionName;
    @ApiModelProperty(value = "操作项类型", dataType="byte")
    private Byte actionType;
    @ApiModelProperty(value = "操作项地址", dataType="string")
    private String actionUrl;
    @ApiModelProperty(value = "菜单id", dataType="int")
    private Integer menuId;
}
