import { createRouter, createWebHistory } from 'vue-router';
import First from '@/pages/First.vue';
import Appliance from '@/pages/Appliance.vue';
import Jewerly from '@/pages/Jewerly.vue';
import Men from '@/pages/Men.vue';
import Women from '@/pages/Women.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: First,
    },
    {
      path: '/appliance',
      component: Appliance,
    },
    {
      path: '/jewerly',
      component: Jewerly,
    },
    {
      path: '/men',
      component: Men,
    },
    {
      path: '/women',
      component: Women,
    },
  ],
});

export default router;
