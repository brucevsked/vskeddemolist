package com.vsked.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Table(name = "users")
@Entity
public class Users {
    @Id
    long uid;
    String uname;
    String upass;
    LocalDate ubirth;

    public Users() {
    }

    public Users(long uid, String uname, String upass, LocalDate ubirth) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.ubirth = ubirth;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", ubirth=" + ubirth +
                '}';
    }
}
