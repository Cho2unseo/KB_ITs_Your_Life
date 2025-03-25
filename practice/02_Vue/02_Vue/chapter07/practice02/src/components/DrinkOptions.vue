<template>
  <div class="choice">
    <h1>{{ selectedDrink }} 옵션 선택</h1>
    사이즈:<br /><br />
    <label>
      <input
        type="radio"
        v-model="options.size"
        value="Small"
        @change="optionsChanged"
      />Small
    </label>
    <label>
      <input
        type="radio"
        v-model="options.size"
        value="Medium"
        checked="checked"
        @change="optionsChanged"
      />Medium
    </label>
    <label>
      <input
        type="radio"
        v-model="options.size"
        value="Large"
        @change="optionsChanged"
      />Large
    </label>
    <br /><br />
    <input type="checkbox" v-model="options.extra" @change="optionsChanged" />샷
    추가<br /><br />
    <span>
      얼음 양:
      <select v-model="options.ice" @change="optionsChanged">
        <option>적게</option>
        <option>보통</option>
        <option>많이</option>
      </select>
    </span>
  </div>
</template>

<script>
export default {
  name: 'DrinkOptions',
  props: ['selectedDrink'],
  data() {
    return {
      options: {
        size: 'medium',
        extra: false,
        ice: '보통',
      },
    };
  },
  methods: {
    optionsChanged() {
      this.$emit('option-changed', { ...this.options });
    },
  },
};
</script>

<style>
.choice {
  background-color: rgb(234, 246, 251);
  padding: 20px;
  border-style: ridge;
  border-width: 1px;
}
</style>
