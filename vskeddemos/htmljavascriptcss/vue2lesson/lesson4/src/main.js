import Vue from 'vue'
import App from './App.vue'
//1
import echarts from 'echarts'

Vue.config.productionTip = false
//2
Vue.prototype.$echarts=echarts;

new Vue({
  render: h => h(App),
}).$mount('#app')
