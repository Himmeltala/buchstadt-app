<template>
  <div class="page-content">
    <el-result class="my-24" icon="success" title="支付成功" sub-title="你的购物车已清空，请查看我的订单！">
      <template #extra>
        <el-button type="primary" @click="$router.push('/orders')">查看我的订单</el-button>
      </template>
    </el-result>
  </div>
</template>

<script setup lang="ts"></script>
