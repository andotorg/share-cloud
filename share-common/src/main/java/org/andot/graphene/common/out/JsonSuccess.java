package org.andot.graphene.common.out;

import org.andot.graphene.common.conf.StatusCode;

/***
 *
 */
public class JsonSuccess extends JsonCom {
    public JsonSuccess(Object data, String msgPrefix){
        this.setData(data);
        this.setStatus(StatusCode.SUCCESS.getValue());
        this.setMsg(msgPrefix+"成功");
    }


}
