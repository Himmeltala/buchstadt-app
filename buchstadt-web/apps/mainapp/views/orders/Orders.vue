<script setup lang="ts">
import { queryAll } from "@mainapp/apis/api-orders";

const orderList = ref();
const activeName = ref("买家已付款");

async function fetchData(status: string) {
  orderList.value = await queryAll(status);
}

async function changeTab(status: any) {
  await fetchData(status);
}

function onDelOrder(index: any) {
  orderList.value.splice(index, 1);
}

await fetchData(activeName.value);
</script>

<template>
  <div class="page-content">
    <el-tabs class="mx-10 my-10" v-model="activeName" type="border-card" @tab-change="changeTab">
      <el-tab-pane label="已付款" name="买家已付款">
        <OrdersData :data="orderList" />
      </el-tab-pane>
      <el-tab-pane label="待收货" name="买家等待收货">
        <OrdersData :data="orderList" />
      </el-tab-pane>
      <el-tab-pane label="已收货" name="买家确认收货">
        <OrdersData @on-del="onDelOrder" :data="orderList" />
      </el-tab-pane>
    </el-tabs>
  </div>
</template>
