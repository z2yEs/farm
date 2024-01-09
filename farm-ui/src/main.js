import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// 导入依赖组件
import Element from 'element-ui'
import './assets/styles/element-variables.scss'

import './assets/icons' // icon

Vue.config.productionTip = false

// vue 引入element
Vue.use(Element)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
