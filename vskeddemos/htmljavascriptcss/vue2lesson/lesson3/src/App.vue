<template>
  <div id="app">
    <el-amap id="map1" style="width: 500px;height: 500px;"></el-amap>
  </div>
</template>

<script>
import AMap from 'vue-amap'

export default {
  name: 'App',
  data(){
	return{
		map:null,
	};  
  },
  mounted() {
   this.initMap1()
  },
  methods:{
    initMap1(){
          console.log(1);
window.init=function(){
          var map = new AMap.Map("map1", {
                           center: [116.478935, 39.997761],
                           zoom: 17
                       });
          this.map=map;
}

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
