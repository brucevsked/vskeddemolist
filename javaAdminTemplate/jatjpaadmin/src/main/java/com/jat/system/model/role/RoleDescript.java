package com.jat.system.model.role;

public class RoleDescript {

    private final String descript;

    public RoleDescript(String descript) {
        this.descript = descript;
    }

    public String getDescript() {
        return descript;
    }

    @Override
    public String toString() {
        return descript;
    }
}
