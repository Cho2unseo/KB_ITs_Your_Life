<template>
  <div>
    <h2>최신 인기곡</h2>
    <!-- SongList에 songs 배열을 props로 전달 -->
    <SongList :songs="songs" />
    <br /><br />
    <button @click="changeModal">Teleport를 이용한 Modal 기능</button>
    <!-- id가 modal인 영역을 찾아서 isModal 값에 의해 보여주기 -->
    <Teleport to="#modal">
      <Modal v-if="isModal" />
    </Teleport>
  </div>
</template>

<script>
import { computed } from 'vue';
import SongList from './components/SongList.vue';
import Modal from './components/Modal.vue';

export default {
  name: 'App',
  components: { SongList, Modal },
  data() {
    return {
      songs: [
        { id: 1, title: 'Blueming', done: true },
        { id: 2, title: 'Dynamite', done: false },
        { id: 3, title: 'Lovesick Girls', done: true },
        { id: 4, title: '마리아(Maria)', done: false },
      ],
      isModal: false,
    };
  },
  methods: {
    changeModal() {
      // 잠시 보여줬다가 2초 후에 모달 사라지기
      this.isModal = true;
      setTimeout(() => {
        this.isModal = false;
      }, 2000);
    },
  },
  // provide : 하위 요소 어디든 주입받을 수 있도록 상위요소에서 제공
  provide() {
    return {
      icons: {
        checked: 'far fa-check-circle',
        unchecked: 'far fa-circle',
      },
      // songs 배열 중 done이 true인 곡의 길이 계산
      doneCount: computed(() => {
        return this.songs.filter((s) => s.done === true).length;
      }),
    };
  },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css');
</style>
