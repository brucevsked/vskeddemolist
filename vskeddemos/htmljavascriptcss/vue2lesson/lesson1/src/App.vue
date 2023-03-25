<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png"><br>
    <router-link to="/helloworldPage/ab123方案1">method1路由导航</router-link> &nbsp;&nbsp;
    <button @click="giveValue('方案2cd')">push方案</button> &nbsp;&nbsp;
    <button @click="giveValueByName('方案3ef')">路径名配合params</button> &nbsp;&nbsp;
    <router-link :to="{path:'/helloworldPage',query:{p1:'汉语url9999'}}">GivePar</router-link> &nbsp;&nbsp;
    <button @click="giveValueByQuery('方案5gh')">query配合脚本</button> &nbsp;&nbsp;
	<router-link to="/educationPage">click here</router-link>
	<router-view></router-view>
  </div>
  
</template>

<script>

export default {
  name: 'App',
  methods:{
      giveValue(par2){
          this.$router.push({
              path:"/helloworldPage/"+par2
          });
      },
      giveValueByName(par1){
          this.$router.push({
              name:"helloworldPage",
              params:{
                par1:par1
              }
          });
      },
      giveValueByQuery(par1){
          this.$router.push({
              path:"/helloworldPage/",
              query:{
                p1:par1
              }
          });
      }
      
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
