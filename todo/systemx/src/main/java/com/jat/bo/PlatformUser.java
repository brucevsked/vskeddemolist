package com.jat.bo;

import java.time.LocalDate;


public class PlatformUser {

    /**
     * 用户编号
     */
    private PlatformUserId id;
    private PlatformUserName name;
    private PlatformUserBirthday birthday;
    private PlatformUserAge age;

    public PlatformUserId getId() {
        return id;
    }

    public void setId(PlatformUserId id) {
        this.id = id;
    }

    public PlatformUserName getName() {
        return name;
    }

    public PlatformUserBirthday getBirthday() {
        return birthday;
    }

    public PlatformUserAge getAge() {
        return age;
    }

    public PlatformUserAge calculateAge(PlatformUserBirthday birthday){
        PlatformUserAge age=null;

        if(birthday!=null && birthday.getBirthday()!=null){
            LocalDate myDate=birthday.getBirthday();
            LocalDate currentDate=LocalDate.now();
            int ageValue=currentDate.getYear()-myDate.getYear();
            age=new PlatformUserAge(ageValue);
        }
        return age;
    }

    public PlatformUser(String userName) {
        this.name = new PlatformUserName(userName);
    }

    public PlatformUser(Long id, String name, LocalDate birthdayDate) {
        this.id = new PlatformUserId(id);
        this.name = new PlatformUserName(name);
        this.birthday = new PlatformUserBirthday(birthdayDate);
        this.age = calculateAge(birthday);
    }

    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"name\":\"" + name + "\"" +
                ", \"birthday\":\"" + birthday + "\"" +
                ", \"age\":" + age + "" +
                "}";
    }

}
