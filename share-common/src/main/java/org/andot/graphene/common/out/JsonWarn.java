package org.andot.graphene.common.out;

import org.andot.graphene.common.conf.StatusCode;

/***
 * 警告消息返回
 * @author Andot
 * @date 2019年2月6日20:27:46
 * @since 1.0
 */
public class JsonWarn extends JsonCom {
    public JsonWarn (Object data, String msgPrefix) {
        this.setData(data);
        this.setStatus(StatusCode.Warn.getValue());
        this.setMsg(msgPrefix+"授權失敗");
    }
}
