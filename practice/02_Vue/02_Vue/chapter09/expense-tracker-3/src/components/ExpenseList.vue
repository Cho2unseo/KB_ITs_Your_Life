<template>
  <h3>🧾 지출 내역</h3>
  <div class="li" v-for="(expense, index) in expenses" :key="index">
    {{ expense.item }}: {{ expense.amount.toLocaleString('ko-KR') }}원
  </div>
</template>

<script setup>
const props = defineProps({ expenses: { type: Array, required: true } });
</script>
