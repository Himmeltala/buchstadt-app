<script setup lang="ts">
import { AddressApi } from "@subapp-admin/apis/api-user";

const data = ref(await AddressApi.queryAll());
</script>

<template>
  <el-table class="mb-5" border stripe :data="data" style="width: 100%">
    <el-table-column prop="holder" label="收货人"> </el-table-column>
    <el-table-column label="所在地区" v-slot="{ row }">
      <span class="mr-2">{{ row.province }}</span>
      <span class="mr-2">{{ row.city }}</span>
      <span class="mr-2">{{ row?.area || "" }}</span>
      <span>{{ row?.street || "" }}</span>
    </el-table-column>
    <el-table-column prop="detail" label="详细地址"> </el-table-column>
    <el-table-column prop="phone" label="手机号码"></el-table-column>
    <!-- <el-table-column label="操作" v-slot="scope">
      <div class="f-c-b">
        <el-popconfirm @confirm="handleDeleteAddress(scope.row.id, scope.$index)" title="你确定要删除该地址？">
          <template #reference>
            <el-button size="small" type="danger" plain>删除</el-button>
          </template>
        </el-popconfirm>
        <el-button size="small" type="primary" plain @click="handleOpenUpdateAddressDialog(scope.row)">修改</el-button>
      </div>
    </el-table-column>
    <el-table-column label="管理" v-slot="scope">
      <div v-if="scope.row.isDefault === 1">默认地址</div>
      <el-button size="small" type="success" v-else @click="handleSetDefaultAddress(scope.row)">设置默认</el-button>
    </el-table-column> -->
  </el-table>
</template>

<style scoped lang="scss"></style>
