

<template>

  <div class="card">
	  <p>系统登录</p>
	  	
	  用户名：<input id="userName" v-model="userName"> <br>
	  密码：<input id="userPass" v-model="userPass" type="password"> <br>
    <button type="button" @click="submitLogin">登录</button>

  </div>

</template>

<script>
import axios from "axios";

export default {
  name: 'login',
  data(){
	  //定义这个页面要使用的数据结构
	  return{
		 userName:'admin',
		 userPass:'123456' 
	  }
  },
  methods:{
	  //定义这个页面要各种方法
	  submitLogin(){

		  const that=this;
	  	  console.log("-------------:"+this.userName);
		  console.log("-------------:"+this.userPass);
		        axios
		          .get("http://127.0.0.1:5173/index.html")
		          .then(function (res) {
		            console.log(res);
					that.$router.push({path:"/index"})
					
		          })
		          .catch(function (error) {
		            // 请求失败处理
		            console.log(error);
		          });
	  }
  }
  
}

</script>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>
