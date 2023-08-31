<script setup lang="ts">
const user = localStorage.getUser();
</script>

<template>
  <div f-c-b b-b="width-1 solid #DCDCDC" pb-2 mt-2>
    <div text-gray-7 f-c-s>
      <div mr-10>用户：{{ user.username }}</div>
      <div>
        权限：<span font-bold>{{ user.authority }}</span>
      </div>
    </div>
    <div>
      <img :src="user.profilePhoto" rd-50 w-10 h-10 />
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
