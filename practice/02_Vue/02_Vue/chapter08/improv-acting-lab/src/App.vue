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
          <i>오늘도 넌 멋질 거야! 🎤 자신 있게 무대에 올라가!</i>
        </div>
      </template>
    </LineReadyButton>
  </div>
</template>

<script>
import LineReadyButton from './components/LineReadyButton.vue';
export default {
  name: 'App',
  components: { LineReadyButton },
  methods: {
    handleReady(e) {
      console.log(e);
    },
  },
};
</script>

<style>
.container {
  text-align: center;
}
</style>
