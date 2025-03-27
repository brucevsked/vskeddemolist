package com.jat.system.model.user;

import com.jat.repository.model.UserPO;
import com.jat.system.model.Phone;

public class User {

    private UserId id;
    private UserName name;
    private Phone phone;

    private UserState state;

    public UserId getId() {
        return id;
    }

    public UserName getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public UserState getState() {
        return state;
    }

    public User(UserId id, UserName name, Phone phone, UserState state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.state = state;
    }

    public User(UserName name, Phone phone) {
        this.name = name;
        this.phone = phone;
        this.state=new UserState(0);
    }

    public User(UserId id, UserName name, Phone phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.state=new UserState(0);
    }

    public static User poToBo(UserPO po){
        if(po==null){
            throw new IllegalArgumentException("无用户信息！");
        }

        UserId id=new UserId(po.getId());
        UserName name=new UserName(po.getName());
        Phone phone=new Phone(po.getPhone());
        UserState state=new UserState(po.getState());
        return new User(id,name,phone,state);
    }

    public UserPO boToPo(Integer isDel){
        Integer id=null;
        if(this.getId()!=null){
            id=this.getId().getId();
        }
        return new UserPO(id,this.getName().getName(),this.getState().getState(),this.getPhone().getNumber(),isDel);
    }

}
