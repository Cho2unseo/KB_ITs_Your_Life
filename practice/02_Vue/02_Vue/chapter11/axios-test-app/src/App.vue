<template>
  <div>
    <h2>콘솔을 확인합니다.</h2>
  </div>
</template>

<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = () => {
  // const url = 'https://localhost:3000/todos/1';
  let todoList = [];
  axios
    .get(listUrl)
    .then((response) => {
      todoList = response.data;
      console.log('# TodoList : ', todoList);
      return todoList[0].id;
    })
    .then((id) => {
      // 첫번째 todo 가져오기
      return axios.get(todoUrlPrefix + id);
    })
    .then((response) => {
      // 가져온 첫번째 todo 출력하고 두번째 todo 아이디 리턴
      console.log('## 첫번째 Todo : ', response.data);
      return todoList[1].id;
    })
    .then((id) => {
      axios.get(todoUrlPrefix + id).then((response) => {
        console.log('## 두번째 Todo : ', response.data);
      });
    });
};

requestAPI();
</script>
