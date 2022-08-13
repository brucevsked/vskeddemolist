import { createRouter, createWebHistory } from 'vue-router'

const routerHistory = createWebHistory()

const routes =  [
      {
        path: '/index',
        component: ()=>import('../views/index.vue')
      },
      {
        path: '/login',
        component: ()=>import('../views/login.vue')
      }
    ]
  
export const router=createRouter({
	history: routerHistory,
	routes:routes
})

export default router