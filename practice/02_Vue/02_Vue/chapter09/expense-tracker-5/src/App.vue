<template>
  <div class="main">
    <h1>💸 Simple Budget Diary</h1>
    <br />
    <ExpenseForm @add-expense="addExpense" /><br />
    <ExpenseList
      :expenses="state.expenses"
      @delete-expense="deleteExpense"
      :calculateMeal="calculateMeal"
      :calculateTransport="calculateTransport"
      :calculateShopping="calculateShopping"
    />
    <br />
    <TotalDisplay :expense="calculateResult" :formatNumber="formatNumber" />
  </div>
</template>

<script>
import { reactive, computed } from 'vue';
import ExpenseForm from './components/ExpenseForm.vue';
import TotalDisplay from './components/TotalDisplay.vue';
import ExpenseList from './components/ExpenseList.vue';

export default {
  name: 'App',
  components: { ExpenseForm, TotalDisplay, ExpenseList },
  setup() {
    const state = reactive({ expenses: [] });
    const addExpense = (expense) => {
      state.expenses.push({
        item: expense.item,
        amount: expense.amount,
        category: expense.category,
      });
    };
    const calculateResult = computed(() => {
      let res = 0;
      state.expenses.forEach((e) => (res += e.amount));
      return res;
    });
    const formatNumber = (total) => {
      return `₩${total.toLocaleString('ko-KR')}`;
    };
    const deleteExpense = (index) => {
      state.expenses.splice(index, 1);
    };
    const calculateMeal = computed(() => {
      let res = 0;
      state.expenses.forEach((e) => {
        if (e.category === '식비') {
          res += e.amount;
        }
      });
      return res;
    });
    const calculateTransport = computed(() => {
      let res = 0;
      state.expenses.forEach((e) => {
        if (e.category === '교통') {
          res += e.amount;
        }
      });
      return res;
    });
    const calculateShopping = computed(() => {
      let res = 0;
      state.expenses.forEach((e) => {
        if (e.category === '쇼핑') {
          res += e.amount;
        }
      });
      return res;
    });
    return {
      state,
      addExpense,
      calculateResult,
      formatNumber,
      deleteExpense,
      calculateMeal,
      calculateTransport,
      calculateShopping,
    };
  },
};
</script>

<style>
.main {
  width: auto;
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
