"use strict"

class Index{
    toUserList(){
        const url = "userList.html";
        fetch(url).then(res=>res.text()).then(res=>{
            console.log(res);
            console.log("----------------------2");
            document.getElementById("mainContent").innerHTML=res;
          });
    }

    init(){
        var toUserListBt=document.getElementById("toUserListBt");
        toUserListBt.addEventListener("click",this.toUserList,false);
        console.log("index init ok");
    }

}

var index=new Index();
index.init();