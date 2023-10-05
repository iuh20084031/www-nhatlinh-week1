package vn.edu.iuh.fit.enums;

public enum Status {
    ACTIVE(1),
    DEACTIVE(0),
    DELETE(-1);
    private int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
