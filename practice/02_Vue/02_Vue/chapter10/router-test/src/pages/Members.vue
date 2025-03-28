<template>
  <div>
    <h2 class="m-4">이날치 멤버</h2>
    <div class="container">
      <div class="row">
        <!-- 칸의 크기에 따라 한 줄에 나오는 데이터 개수가 달라진다 -->
        <div
          v-for="m in members"
          :key="m.id"
          class="col-6 col-xs-6 col-sm-4 col-md-3 col-lg-2"
        >
          <!-- 현재 돌고있는 객체의 id 값을 경로에 넣어준다. -->
          <!-- 파라미터 값은 params로 객체에 담아서 넘겨줄 수 있다. -->
          <router-link :to="{ name: 'members/id', params: { id: m.id } }">
            <img
              class="img-thumbnail"
              style="width: 90px; height: 110px"
              :src="m.photo"
              :title="m.name"
            /><br />
            <h6 class="display-7">{{ m.name }}</h6>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import members from '@/members.json';

export default {
  name: 'Members',
  setup() {
    return { members };
  },
};
</script>
