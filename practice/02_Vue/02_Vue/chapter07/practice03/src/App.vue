<template>
  <div class="container">
    <h1>카페 주문 앱</h1>
    <MenuList :menus="menuList" @select-drink="selectDrinkHandler" />
    <p v-if="selectedDrink">선택한 음료: {{ selectedDrink.name }}</p>
    <DrinkOptions
      v-if="selectedDrink"
      :selectedDrink="selectedDrink"
      @option-changed="selectOptionsHandler"
    ></DrinkOptions>
    <div class="print" v-if="selectedDrink && selectedOptions">
      <span style="font-size: 20px">현재 선택 옵션:</span> <br /><br />
      <span>사이즈: {{ selectedOptions.size }}<br /><br /></span>
      <span
        >추가샷: {{ selectedOptions.extra ? '추가함' : '없음' }} <br /><br
      /></span>
      <span>얼음 양: {{ selectedOptions.ice }}</span>
    </div>
    <OrderSummary
      v-if="selectedDrink && selectedOptions"
      :drink="selectedDrink"
      :optionData="selectedOptions"
    ></OrderSummary>
  </div>
</template>

<script>
import MenuList from './components/MenuList.vue';
import DrinkOptions from './components/DrinkOptions.vue';
import OrderSummary from './components/OrderSummary.vue';

export default {
  name: 'App',
  components: { MenuList, DrinkOptions, OrderSummary },
  data() {
    return {
      menuList: [
        { name: '아메리카노', price: 4000 },
        { name: '카페라떼', price: 4500 },
        { name: '바닐라라떼', price: 4800 },
        { name: '콜드브루', price: 5000 },
      ],
      selectedDrink: null,
      selectedOptions: {
        size: 'Medium',
        extra: false,
        ice: '보통',
      },
    };
  },
  methods: {
    selectDrinkHandler(e) {
      this.selectedDrink = e;
    },
    selectOptionsHandler(e) {
      this.selectedOptions = e;
    },
  },
};
</script>

<style>
button {
  margin: 5px;
  padding: 10px;
  cursor: pointer;
}

p {
  background-color: rgb(240, 240, 240);
  padding: 20px;
  border-style: ridge;
  border-width: 1px;
}

.print {
  background-color: rgb(240, 240, 240);
  margin: 10px 0;
  padding: 20px;
  border-style: ridge;
  border-width: 1px;
}
</style>
