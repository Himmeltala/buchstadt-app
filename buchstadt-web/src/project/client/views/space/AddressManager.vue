<script setup lang="ts">
import { address } from "@root/assets/data/location";
import { AddressApi } from "@root/api/api-user";
import { addressFormRules, addressFormData } from "@client/common/el-form";
import { submitForm, resetForm, FormInstance } from "@root/common/el-form-validation";

const tableData = ref(await AddressApi.queryAll());
const addressFormEl = ref<FormInstance>();

async function handleSubmitAddress() {
  const { data } = await AddressApi.insertOne(addressFormData);
  if (data.status === 200) {
    tableData.value = await AddressApi.queryAll();
    resetForm(addressFormEl as any);
  }
}

async function handleDeleteAddress(id: number, index: number) {
  const { data } = await AddressApi.deleteOne(id);
  if (data.status === 200) tableData.value.splice(index, 1);
}

async function handleSetDefaultAddress(row: AddressPoJo) {
  row.isDefault = 1;
  await AddressApi.updateDefault(row.id);
  tableData.value.forEach((v, i) => {
    if (row.id != v.id) v.isDefault = 0;
  });
}

const computeZone = computed({
  get() {
    return addressFormData.zone;
  },
  set(value) {
    addressFormData.province = value[0];
    addressFormData.city = value[1];
    addressFormData.area = value[2];
    addressFormData.street = value[3];
    addressFormData.zone = value;
  }
});

const isModify = ref(false);
const modifiedFormData = ref<any>({});
const computeModifiedZone = computed({
  get() {
    return modifiedFormData.value.zone;
  },
  set(value) {
    modifiedFormData.value.province = value[0];
    modifiedFormData.value.city = value[1];
    modifiedFormData.value.area = value[2];
    modifiedFormData.value.street = value[3];
    modifiedFormData.value.zone = value;
  }
});
const updateAddressFormEl = ref();

function handleOpenUpdateAddressDialog(row: AddressPoJo) {
  isModify.value = !isModify.value;
  modifiedFormData.value = row;
  computeModifiedZone.value = [row.province, row.city, row.area];
}

async function handleSubmitUpdateAddress() {
  const { data } = await AddressApi.updateOne(modifiedFormData.value);
  if (data.status === 200) isModify.value = !isModify.value;
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
        <el-cascader style="width: 100%" placeholder="请选择省/市/区/街道" v-model="computeZone" :options="address" />
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
      <el-table-column prop="holder" label="收货人"> </el-table-column>
      <el-table-column label="所在地区" v-slot="{ row }">
        <span class="mr-2">{{ row.province }}</span>
        <span class="mr-2">{{ row.city }}</span>
        <span class="mr-2">{{ row?.area || "" }}</span>
        <span>{{ row?.street || "" }}</span>
      </el-table-column>
      <el-table-column prop="detail" label="详细地址"> </el-table-column>
      <el-table-column prop="phone" label="手机号码"></el-table-column>
      <el-table-column label="操作" v-slot="scope">
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
      </el-table-column>
    </el-table>
    <el-dialog :lock-scroll="false" v-model="isModify" title="修改地址">
      <div class="px-10">
        <FormTitle title="修改地址" :sub-title="'正在修改 ' + modifiedFormData.holder + ' 的地址'"></FormTitle>
        <el-form ref="updateAddressFormEl" :model="modifiedFormData" :rules="addressFormRules" label-position="left" label-width="100px">
          <el-form-item label="地址信息" prop="zone">
            <el-cascader style="width: 100%" placeholder="请选择省/市/区/街道" v-model="computeModifiedZone" :options="address" />
          </el-form-item>
          <el-form-item label="详细地址" prop="detail">
            <el-input
              type="textarea"
              v-model="modifiedFormData.detail"
              placeholder="请输入详细地址信息，如道路、门牌号、校区、楼栋号、单元等信息" />
          </el-form-item>
          <el-form-item label="收货人姓名" prop="holder">
            <el-input v-model="modifiedFormData.holder" placeholder="长度不超过25个字符" />
          </el-form-item>
          <el-form-item label="手机号码" prop="phone">
            <el-input v-model="modifiedFormData.phone" placeholder="收货人的电话号码" />
          </el-form-item>
        </el-form>
        <div class="f-c-c mt-10">
          <el-button type="primary" plain @click="submitForm(updateAddressFormEl, handleSubmitUpdateAddress)">保存地址</el-button>
        </div>
      </div>
    </el-dialog>
  </div>
</template>

<style scoped lang="scss"></style>
