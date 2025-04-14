<template>
  <router-view />
</template>

<script setup>
import axios from 'axios';
import { provide, ref } from 'vue';

const movies = ref([]);

const requestAPI = async () => {
  const url = '/api/movies';
  try {
    const response = (await axios.get(url)).data;
    movies.value = response;
  } catch (e) {
    console.log(e);
  }
};
requestAPI();
provide('movies', movies);
</script>
