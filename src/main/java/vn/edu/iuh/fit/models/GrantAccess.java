package vn.edu.iuh.fit.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.enums.GrantValue;
import vn.edu.iuh.fit.enums.Status;

@Entity
@Table(name = "Grant_access")
public class GrantAccess {
    @Id
    @Column(name = "account_id")
    private long account_id;

    @Column(name = "role")
    private long role_id;

    @Column(name = "grant_value")
    private GrantValue grant_value;

    @ManyToOne
    private Account account;

    @ManyToOne Role role;

    public GrantAccess(long account_id, long role_id, GrantValue grant_value) {
        this.account_id = account_id;
        this.role_id = role_id;
        this.grant_value = grant_value;
    }

    public GrantAccess() {

    }

    public long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
        this.account_id = account_id;
    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public GrantValue getGrant_value() {
        return grant_value;
    }

    public void setGrant_value(GrantValue grant_value) {
        this.grant_value = grant_value;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "account_id=" + account_id +
                ", role_id=" + role_id +
                ", grant_value=" + grant_value +
                '}';
    }
}
