package vn.edu.iuh.fit.models;

import java.sql.Timestamp;

public class Logs {
    private String logId;
    private String accountId;
    private Timestamp timeLogin;
    private Timestamp timeSignOut;
    private String note;

    public Logs(String logId, String accountId, Timestamp timeLogin, Timestamp timeSignOut, String note) {
        this.logId = logId;
        this.accountId = accountId;
        this.timeLogin = timeLogin;
        this.timeSignOut = timeSignOut;
        this.note = note;
    }

    public Logs(String accountId, Timestamp timeLogin, Timestamp timeSignOut, String note) {
        this.accountId = accountId;
        this.timeLogin = timeLogin;
        this.timeSignOut = timeSignOut;
        this.note = note;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Timestamp getTimeLogin() {
        return timeLogin;
    }

    public void setTimeLogin(Timestamp timeLogin) {
        this.timeLogin = timeLogin;
    }

    public Timestamp getTimeSignOut() {
        return timeSignOut;
    }

    public void setTimeSignOut(Timestamp timeSignOut) {
        this.timeSignOut = timeSignOut;
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
        if (!(o instanceof Logs)) return false;

        Logs logs = (Logs) o;

        return getLogId().equals(logs.getLogId());
    }

    @Override
    public int hashCode() {
        return getLogId().hashCode();
    }

    @Override
    public String toString() {
        return "Logs{" +
                "logId='" + logId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", timeLogin=" + timeLogin +
                ", timeSignOut=" + timeSignOut +
                ", note='" + note + '\'' +
                '}';
    }
}
