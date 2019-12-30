package org.andot.graphene.common.conf;

/***
 * 返回前端的状态码枚举类
 * @author Andot
 * @date 2019-1-27 23:33:59
 * @since 1.0
 */
public enum StatusCode {
    SUCCESS(200),
    ServerError(500),
    ClientError(400),
    Warn(302);

    Integer value;
    StatusCode (Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
