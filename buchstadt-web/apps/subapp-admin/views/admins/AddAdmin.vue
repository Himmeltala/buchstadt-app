<script setup lang="ts">
import { insertOne } from "@common/apis/api-admin";
import { submitForm, resetForm } from "@common/elemplus/el-form-validation";
import { authorityOps, AdminFormRules } from "@subapp-admin/common/el-form";

const formEl = ref();
const data = reactive<AdminPoJo>({
  username: "",
  password: "",
  profilePhoto: "",
  phone: "",
  authority: ""
});

async function insertAdmin() {
  await insertOne(data);
  resetForm(formEl.value);
}
</script>

<template>
  <el-form ref="formEl" :rules="AdminFormRules" :model="data" label-position="left" label-width="100px">
    <div class="mb-5"><span class="font-bold mr-2">主表数据</span><span class="text-0.8rem text-gray-5">管理员的主要内容</span></div>
    <el-form-item label="用户名" prop="username">
      <el-input v-model="data.username" clearable placeholder="请输入新的用户名" />
    </el-form-item>
    <el-form-item label="头像" prop="profilePhoto">
      <el-input v-model="data.profilePhoto" clearable placeholder="仅支持网络图片" />
    </el-form-item>
    <el-form-item label="手机号" prop="phone">
      <el-input v-model="data.phone" clearable placeholder="请输入手机号" />
    </el-form-item>
    <el-form-item label="权限" prop="authority">
      <el-select v-model="data.authority" placeholder="请选择权限" :options="authorityOps">
        <el-option v-for="item in authorityOps" :value="item.value" :label="item.label" />
      </el-select>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="data.password" type="password" clearable placeholder="请输入新的密码" />
    </el-form-item>
  </el-form>
  <div class="f-c-c mt-10">
    <el-button mr-10 type="primary" @click="submitForm(formEl, insertAdmin)">保存表单</el-button>
    <el-button @click="resetForm(formEl)">重置表单</el-button>
  </div>
</template>

<style scoped lang="scss"></style>
