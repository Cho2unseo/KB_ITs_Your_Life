<template>
  <div class="checkorder">
    <h1>🧾 주문 내역서</h1>
    <span>주문 시간: {{ currentTime }} </span><br />
    <hr />
    <div>
      <span>음료: {{ drink.name }}</span
      ><br />
      <span>사이즈: {{ optionData.size }}</span
      ><br />
      <span>추가 샷: {{ optionData.extra ? '추가함' : '없음' }}</span
      ><br />
      <span>얼음 양: {{ optionData.ice }}</span
      ><br />
    </div>
    <hr />
    <span>결제 금액: {{ drink.price.toLocaleString('ko-KR') }}원</span><br />
    <button
      style="
        border-radius: 10px;
        color: white;
        background-color: #d2b48c;
        border: none;
      "
      @click="$emit('place-order', drink.name)"
    >
      주문 확정하기
    </button>
  </div>
</template>

<script>
export default {
  name: 'OrderSummary',
  props: ['drink', 'optionData'],
  computed: {
    currentTime() {
      let time = new Date();
      return `${time.toLocaleString()}`;
    },
  },
};
</script>

<style scoped>
.checkorder {
  border: solid 1px #d2b48c;
  background-color: #fffaf0;
  padding: 10px;
  border-radius: 10px;
}
hr {
  border: 1px dashed #d2b48c;
}
</style>
