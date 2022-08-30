import Vue from 'vue'
import App from './App.vue'
import AMap from 'vue-amap'

Vue.use(AMap)

Vue.config.productionTip = false

AMap.initAMapApiLoader({
    // 申請的高德key
    key: '2244da6c02a583d1fd55898d81ca0a9b',
    // 插件集合
    plugin: ['AMap.Autocomplete', 'AMap.PlaceSearch', 'AMap.Scale', 
	'AMap.OverView', 'AMap.ToolBar', 'AMap.MapType', 
	'AMap.PolyEditor', 'AMap.CircleEditor'],
    uiVersion: '1.0'  //添加 uiVersion 的腳本版本號
});

new Vue({
  render: h => h(App),
}).$mount('#app')
