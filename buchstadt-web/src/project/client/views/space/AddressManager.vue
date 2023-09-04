<script setup lang="ts">
import { address } from "@root/assets/data/location";
import { insertOneAddress, queryAllAddresses, setAddressIsDefault } from "@root/api/api-user";
import { addressFormRules, addressFormData } from "@client/common/el-form";
import { submitForm, resetForm, FormInstance } from "@root/common/el-form-validation";

const tableData = reactive(await queryAllAddresses());
const addressFormEl = ref<FormInstance>();

async function handleSubmitAddress() {
  await insertOneAddress(addressFormData);
  resetForm(addressFormEl as any);
}

function handleUpdateAddress(row: AddressPojo) {}

function handleDeleteAddress(row: AddressPojo) {}

function handleSetDefaultAddress(row: AddressPojo) {
  setAddressIsDefault(row.id);
  tableData.forEach((item, index) => {
    item.isDefault = index === 1 ? 1 : 0;
  });
}
</script>

<template>
  <div>
    <FormTitle title="新增地址" sub-title="增加新的地址"></FormTitle>
    <el-form
      ref="addressFormEl"
      :model="addressFormData"
      :rules="addressFormRules"
      style="width: 70%"
      label-position="left"
      label-width="100px">
      <el-form-item label="地址信息" prop="zone">
        <el-cascader style="width: 100%" placeholder="请选择省/市/区/街道" v-model="addressFormData.zone" :options="address" />
      </el-form-item>
      <el-form-item label="详细地址" prop="detail">
        <el-input
          type="textarea"
          v-model="addressFormData.detail"
          placeholder="请输入详细地址信息，如道路、门牌号、校区、楼栋号、单元等信息" />
      </el-form-item>
      <el-form-item label="收货人姓名" prop="holder">
        <el-input v-model="addressFormData.holder" placeholder="长度不超过25个字符" />
      </el-form-item>
      <el-form-item label="手机号码" prop="phone">
        <el-input v-model="addressFormData.phone" placeholder="收货人的电话号码" />
      </el-form-item>
    </el-form>
    <div class="f-c-c mt-10">
      <el-button type="primary" plain @click="submitForm(addressFormEl, handleSubmitAddress)">保存新地址</el-button>
    </div>
  </div>
  <div class="mt-10">
    <FormTitle title="地址列表" sub-title="已保存的地址"></FormTitle>
    <el-table class="mb-5" border stripe :data="tableData" style="width: 100%">
      <el-table-column prop="holder" label="收货人" />
      <el-table-column label="所在地区" v-slot="{ row }">
        <span class="mr-2">{{ row.province }}</span>
        <span class="mr-2">{{ row.city }}</span>
        <span class="mr-2">{{ row?.area || "" }}</span>
        <span>{{ row?.street || "" }}</span>
      </el-table-column>
      <el-table-column prop="detail" label="详细地址" />
      <el-table-column prop="phone" label="手机号码" />
      <el-table-column label="操作" v-slot="{ row }">
        <div class="f-c-b">
          <el-button size="small" text type="danger" plain @click="handleDeleteAddress(row)">删除</el-button>
          <el-button size="small" text type="primary" plain @click="handleUpdateAddress(row)">修改</el-button>
        </div>
      </el-table-column>
      <el-table-column label="管理" v-slot="{ row }">
        <div v-if="row.isDefault">默认地址</div>
        <el-button size="small" type="danger" v-else plain @click="handleSetDefaultAddress(row)">设置默认</el-button>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped lang="scss"></style>
