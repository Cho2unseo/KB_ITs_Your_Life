<script setup>
import MenuItem from './MenuItem.vue';
const props = defineProps({
  menus: { Type: Array, required: true },
});
</script>

<template>
  <ul class="navbar-nav">
    <!-- :menu는 자식한테 넘겨줄 props -->
    <MenuItem v-for="menu in menus" :menu="menu" />
  </ul>
</template>
