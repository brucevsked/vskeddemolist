import Vue from 'vue'
import Router from 'vue-router'
import educationPage from '../components/educationPage'
import helloworldPage from '../components/HelloWorld'

Vue.use(Router)


export default new Router({
  routes: [
    {
      path: '/educationPage',
      name: 'educationPage',
      component: educationPage
    },
    {
      path: '/helloworldPage',
      name: 'helloworldPage',
      component: helloworldPage
    }
  ]
});
