import { createRouter, createWebHistory } from 'vue-router';

import Home from '@/pages/Home.vue';
import Products from '@/pages/Products.vue';
import Cart from '@/pages/Cart.vue';
import ProductDetail from '@/pages/ProductDetail.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/', component: Home },
    { path: '/products', component: Products },
    { path: '/cart', component: Cart },
    { path: '/products/:id', name: 'productDetail', component: ProductDetail },
  ],
});

export default router;
