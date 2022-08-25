<template>
  <div id="app">
    <button @click="get1">axios,get</button> <br/>
	<button @click="get2">axios,get2,mock</button> <br/>
	<button @click="get4">axios,get4,mock</button> <br/>
  </div>
</template>

<script>
import axios from 'axios'
import mock from 'mockjs'
import mockData from './config/mockdata.js'

export default {
  name: 'App',
  methods:{
    get1(){
        console.log(111)
		axios.get('http://localhost:8080/index.html').then(function(res){
			console.log(res)
		}).catch(function(err){
			console.log(err)
		});
	},
	get2(){
		mock.mock('http://192.168.3.121:8080/s2',mockData.get2Data());
		axios.get('http://192.168.3.121:8080/s2').then(function(res){
			console.log(res)
		}).catch(function(err){
			console.log(err)
		});
	},
	get4(){
		console.log(444)
		mock.mock('http://localhost:8080/s4',mockData.get4Data());
		axios.get('http://localhost:8080/s4').then(function(res){
			console.log(res)
		}).catch(function(err){
			console.log(err)
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
