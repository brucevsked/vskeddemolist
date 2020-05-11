package com.vsked.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "system.myconfig")
public class MyConfig1 {

    private String databaseusername;
    private String databaseuserpass;
    private Integer databasecount;

    public String getDatabaseusername() {
        return databaseusername;
    }

    public void setDatabaseusername(String databaseusername) {
        this.databaseusername = databaseusername;
    }

    public String getDatabaseuserpass() {
        return databaseuserpass;
    }

    public void setDatabaseuserpass(String databaseuserpass) {
        this.databaseuserpass = databaseuserpass;
    }

    public Integer getDatabasecount() {
        return databasecount;
    }

    public void setDatabasecount(Integer databasecount) {
        this.databasecount = databasecount;
    }


}
