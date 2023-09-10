package vn.edu.iuh.fit.models;

import java.util.UUID;

public class GrantAccess {
    private String grantAccessId;
    private Account account;
    private Role role;
    private boolean isGrant;
    private String note;

    public GrantAccess(String grantAccessId, Account account, Role role, boolean isGrant, String note) {
        this.grantAccessId = grantAccessId;
        this.account = account;
        this.role = role;
        this.isGrant = isGrant;
        this.note = note;
    }

    public GrantAccess(Account account, Role role, boolean isGrant, String note) {
        this.account = account;
        this.role = role;
        this.isGrant = isGrant;
        this.note = note;
    }

    public String getGrantAccessId() {
        return grantAccessId;
    }

    public void setGrantAccessId(String grantAccessId) {
        this.grantAccessId = grantAccessId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isGrant() {
        return isGrant;
    }

    public void setGrant(boolean grant) {
        isGrant = grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GrantAccess)) return false;

        GrantAccess that = (GrantAccess) o;

        return getGrantAccessId().equals(that.getGrantAccessId());
    }

    @Override
    public int hashCode() {
        return getGrantAccessId().hashCode();
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "grantAccessId='" + grantAccessId + '\'' +
                ", account=" + account +
                ", role=" + role +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
