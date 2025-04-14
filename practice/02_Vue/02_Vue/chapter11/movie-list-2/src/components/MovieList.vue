<template>
  <h2>🎥 지브리 영화 리스트</h2>
  <ul v-for="movie in movies" :key="movie.id">
    <li>
      <router-link :to="'/movies/' + movie.id"
        >🎬 {{ movie.title }} - {{ movie.director }}</router-link
      >
    </li>
  </ul>
</template>

<script setup>
import { inject } from 'vue';
import { RouterLink, useRoute } from 'vue-router';
const movies = inject('movies');
</script>
