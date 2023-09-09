package vn.edu.iuh.fit.models;

import java.util.UUID;

public class Role {
    private UUID roleId;
    private String roleName;
    private String description;
    private String status;

    public Role(UUID roleId, String roleName, String description, String status) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.description = description;
        this.status = status;
    }

    public UUID getRoleId() {
        return roleId;
    }

    public void setRoleId(UUID roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        return getRoleId() != null ? getRoleId().equals(role.getRoleId()) : role.getRoleId() == null;
    }

    @Override
    public int hashCode() {
        return getRoleId() != null ? getRoleId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
