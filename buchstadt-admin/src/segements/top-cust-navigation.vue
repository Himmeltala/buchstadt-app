<script setup lang="ts">
const userInfo = JSON.parse(localStorage.getItem("userInfo"));
</script>

<template>
  <div f-c-b b-b="width-1 solid #DCDCDC" pb-2 mt-2>
    <div text-gray-7 f-c-s>
      <div mr-10>用户：{{ userInfo.username }}</div>
      <div>
        权限：<span font-bold>{{ userInfo.authority }}</span>
      </div>
    </div>
    <div>
      <img :src="userInfo.profilePhoto" rd-50 w-10 h-10 />
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
