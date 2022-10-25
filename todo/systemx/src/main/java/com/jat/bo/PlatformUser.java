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

    public PlatformUser(String nameStr) {
        PlatformUserName name=new PlatformUserName(nameStr);
        this.name = name;
    }

    public PlatformUser(Long idPar, String nameStr, LocalDate birthdayDate) {
        PlatformUserId id=new PlatformUserId(idPar);
        PlatformUserName name=new PlatformUserName(nameStr);
        PlatformUserBirthday birthday=new PlatformUserBirthday(birthdayDate);

        this.id = id;
        this.name = name;
        this.birthday = birthday;
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
