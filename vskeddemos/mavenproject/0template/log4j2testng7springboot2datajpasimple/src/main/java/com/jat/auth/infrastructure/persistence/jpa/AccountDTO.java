package com.jat.auth.infrastructure.persistence.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="account")
public class AccountDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    private Long id;

    private String name;
    
    private String pass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public AccountDTO() {
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"name\":\"" + name +
                "\", \"pass\":\"" + pass +
                "\"}";
    }
    
}
