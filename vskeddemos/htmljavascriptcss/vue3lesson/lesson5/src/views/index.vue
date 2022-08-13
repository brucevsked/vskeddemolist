
<template>
主页登录成功<br>

<button type="button" @click="toLogin()">去登录页</button>

</template>

<script>
export default {
	methods:{
		//定义这个页面要各种方法
		toLogin(){
			this.$router.push({path:'/login'});
		}
	}
}
</script>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>
