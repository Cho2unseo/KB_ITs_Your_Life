<template>
  <div class="button-container">
    <button @click="handleClick">🎬 대사 준비 완료</button>
    <br /><br />
    <p>버튼을 누른 횟수: {{ count }}회</p>
    <br />
    <slot name="ment">여기에 서윤이의 코멘트가 들어갑니다.</slot>
  </div>
</template>

<script>
export default {
  name: 'LineReadyButton',
  data() {
    return {
      count: 0,
    };
  },
  methods: {
    handleClick() {
      this.count++;
      console.log('대사 준비 완료!');
      // this.$emit('ready', `대사 준비 완료! 총 ${this.count}회 눌림`);
    },
  },
};
</script>

<style scoped>
.button-container {
  text-align: center;
}
button {
  padding: 10px;
  background-color: #ff7675;
  color: white;
  border-radius: 12px;
  border-style: none;
}
button:hover {
  background-color: #d63031;
}
</style>
