<script setup lang="ts">
import { queryOne } from "@root/api/api-publisher";

const route = useRoute();
const id = Number(route.params.id as string);

const data = reactive(await queryOne({ id }));
</script>

<template>
  <el-descriptions title="当前预览" :column="2" border>
    <template #extra>
      <el-button plain type="success" @click="$router.back()">返回上一级</el-button>
    </template>
    <el-descriptions-item>
      <template #label>
        <div>出版社ID</div>
      </template>
      <div>{{ data.id }}</div>
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        <div>出版社名称</div>
      </template>
      <div>{{ data.name }}</div>
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        <div>简介</div>
      </template>
      <div>{{ data.profile }}</div>
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        <div>拥有图书</div>
      </template>
      <div>{{ data.buchs.length }}</div>
    </el-descriptions-item>
    <el-descriptions-item>
      <template #label>
        <div>图标</div>
      </template>
      <img :src="data.profilePhoto" />
    </el-descriptions-item>
  </el-descriptions>
  <div class="f-c-s mt-10 flex-wrap">
    <div v-for="item in data.buchs" class="w-45 mr-5">
      <img class="w-40 h-40 object-cover" :src="item.cover" />
      <div class="mt-4 text-ellipsis line-clamp-2">
        {{ item.name }}
      </div>
      <div class="mt-2 text-gray-4 size-13px">原价：¥{{ item.price }}</div>
      <div class="mt-2 text-red">折扣：¥{{ item.price * item.discount }}</div>
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
