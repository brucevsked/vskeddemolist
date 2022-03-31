

<template>
  <img alt="Vue logo" src="./assets/logo.png" />
  <button @click="get1">get异步</button> &nbsp;&nbsp;
  <button @click="get4">get同步</button> &nbsp;&nbsp;
</template>

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
<script>
import axios from "axios";
export default {
  setup() {},
  methods: {
    get1() {
      console.log("----------------get异步");
      axios
        .get("http://localhost:3000/index.html")
        .then(function (res) {
          console.log(res);
        })
        .catch(function (error) {
          // 请求失败处理
          console.log(error);
        });
    },
    get2() {
      console.log("----------------get同步1");
    },
    get3() {
      console.log("----------------get同步2");
    },
    get4() {
      console.log("----------------get同步3");
    },
  },
};
</script>

