package org.andot.graphene.common.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.andot.graphene.common.conf.StatusCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author lucas
 * @param <T>
 */
@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JsonCom<T> implements Serializable {
    private Integer status;
    private T data;
    private String msg;
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    private Date datetime = new Date();

    public JsonCom(Integer status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public JsonCom(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    @Override
    public String toString(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            log.error("[A_ERROR]" + this.getClass().getCanonicalName() + "Json转换出现了异常， 异常详细信息："+ e.getMessage());
            return this.toString();
        }
    }

    public static <T> JsonCom<T> success(T t, String msg){
        return new JsonCom<>(StatusCode.SUCCESS.getValue(), t, msg);
    }

    public static <T> JsonCom<T> fail(String msg){
        return new JsonCom<>(StatusCode.ServerError.getValue(), msg);
    }
}
