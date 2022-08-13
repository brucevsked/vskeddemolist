

<template>
  <div id='root'>

    <img src='./assets/logo.png' />
    <div id='nav'>
      <router-link to='/'> Home</router-link> &nbsp;&nbsp;|&nbsp;&nbsp;
      <router-link to='/contact'>Contact </router-link>
	  <button @click="toDesk1()">去桌子1</button>
    </div>
    <router-view >
    </router-view>
  </div>
</template>

<script>
	export default{

		methods:{
			toDesk1(){
				console.log("-----------toDesk1");
				this.$router.push({path:"/desk1"});
				
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
