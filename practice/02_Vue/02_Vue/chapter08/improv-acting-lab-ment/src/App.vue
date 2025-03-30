<template>
  <div class="container">
    <h1>improv-acting-lab 🎭</h1>
    <br />
    <LineReadyButton @click="cardHandler">
      <template #ment>
        <div
          style="
            background-color: #f1f2f6;
            border: 1px solid #dfe4ea;
            border-radius: 10px;
            padding: 14px;
            width: auto;
            display: inline-block;
            max-width: 400px;
          "
        >
          <i>🎭 준비되면 눌러주세요! 자신감을 가져요!</i>
        </div>
      </template>
    </LineReadyButton>
    <LineCard v-if="isLineReady">
      <template #tip>
        <div class="tips">🎯 TIP: 표정 풍부하게, 발음 또박또박!</div>
      </template>
      <template #image>
        <img
          src="https://www.chosun.com/resizer/v2/QXJOA4UE56AN5ZEOSZ7HGB5DWY.jpg?auth=eb54c39137830bf544cb83b0b1d0ba3c018d5fba479033ba5ddf7df9200269d4&width=464"
          style="width: 300px"
        />
      </template>
      <template #lineLengthcheck="{ lineLength }">
        <p v-if="lineLength > 30">📏 대사가 길어요! 천천히 연기해 보세요.</p>
      </template>
    </LineCard>
  </div>
</template>

<script>
import LineReadyButton from './components/LineReadyButton.vue';
import LineCard from './components/LineCard.vue';

export default {
  name: 'App',
  data() {
    return {
      isLineReady: false,
    };
  },
  components: { LineReadyButton, LineCard },
  methods: {
    cardHandler() {
      this.isLineReady = true;
    },
  },
  provide() {
    return {
      lines: [
        {
          line: '조금은 친절해도 되잖아. 다들 니들처럼 익숙한 게 아니니까.',
          source: '청춘시대',
        },
        {
          line: '너와 함께한 시간 모두 눈부셨다. 날이 좋아서 날이 좋지 않아서 날이 적당해서 모든 날이 좋았다.',
          source: '도깨비',
        },
        {
          line: '당신이 좋은 이유? 그저 그 사람이라서. 바로 너라서.',
          source: '응답하라 1997',
        },
        {
          line: '인생에서 시련 오는 거, 진짜와 가짜를 한 번씩 걸러내라고 하나님이 주신 기회가 아닌가 싶다.',
          source: '별에서 온 그대',
        },
        {
          line: '잊지 말자. 나는 어머니의 자부심이다. 모자라고 부족한 자식이 아니다.',
          source: '미생',
        },
      ],
    };
  },
};
</script>

<style>
.container {
  text-align: center;
}
.tips {
  background-color: rgb(204, 240, 255);
  border: 0px;
  border-radius: 10px;
  padding: 14px;
  margin: 10px;
}
</style>
