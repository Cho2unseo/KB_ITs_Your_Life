import { ref, computed, reactive } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

const initState = {
  token: '',
  user: {
    username: '',
    email: '',
    roles: [],
  },
};

// 스토어 정의
export const useAuthStore = defineStore('auth', () => {
  const state = ref({ ...initState });
  // 로그인 여부, !!: 강제로 boolean 형변환
  const isLogin = computed(() => !!state.value.user.username);
  const username = computed(() => state.value.user.username);
  // 로그인된 사용자 이메일
  const email = computed(() => state.value.user.email);

  const login = async (member) => {
    // state.value.token = 'test token';
    // state.value.user = {
    //   username: member.username,
    //   email: member.username + '@test.com',
    // };
    console.log('member : ', member);
    const { data } = await axios.post('/api/auth/login', member);
    console.log('data : ', data);
    state.value = { ...data };

    // 'auth'라는 키에 JSON 직렬화해서 로컬 스토리지에 저장
    localStorage.setItem('auth', JSON.stringify(state.value));
  };

  // 로그아웃 함수
  const logout = () => {
    localStorage.clear(); // localStorage 제거
    state.value = { ...initState }; // 상태 초기화
  };

  // 토큰 조회 함수
  const getToken = () => state.value.token;

  // 초기 상태 로딩 (새로고침 시 유지)
  const load = () => {
    const auth = localStorage.getItem('auth');
    if (auth != null) {
      // 로컬 스토리지에 있던 데이터 역직렬화
      state.value = JSON.parse(auth);
      console.log(state.value);
    }
  };

  load();

  return { state, username, email, isLogin, login, logout, getToken };
});
