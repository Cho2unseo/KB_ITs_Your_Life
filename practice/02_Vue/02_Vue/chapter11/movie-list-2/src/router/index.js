import MovieDetail from '@/components/MovieDetail.vue';
import MovieList from '@/components/MovieList.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: MovieList,
    },
    {
      path: '/movies/:id',
      component: MovieDetail,
    },
  ],
});

export default router;
