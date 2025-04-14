<template>
  <div class="page-container">
    <h1>상품 목록</h1>
    <div class="row">
      <div class="col-sm-3 mt-5" v-for="product in products" :key="product.id">
        <div class="card text-center" style="width: 300px">
          <img
            :src="product.image"
            alt=""
            style="width: 100px; height: 100px"
            class="mx-auto"
          />
          <div class="card-body">
            <h4 class="card-title">
              {{ product.name }}
            </h4>
            <p class="card-text">
              {{ product.price.toLocaleString('ko-KR') }}원
            </p>
            <p class="card-text"></p>
            <router-link :to="'/products/' + product.id">상세 보기</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import products from '@/data/products.json';
import { RouterLink } from 'vue-router';
</script>

<style scoped>
.card {
  margin: 10px;
  padding: 5px;
  /* align-content: center; */
  /* justify-items: center; */
  /* justify-content: center; */
}
</style>
