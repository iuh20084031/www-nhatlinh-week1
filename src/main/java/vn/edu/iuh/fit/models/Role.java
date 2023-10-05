package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long role_id;

    @Column(name = "role_name")
    private String role_name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "role")
    private List<GrantAccess> listGrantAccess;

    public Role(String role_name, String description, String status) {
        this.role_name = role_name;
        this.description = description;
        this.status = status;
    }

    public Role() {

    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
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
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
