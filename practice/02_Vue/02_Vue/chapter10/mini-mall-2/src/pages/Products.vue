<template>
  <div class="page-container">
    <h1>상품 목록 페이지입니다.</h1>
    <div class="row">
      <div class="col-sm-3 mt-5" v-for="product in products" :key="product.id">
        <div class="card" style="width: 300px">
          <img
            :src="product.image"
            alt=""
            style="width: 100px; height: 100px"
          />
          <div class="card-body">
            <h4 class="card-title">
              {{ product.name }}
            </h4>
            <p class="card-text">
              {{ product.price.toLocaleString('ko-KR') }}원
            </p>
            <p class="card-text"></p>
            <p>상세 보기</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import products from '@/data/products.json';
</script>

<style scoped>
.page-container {
  margin: 10px;
  padding: 5px;
  align-content: center;
}
</style>
