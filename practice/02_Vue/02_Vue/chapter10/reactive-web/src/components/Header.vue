<template>
    <nav class="navbar navbar-expand-md bg-blue navbar-blue mt-2">
      <span class="navbar-brand">Fake Store</span>
      <button class="navbar-toggler" type="button" @click="changeIsNavShow">
        <span class="navbar-toggler-icon"></span>
      </button>
  
      <div :class="navClass">
        <ul class="navbar-nav">
          <li class="nav-item">
            <!-- router-link는 a 태그처럼 동작, to 경로로 이동 -->
            <!-- router/index.js 에 명시된 to 경로와 연결된 컴포넌트로 이동 -->
            <router-link class="nav-link" to="/appliance">가전</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/jewerly">주얼리</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/men">남성의류</router-link>
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/women">여성의류</router-link>
          </li>
        </ul>
      </div>
    </nav>
  </template>
  
  <script>
  import { reactive, computed } from 'vue';
  
  export default {
    setup() {
      const state = reactive({ isNavShow: false });
  
      // isNavShow 값에 따라서 각각 다른 클래스가 바인딩된다.
      const navClass = computed(() =>
        state.isNavShow
          ? 'collapse navbar-collapse show'
          : 'collapse navbar-collapse'
      );
  
      const changeIsNavShow = () => {
        // isNavShow 값을 반대로 변경
        state.isNavShow = !state.isNavShow;
      };
  
      return { state, changeIsNavShow, navClass };
    },
  };
  </script>
  