<template>
  <MovieList />
</template>

<script setup>
import axios from 'axios';
import { provide } from 'vue';
import MovieList from './components/MovieList.vue';

let movies = [];
const requestAPI = async () => {
  const url = '/api/movies';
  try {
    const response = (await axios.get(url)).data;
    for (let i = 0; i < response.length; i++) {
      movies.push({ title: response[i].title, director: response[i].director });
    }
  } catch (e) {
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};
requestAPI();
provide('movies', movies);
</script>
