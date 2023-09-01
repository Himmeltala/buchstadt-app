<script setup lang="ts">
import { insert } from "@root/api/api-admin";
import { submitForm, resetForm } from "@root/common/el-form-validation";
import { authorityOps, AdminFormRules } from "@admin/common/el-form";

const formEl = ref();
const adminData = reactive({
  username: "",
  password: "",
  profilePhoto: "",
  phone: "",
  authority: ""
});

async function saveForm() {
  await insert(adminData);
  resetForm(formEl.value);
}
</script>

<template>
  <el-form ref="formEl" :rules="AdminFormRules" :model="adminData" label-position="left" label-width="100px">
    <div class="mb-5"><span class="font-bold mr-2">主表数据</span><span class="text-0.8rem text-gray-5">管理员的主要内容</span></div>
    <el-form-item label="用户名" prop="username">
      <el-input v-model="adminData.username" clearable placeholder="请输入新的用户名" />
    </el-form-item>
    <el-form-item label="头像" prop="profilePhoto">
      <el-input v-model="adminData.profilePhoto" clearable placeholder="仅支持网络图片" />
    </el-form-item>
    <el-form-item label="手机号" prop="phone">
      <el-input v-model="adminData.phone" clearable placeholder="请输入手机号" />
    </el-form-item>
    <el-form-item label="权限" prop="authority">
      <el-select v-model="adminData.authority" placeholder="请选择权限" :options="authorityOps">
        <el-option v-for="item in authorityOps" :value="item.value" :label="item.label" />
      </el-select>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="adminData.password" type="password" clearable placeholder="请输入新的密码" />
    </el-form-item>
  </el-form>
  <div class="f-c-c mt-10">
    <el-button mr-10 type="primary" @click="submitForm(formEl, saveForm)">保存表单</el-button>
    <el-button @click="resetForm(formEl)">重置表单</el-button>
  </div>
</template>

<style scoped lang="scss"></style>
