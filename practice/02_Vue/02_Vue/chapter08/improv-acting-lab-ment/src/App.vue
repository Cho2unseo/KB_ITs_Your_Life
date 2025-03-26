<template>
  <div class="container">
    <h1>improv-acting-lab 🎭</h1>
    <br />
    <LineReadyButton @ready="handleReady">
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
  </div>
</template>

<script>
import LineReadyButton from './components/LineReadyButton.vue';
import LineCard from './components/LineCard.vue';

export default {
  name: 'App',
  components: { LineReadyButton },
  methods: {
    handleReady(e) {
      console.log(e);
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
</style>
