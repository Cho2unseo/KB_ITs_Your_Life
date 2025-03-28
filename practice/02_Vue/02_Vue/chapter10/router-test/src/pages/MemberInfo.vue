<template>
  <!-- <div class="card card-body">
    <h2>Member Info</h2>
    <div>
      경로 패턴: /member/:id<br />
      요청 경로: {{ currentRoute.path }}<br />
     params로 해당 경로의 파라미터 중에 id 값만 가져온다 
      id값: {{ currentRoute.params.id }}<br />
    </div>
  </div> -->

  <div class="mt-5">
    <img :src="member.photo" class="img" />
    <h4 class="mt-2">{{ member.name }}({{ member.role }})</h4>
    <p>{{ member.desc }}</p>
    <!-- insta 정보가 있는 경우에만 링크 생성 -->
    <a
      v-if="member.insta && member.insta !== ''"
      class="fa-brands fa-instagram m-1"
      :href="member.insta"
    ></a>
    <a
      v-if="member.facebook && member.facebook !== ''"
      class="fa-brands fa-facebook m-1"
      :href="member.facebook"
    ></a>
    <a
      v-if="member.youtube && member.youtube !== ''"
      class="fa-brands fa-youtube m-1"
      :href="member.youtube"
    ></a>
    <br /><br />
    <router-link :to="{ name: 'members' }">멤버 목록으로</router-link>
  </div>
</template>

<script>
import { useRoute } from 'vue-router';
import members from '@/members.json';

export default {
  name: 'MemberInfo',
  setup() {
    const currentRoute = useRoute();
    // 경로 내의 데이터는 문자열이기 때문에 파싱 필요
    const id = parseInt(currentRoute.params.id, 10);
    // 경로에 있는 아이디와 일치하는 데이터를 json에서 찾는다
    const member = members.find((m) => m.id === id);
    // 템플릿에서 쓸 것만 리턴해주면 됨
    return { member };
  },
};
</script>
