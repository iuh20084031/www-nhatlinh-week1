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

    @Id
    @Column(name = "role_id")
    private long role_id;

    @Column(name = "is_grant")
    private boolean is_grant;

    @Column(name = "note")
    private String note;

    @ManyToOne
    private Account account;

    @ManyToOne
    private Role role;

    public GrantAccess(long account_id, long role_id, boolean is_grant, String note) {
        this.account_id = account_id;
        this.role_id = role_id;
        this.is_grant = is_grant;
        this.note = note;
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

    public boolean isIs_grant() {
        return is_grant;
    }

    public void setIs_grant(boolean is_grant) {
        this.is_grant = is_grant;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "account_id=" + account_id +
                ", role_id=" + role_id +
                ", grant_value=" + is_grant +
                '}';
    }
}
