<template>
  <div class="page-content">
    <el-tabs v-model="activeName" type="border-card" @tab-change="changeTab">
      <el-tab-pane label="已付款" name="买家已付款">
        <orders-data :data="indents" />
      </el-tab-pane>
      <el-tab-pane label="待收货" name="买家等待收货">
        <orders-data :data="indents" />
      </el-tab-pane>
      <el-tab-pane label="已收货" name="买家确认收货">
        <orders-data :data="indents" />
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script setup lang="ts">
import { IntentApi } from "@/apis";

const indents = ref();
const activeName = ref("买家已付款");

async function fetchData(status: string) {
  indents.value = await IntentApi.query(status);
}

async function changeTab(status: any) {
  await fetchData(status);
}

await fetchData(activeName.value);
</script>
