package org.andot.graphene.common.out;

import org.andot.graphene.common.conf.StatusCode;

public class JsonFail extends JsonCom {
    public JsonFail(Object data, String msg){
        this.setData(data);
        this.setStatus(StatusCode.ServerError.getValue());
        this.setMsg(msg);
    }
}
