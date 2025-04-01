<template>
  <div>
    <h3>🧮 총 지출: {{ formatNumber(expense) }}</h3>
  </div>
</template>

<script setup>
const props = defineProps({
  expense: { type: Number, required: true },
  formatNumber: { type: Function, required: true },
});
</script>
