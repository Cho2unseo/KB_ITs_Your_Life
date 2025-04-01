<template>
  <h3>🧾 지출 내역</h3>
  <div class="li" v-for="(expense, index) in expenses" :key="index">
    {{ expense.item }}: {{ expense.amount.toLocaleString('ko-KR') }}원
    <button @click="emit('delete-expense', index)">❌</button>
  </div>
</template>

<script setup>
const props = defineProps({ expenses: { type: Array, required: true } });
const emit = defineEmits(['delete-expense']);
</script>

<style scoped>
button {
  background-color: #272727;
  border: none;
  cursor: pointer;
  float: right;
}
</style>
