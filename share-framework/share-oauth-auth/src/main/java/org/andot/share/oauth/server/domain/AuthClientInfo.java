package org.andot.share.oauth.server.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthClientInfo {
    private Long id;
    private String clientId;
    private String clientScrot;
}
