<script setup lang="ts">
import { queryOne } from "@subapp-admin/apis/api-pub";

const route = useRoute();
const id = Number(route.params.id as string);

const data = reactive(await queryOne(id));
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
  <div class="f-c-b mt-10 flex-wrap flex-gap-15">
    <BuchItem
      v-for="item in data.buchs"
      :key="item.id"
      :id="item.id"
      :name="item.name"
      :price="item.price"
      :discount="item.discount"
      :cover="item.cover">
    </BuchItem>
  </div>
</template>

<style scoped lang="scss"></style>
