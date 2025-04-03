<template>
  <nav class="navbar navbar-expand-sm justify-content-center">
    <ul class="navbar-nav gap-5">
      <li class="nav-item">
        <router-link class="nav-item" to="/">홈</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-item" to="/products">상품목록</router-link>
      </li>
      <li class="nav-item">
        <router-link class="nav-item" to="/cart">장바구니</router-link>
      </li>
    </ul>
  </nav>
</template>

<style scoped>
.navbar {
  height: 80px;
  box-shadow: 0px 4px 0px 0px rgb(237, 237, 237);
}
.nav-item {
  text-decoration: none;
  color: black;
}
.router-link-active {
  color: rgb(47, 137, 182);
  font-weight: bold;
}
</style>
