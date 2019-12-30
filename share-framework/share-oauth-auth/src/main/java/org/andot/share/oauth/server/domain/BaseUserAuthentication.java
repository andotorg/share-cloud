package org.andot.share.oauth.server.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Andot
 */
@Getter
@Setter
public class BaseUserAuthentication implements Serializable {
    private Long id;

    private String username;

    private String password;

    private String email;

    private String phoneNumber;

    private String status;

    private String name;

    private String type;
}
