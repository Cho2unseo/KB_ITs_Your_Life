<template>
  <div class="container">
    <h1>카페 주문 앱</h1>
    <MenuList :menus="menuList" @select-drink="selectDrinkHandler" />
    <p v-if="selectedDrink">선택한 음료: {{ selectedDrink }}</p>
  </div>
</template>

<script>
import MenuList from './components/MenuList.vue';
export default {
  name: 'App',
  components: { MenuList },
  data() {
    return {
      menuList: [
        { name: '아메리카노', price: 4000 },
        { name: '카페라떼', price: 4500 },
        { name: '바닐라라떼', price: 4800 },
        { name: '콜드브루', price: 5000 },
      ],
      selectedDrink: '',
    };
  },
  methods: {
    selectDrinkHandler(e) {
      this.selectedDrink = e;
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
</style>
