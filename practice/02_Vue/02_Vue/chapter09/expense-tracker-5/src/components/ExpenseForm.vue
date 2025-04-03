<template>
  <div>
    <input type="text" v-model="item" placeholder="항목명 입력" />
    <input type="text" v-model.number="amount" />
    <select v-model="category">
      <option value="카테고리 선택" disabled>카테고리 선택</option>
      <option value="식비">식비</option>
      <option value="교통">교통</option>
      <option value="쇼핑">쇼핑</option>
    </select>
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
    const category = ref('카테고리 선택');
    const addExpenseHandler = () => {
      if (amount.value > 0)
        context.emit('add-expense', {
          item: item.value,
          amount: amount.value,
          category: category.value,
        });
      item.value = '';
      amount.value = 0;
      category.value = '카테고리 선택';
    };

    return { item, amount, addExpenseHandler, category };
  },
};
</script>

<style scoped>
input,
select {
  margin: 5px;
  padding: 10px;
  border: solid 1px gray;
  color: white;
  background-color: #272727;
  border-radius: 5px;
}

button {
  margin: 10px;
  padding: 15px;
  background-color: rgb(98, 224, 182);
  border: none;
  border-radius: 10px;
}
</style>
