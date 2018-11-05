import Vue from 'vue';
import VueRouter from 'vue-router';
import Index from './Index.vue';
import Actors from './Actors.vue';
import ActorForm from './ActorForm.vue';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
Vue.use(BootstrapVue);
import VueResource from 'vue-resource';
require("./style.scss");
import App from './App.vue';
Vue.use(VueRouter);
Vue.use(VueResource);



const routes = [
  { path: '/index', alias: '/', component: Index},
  { path:'/actors', component: Actors},
  {path:'/agregarActor', component:ActorForm}
]

// Create the router instance and pass the `routes` option
const router = new VueRouter({
  routes
})

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
