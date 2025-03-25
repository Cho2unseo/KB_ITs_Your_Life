<template>
  <!-- 부모에서 객체를 통째로 넘겨줬기 때문에 자식에서 객체 접근 필요 -->
  <li><input type="checkbox" :checked="checked" />{{ id }} - {{ name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  props: {
    id: [Number, String], // id 값은 Number나 String 타입
    name: String, // name 값은 String 타입
    checked: {
      // checked 값은 Boolean 타입이고 필수값이 아니며, 기본값은 false
      type: Boolean,
      required: false,
      default: false,
    },
  },
};
</script>
