<template>
  <div class="history">
    <h2>📜 주문 내역</h2>
    <p v-if="orders.length == 0">주문 내역이 없습니다.</p>
    <ul>
      <li v-for="(order, index) in orders" :key="index">
        ⏱️ {{ order.time }}<br />
        음료: {{ order.drinkName }}<br />
        사이즈: {{ order.size }}<br />
        추가샷: {{ order.extraShot ? '추가함' : '없음' }} <br />
        얼음 양: {{ order.ice }} <br />
        금액: {{ order.price.toLocaleString('ko-KR') }}원
        <hr />
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'OrderHistory',
  props: ['orders'],
};
</script>

<style scoped>
.history {
  background-color: rgb(241, 241, 241);
  padding: 10px;
  border: 1px solid rgb(200, 200, 200);
  border-radius: 10px;
  margin: 10px 0px;
}
li {
  list-style-type: none;
}
ul {
  padding: 0;
  margin: 10px;
}
hr {
  border: 1px dashed #bfbfbf;
}
</style>
