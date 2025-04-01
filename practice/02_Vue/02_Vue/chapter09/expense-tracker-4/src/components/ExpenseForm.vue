<template>
  <div>
    <input type="text" v-model="item" placeholder="항목명 입력" />
    <input type="text" v-model.number="amount" />
    <button @click="addExpenseHandler"><b>추가</b></button>
  </div>
</template>

<script>
import { ref } from 'vue';

export default {
  name: 'ExpenseForm',
  setup(props, context) {
    const item = ref('');
    const amount = ref(0);
    const addExpenseHandler = () => {
      if (amount.value > 0)
        context.emit('add-expense', { item: item.value, amount: amount.value });
      item.value = '';
      amount.value = 0;
    };

    return { item, amount, addExpenseHandler };
  },
};
</script>

<style scoped>
input {
  margin: 5px;
  padding: 10px;
  border: solid 1px gray;
  color: white;
  background-color: #272727;
  border-radius: 5px;
}

button {
  padding: 15px;
  background-color: rgb(98, 224, 182);
  border: none;
  border-radius: 10px;
}
</style>
