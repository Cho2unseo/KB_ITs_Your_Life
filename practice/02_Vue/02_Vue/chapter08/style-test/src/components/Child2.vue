<template>
  <div class="child">
    <h2>Child2</h2>
  </div>
</template>

<script>
export default {
  name: 'Child2',
};
</script>

<style scoped>
/* scoped를 붙이면 해당 컴포넌트 내에서만 스타일 적용 */
.child {
  background-color: blue;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
