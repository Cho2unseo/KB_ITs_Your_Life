<template>
  <div class="container">
    <div class="card card-body bg-light">
      <div class="title">:: Todolist App</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo"></InputTodo>
        <TodoList
          :todoList="state.todoList.filter((item) => !item.completed)"
          @delete-todo="deleteTodo"
          @toggle-completed="toggleCompleted"
        ></TodoList>
      </div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <DoneList
          :doneList="statedone.doneList.filter((item) => item.completed)"
          @delete-done="deleteDone"
          @toggle-uncompleted="toggleUncoompleted"
        ></DoneList>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive, onMounted, compile } from 'vue';
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';
import DoneList from './components/DoneList.vue';

const ts = new Date().getTime();
const state = reactive({ todoList: [] });
const statedone = reactive({ doneList: [] });

onMounted(() => {
  state.todoList.push({ id: ts, todo: '자전거 타기', completed: false });
  state.todoList.push({
    id: ts + 1,
    todo: '딸과 공원 산책',
    completed: false,
  });
  state.todoList.push({
    id: ts + 2,
    todo: '일요일 애견 카페',
    completed: false,
  });
  state.todoList.push({
    id: ts + 3,
    todo: 'Vue 원고 집필',
    completed: false,
  });
});
const addTodo = (todo) => {
  if (todo.length >= 2) {
    state.todoList.push({
      id: new Date().getTime(),
      todo: todo,
      completed: false,
    });
  }
};
const deleteTodo = (id) => {
  let index = state.todoList.findIndex((item) => id === item.id);
  state.todoList.splice(index, 1);
};
const deleteDone = (id) => {
  let index = statedone.doneList.findIndex((item) => id === item.id);
  statedone.doneList.splice(index, 1);
};
const toggleCompleted = (id) => {
  let index = state.todoList.findIndex((item) => id === item.id);
  statedone.doneList.push({
    id: state.todoList[index].id,
    todo: state.todoList[index].todo,
    completed: true,
  });
  state.todoList.splice(index, 1);
};

const toggleUncoompleted = (id) => {
  let index = statedone.doneList.findIndex((item) => id === item.id);
  state.todoList.push({
    id: statedone.doneList[index].id,
    todo: statedone.doneList[index].todo,
    completed: false,
  });
  statedone.doneList.splice(index, 1);
};
</script>
