

<template>
  <div id='root'>
    <img src='./assets/logo.png' />
    <div id='nav'>
      <router-link to='/'> Home</router-link> &nbsp;&nbsp;|&nbsp;&nbsp;
      <router-link to='/contact'>Contact </router-link>
    </div>
    <router-view />
  </div>
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
