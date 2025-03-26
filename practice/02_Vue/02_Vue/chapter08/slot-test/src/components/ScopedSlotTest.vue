<template>
  <div>
    <h3>당신이 경험한 프론트엔드 기술은? (네번째: ScopedSlot)</h3>
    <CheckBoxList :items="items" @check-changed="CheckBoxChanged">
      <!-- p1이라는 객체 이름은 슬롯 내부에서만 접근 가능 -->
      <template v-slot:icon="p1">
        <i v-if="p1.checked" class="far fa-grin-beam"></i>
        <i v-else class="far fa-frown"></i>
      </template>
      <template v-slot:default="p2">
        <span v-if="p2.checked" style="color: blue; text-decoration: underline"
          ><i>{{ p2.label }}</i></span
        >
        <span v-else style="color: gray">{{ p2.label }}</span>
      </template>
    </CheckBoxList>
  </div>
</template>

<script>
import CheckBoxList from './CheckBoxList.vue';

export default {
  name: 'ScopedSlotTest',
  components: { CheckBoxList },
  data() {
    return {
      items: [
        { id: 'V', checked: true, label: 'Vue' },
        { id: 'A', checked: false, label: 'Angular' },
        { id: 'R', checked: false, label: 'React' },
        { id: 'S', checked: false, label: 'Svelte' },
      ],
    };
  },
  methods: {
    CheckBoxChanged(e) {
      // 받아온 객체의 id를 items 배열에서 찾아서 일치하는 객체 반환
      let item = this.items.find((item) => item.id === e.id);
      // 찾은 객체의 checked를 받아온 값으로 반환
      item.checked = e.checked;
    },
  },
};
</script>

<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css');
</style>
