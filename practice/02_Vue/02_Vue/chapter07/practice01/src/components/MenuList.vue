<template>
  <div>
    <h2>메뉴 선택</h2>
    <button
      v-for="menu in menus"
      :key="menu.name"
      @click="$emit('selectDrink', menu.name)"
    >
      {{ menu.name }} ({{ menu.price }}원)
    </button>
  </div>
</template>

<script>
export default {
  name: 'MenuList',
  props: ['menus'],
};
</script>
