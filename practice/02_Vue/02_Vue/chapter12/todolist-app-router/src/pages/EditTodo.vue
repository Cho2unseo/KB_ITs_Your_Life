<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일 수정</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할일 : </label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명 : </label>
        <textarea
          class="form-control"
          rows="3"
          id="desc"
          v-model="todoItem.desc"
        ></textarea>
      </div>
      <div class="form-group">
        <label htmlFor="done">완료여부 : </label>&nbsp;
        <input type="checkbox" v-model="todoItem.done" />
      </div>
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="updateTodoHandler"
        >
          수 정
        </button>
      </div>
      <div class="form-group">
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취 소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter, useRoute } from 'vue-router';
import { inject, reactive } from 'vue';

const router = useRouter();
const todoList = inject('todoList');
const { updateTodo } = inject('actions');
const currentRoute = useRouter();

// edit/1 경로라면 뒤에 있는 id 값인 1을 추출해서 해당하는 객체 반환
const matchedTodoItem = todoList.value.find(
  (item) => item.id === currentRoute.params.id
);
if (!matchedTodoItem) {
  router.push('/todos');
}
// 찾아온 객체를 반응형으로 복사
const todoItem = reactive({ ...matchedTodoItem });

const updateTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    // todo의 유효성 검사
    alert('할일은 반드시 입력해야 합니다.');
    return;
  }
  updateTodo({ ...todoItem }, () => {
    router.push('/todos');
  });
};
</script>
