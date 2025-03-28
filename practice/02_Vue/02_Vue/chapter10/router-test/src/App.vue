<template>
  <div class="container">
    <Header />
    <!-- router-view 부분에는 경로에 따라 다른 컴포넌트가 렌더링된다. -->
    <router-view></router-view>
  </div>
</template>

<script>
import Header from '@/components/Header.vue';
import videos from '@/videos.json';
import { provide } from 'vue';

export default {
  name: 'App',
  components: { Header },
  setup() {
    // 하위 컴포넌트에서 videos 배열 모두 사용할 수 있도록 provide
    provide('videos', videos);
  },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css');
.container {
  text-align: center;
  margin-top: 10px;
}
/* 기존 font-awesome 스타일 커스터마이징 */
.fa {
  padding: 5px;
  width: 30px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
}
.fa-facebook {
  background: #3b5998;
  color: white;
}
.fa-youtube {
  background: #bb0000;
  color: white;
}
.fa-instagram {
  background: #125688;
  color: white;
}
</style>
