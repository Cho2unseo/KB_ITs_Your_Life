<template>
  <div>
    <h3>🧮 총 지출: {{ expenses }}원</h3>
  </div>
</template>

<script setup>
const props = defineProps({
  expense: { type: Number, required: true },
});

const emit = defineEmits(['calculate-result', 'format-number']);
const calculateHandler = () => {
  const expense = this.formatNumber(this.calculateResult);
  emit('calculate-result', expense);
  return expense;
};
</script>
