<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <DoneListItem
          v-for="doneItem in doneList"
          :key="doneItem.id"
          :doneItem="doneItem"
          @delete-done="$emit('delete-done', doneItem.id)"
          @toggle-uncompleted="$emit('toggle-uncompleted', doneItem.id)"
        />
      </ul>
    </div>
  </div>
</template>

<script setup>
import DoneListItem from './DoneListItem.vue';

const props = defineProps({
  doneList: { type: Array, required: true },
});
const emit = defineEmits(['delete-done', 'toggle-completed']);
</script>
