<template>
  <div v-if="isLoading">영화 정보를 불러오는 중입니다...</div>
  <div v-else>
    <div>🎥 지브리 영화 리스트</div>
    <div>{{ movie.title }} ({{ movie.year }})</div>
    <div>감독: {{ movie.director }}</div>
    <div>줄거리: {{ movie.description }}</div>
    <div><img :src="movie.poster" /></div>
  </div>
</template>

<script setup>
import { ref, inject, watchEffect } from 'vue';
import { useRoute } from 'vue-router';
const isLoading = ref(true);
const movies = inject('movies');
const currentRoute = useRoute();
const movie = ref(null);

watchEffect(() => {
  isLoading.value = true;
  try {
    const id = parseInt(currentRoute.params.id);
    if (movies.length > 0) {
      const findmovie = movies.find((m) => m.id === id);
      if (movie) {
        movie.value = findmovie;
      }
      isLoading.value = false;
    }
  } catch (e) {
    console.log(e);
    isLoading.value = false;
  }
});
</script>
