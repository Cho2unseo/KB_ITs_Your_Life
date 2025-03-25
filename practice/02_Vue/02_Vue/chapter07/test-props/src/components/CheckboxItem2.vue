<template>
  <!-- 부모에서 객체를 통째로 넘겨줬기 때문에 자식에서 객체 접근 필요 -->
  <li><input type="checkbox" :checked="idol.checked" />{{ idol.name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem2',
  props: ['idol'],
};
</script>
