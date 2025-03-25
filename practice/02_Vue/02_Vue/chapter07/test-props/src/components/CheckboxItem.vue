<template>
  <!-- 체크박스의 채크여부 = '부모한테서 받아온 불린값' -->
  <li><input type="checkbox" :checked="checked" />{{ name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',
  // 부모 컴포넌트에게서 받아온 속성 배열
  props: ['name', 'checked'],
};
</script>
