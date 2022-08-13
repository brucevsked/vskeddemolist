<template>
<div>desk1代码跳转页面</div>
<button @click="toHome">返回主页</button>
</template>

<script>
export default{
	methods:{
		toHome(){
			console.log("--------------");
			this.$router.push({path:"/"});
		}
	}
}
</script>