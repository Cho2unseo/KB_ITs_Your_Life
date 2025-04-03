<template>
  <h2>🎥 지브리 영화 리스트</h2>
  <ul v-for="(movie, index) in movies" :key="index">
    <li>🎬 {{ movie.title }} - {{ movie.director }}</li>
  </ul>
</template>

<script setup>
import { inject } from 'vue';
const movies = inject('movies');
</script>
