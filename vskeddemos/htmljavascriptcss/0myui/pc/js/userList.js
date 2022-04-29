"use strict"

class UserList{

    showList(){
        console.log("load user data ok");
    }

    init(){
       this.showList();
    }

}

var userList=new UserList();
userList.init();