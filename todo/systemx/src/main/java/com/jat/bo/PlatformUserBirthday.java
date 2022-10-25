package com.jat.bo;

import java.time.LocalDate;

public class PlatformUserBirthday {
    private LocalDate birthday;

    public PlatformUserBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @Override
    public String toString() {
        return "" +birthday;
    }
}
