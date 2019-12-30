package org.andot.share.oauth.server.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Andot
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UniSafeUserDetails implements UserDetails, CredentialsContainer, Serializable {
    private Long userId;
    private String username;
    private String password;
    private Collection<Long> resources = new ArrayList<>();
    private Collection<Long> roles = new ArrayList<>();
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private Collection<GrantedAuthority> grantedAuthorities;

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (grantedAuthorities == null) {
            this.grantedAuthorities = this.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.toString())).collect(Collectors.toList());
        }
        return grantedAuthorities;
    }

    @Override
    public void eraseCredentials() {

    }

    public Collection<Long> getResources() {
        return resources;
    }

    public void setResources(Collection<Long> resources) {
        this.resources = resources;
    }

    public Collection<Long> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Long> roles) {
        this.roles = roles;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
