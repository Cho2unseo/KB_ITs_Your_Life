<script setup>
import { useCounterStore } from '@/stores/counter';
import { computed } from 'vue';

const store = useCounterStore();
const { increment } = store; // 함수는 분해할당
const count = computed(() => store.count); // 데이터는 computed
// const count = store.count;
increment();
console.log(count);
</script>

<template>
  {{ store.count }} / {{ store.doubleCount }} <br />
  {{ count }}
  <!-- count는 최초의 값만 가짐 -->
</template>
