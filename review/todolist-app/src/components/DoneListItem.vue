<template>
  <li
    class="list-group-item"
    :class="{ 'list-group-item-success': doneItem.completed }"
    @click="$emit('toggle-uncompleted', doneItem.id)"
  >
    <span class="pointer" :class="{ 'todo-done': doneItem.completed }"
      >{{ doneItem.todo }} {{ doneItem.completed ? '(완료)' : '' }}</span
    >
    <span
      class="float-end badge bg-secondary pointer"
      @click.stop="$emit('delete-done', doneItem.id)"
      >삭제</span
    >
  </li>
</template>

<script setup>
const props = defineProps({
  doneItem: { type: Object, required: true },
});
const emit = defineEmits(['delete-done', 'toggle-uncompleted']);
</script>
