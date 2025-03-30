<template>
  <div class="linecarddiv">
    <p>{{ this.currentLine }}</p>
    <p v-if="this.currentSource" style="font-size: 13px; color: gray">
      출처: {{ this.currentSource }}
    </p>
    <button class="random" @click="randomLineMaker">🎲 랜덤 대사 뽑기</button>
    <p>✨ 오늘의 즉흥 대사입니다!</p>
    <slot name="tip">부모가 전달하는 팁</slot>
    <slot name="image">부모가 전달하는 이미지</slot>
    <slot name="lineLengthcheck" :lineLength="this.lineLength"></slot>
  </div>
</template>

<script>
export default {
  name: 'LineCard',
  data() {
    return {
      currentLine: '🎭 아직 대사가 없습니다. 버튼을 눌러주세요!',
      currentSource: '',
      lineLength: 0,
    };
  },
  inject: ['lines'],
  methods: {
    randomLineMaker() {
      const randomValue =
        this.lines[Math.floor(Math.random() * this.lines.length)];
      this.currentLine = randomValue.line;
      this.currentSource = randomValue.source;
      this.lineLength = this.currentLine.length;
    },
  },
};
</script>

<style scoped>
.linecarddiv {
  background-color: #f1f2f6;
  border: 1px solid #dfe4ea;
  border-radius: 10px;
  padding: 14px;
  margin: 10px;
}
.random {
  border-radius: 10px;
  padding: 10px;
  background-color: rgb(91, 122, 246);
  color: white;
  border: 0px;
  margin: 10px;
}
</style>
