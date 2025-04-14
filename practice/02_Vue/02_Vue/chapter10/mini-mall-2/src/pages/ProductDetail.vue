<template>
  <div class="product">
    <div style="font-size: 32px">{{ product.name }}</div>
    <div><img :src="product.image" style="width: 400px; height: 400px" /></div>
    <div>가격: {{ product.price }}원</div>
  </div>
</template>

<script setup>
import products from '@/data/products.json';
import { useRoute } from 'vue-router';
const currentRoute = useRoute();
const id = parseInt(currentRoute.params.id);
const product = products.find((p) => p.id === id);
</script>

<style scoped>
.product {
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  background-color: #f8f9fa;
  width: 100%;
  min-height: 100vh;
  padding: 48px;
}
</style>
