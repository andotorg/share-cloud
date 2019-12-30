package org.andot.account.vo.out;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.io.Serializable;

/***
 * 操作项视图实体
 * @author  andot
 * @date 2019-1-19 11:28:05
 * @since 1.0
 * @see org.andot.account.entity.Action
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@ApiModel(value = "操作项视图对象出参", description = "操作项页面展示视图对象")
public class OutActionVo implements Serializable {
    @ApiModelProperty(value = "操作项id主键", dataType="int", notes="自增主键")
    private Integer actionId;
    @ApiModelProperty(value = "操作项名称", dataType="string")
    private String actionName;
    @ApiModelProperty(value = "操作项类型", dataType="byte")
    private Byte actionType;
    @ApiModelProperty(value = "操作项类型名称", dataType="string")
    private String actionTypeName;
    @ApiModelProperty(value = "操作项地址", dataType="string")
    private String actionUrl;
    @ApiModelProperty(value = "菜单id", dataType="int")
    private Integer menuId;
    @ApiModelProperty(value = "菜单名称", dataType="string")
    private String menuName;
    @ApiModelProperty(value = "备注说明", dataType="string")
    private String caption;
}
