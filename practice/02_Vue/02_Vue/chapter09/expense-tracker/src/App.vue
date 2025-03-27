<template>
  <div class="main">
    <h1>💸 Simple Budget Diary</h1>
    <br />
    <ExpenseForm @add-expense="addExpense" /><br />
    <h3>🧾 지출 내역</h3>
    <div class="li" v-for="(expense, index) in state.expenses" :key="index">
      {{ expense.item }}: {{ expense.amount.toLocaleString('ko-KR') }}원
    </div>
    <br />
    <h3>🧮 총 지출: {{ calculateResult.toLocaleString('ko-KR') }}원</h3>
  </div>
</template>

<script>
import { reactive, computed } from 'vue';
import ExpenseForm from './components/ExpenseForm.vue';

export default {
  name: 'App',
  components: { ExpenseForm },
  setup() {
    const state = reactive({ expenses: [] });
    const addExpense = (expense) => {
      state.expenses.push({ item: expense.item, amount: expense.amount });
    };
    const calculateResult = computed(() => {
      let res = 0;
      state.expenses.forEach((e) => (res += e.amount));
      return res;
    });
    return { state, addExpense, calculateResult };
  },
};
</script>

<style>
.main {
  width: 500px;
  background-color: #1e1e1e;
  padding: 20px;
  border-radius: 10px;
  justify-content: center;
}
h1 {
  color: rgb(98, 224, 182);
  font-weight: bolder;
}
h3 {
  font-weight: bolder;
  color: rgb(127, 255, 253);
}
.li {
  color: white;
  background-color: #272727;
  margin: 10px;
  padding: 15px;
  border-radius: 10px;
}
</style>
