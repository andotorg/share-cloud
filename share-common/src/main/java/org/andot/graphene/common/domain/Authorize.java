package org.andot.graphene.common.domain;

import java.util.Collection;

public class Authorize {
    private Collection<Long> resources;
    private Collection<Long> roles;

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
}
