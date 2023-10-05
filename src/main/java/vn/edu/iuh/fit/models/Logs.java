package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "logs")
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private long log_id;

    @Column(name = "account_id")
    private String account_id;

    @Column(name = "login_time")
    private Date login_time;

    @Column(name = "logout_time")
    private Date logout_time;

    @Column(name = "notes")
    private String notes;

    public Logs(String account_id, Date login_time, Date logout_time, String notes) {
        this.account_id = account_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    public Logs() {

    }

    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public Date getLogout_time() {
        return logout_time;
    }

    public void setLogout_time(Date logout_time) {
        this.logout_time = logout_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "log_id=" + log_id +
                ", account_id='" + account_id + '\'' +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", notes='" + notes + '\'' +
                '}';
    }
}
