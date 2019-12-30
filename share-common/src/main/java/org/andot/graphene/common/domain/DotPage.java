package org.andot.graphene.common.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DotPage<T> {
    private Integer page;
    private Integer rows;
    private Integer total;
    private T t;
}
