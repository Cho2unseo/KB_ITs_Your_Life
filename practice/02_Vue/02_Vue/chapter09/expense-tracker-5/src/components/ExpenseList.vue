<template>
  <h3>🧾 지출 내역</h3>
  <div class="li" v-for="(expense, index) in expenses" :key="index">
    {{ expense.item }}: {{ expense.amount.toLocaleString('ko-KR') }}원
    <button @click="emit('delete-expense', index)">❌</button>
    <br />
  </div>
  <br />
  <h3>📊 카테고리별 지출 합계</h3>
  <div class="ca" v-if="calculateMeal > 0">
    🍽️ 식비: {{ calculateMeal.toLocaleString('ko-KR') }}원
  </div>
  <div class="ca" v-if="calculateTransport > 0">
    🚌 교통: {{ calculateTransport.toLocaleString('ko-KR') }}원
  </div>
  <div class="ca" v-if="calculateShopping > 0">
    🛍️ 쇼핑: {{ calculateShopping.toLocaleString('ko-KR') }}원
  </div>
</template>

<script setup>
const props = defineProps({
  expenses: { type: Array, required: true },
  calculateMeal: { type: Number },
  calculateTransport: { type: Number },
  calculateShopping: { type: Number },
});
const emit = defineEmits(['delete-expense']);
</script>

<style scoped>
button {
  background-color: #272727;
  border: none;
  cursor: pointer;
  float: right;
}
.ca {
  color: white;
  background-color: #272727;
  margin: 10px;
  padding: 15px;
  border-radius: 10px;
}
</style>
