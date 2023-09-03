<script setup lang="ts">
import { insertOne } from "@root/api/api-user";
import { sexOps, userFormRules } from "@admin/common/el-form";
import { resetForm, submitForm } from "@root/common/el-form-validation";

const data = reactive({
  username: "",
  password: "",
  profilePhoto: "",
  level: 1,
  email: "",
  phone: "",
  profile: "",
  sex: "未知",
  registerDate: ""
});
const formEl = ref();

async function saveForm() {
  await insertOne(data);
  resetForm(formEl.value);
}
</script>

<template>
  <el-form ref="formEl" :model="data" :rules="userFormRules" label-position="left" label-width="100px">
    <FormTitle title="主表数据" sub-title="用户的主要内容"></FormTitle>
    <el-form-item label="用户名" prop="username">
      <el-input v-model="data.username" clearable placeholder="请输入新的用户名" />
    </el-form-item>
    <el-form-item label="头像" prop="profilePhoto">
      <el-input v-model="data.profilePhoto" clearable placeholder="仅支持网络图片" />
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input v-model="data.password" type="password" clearable placeholder="请输入新的密码" />
    </el-form-item>
    <el-form-item label="简介" prop="profile">
      <el-input type="textarea" v-model="data.profile" autosize placeholder="请输入个人简介" />
    </el-form-item>
    <el-form-item label="等级" prop="level">
      <el-input-number size="small" :min="1" :max="6" v-model="data.level" clearable placeholder="仅支持网络图片" />
    </el-form-item>
    <el-form-item label="邮箱" prop="email">
      <el-input v-model="data.email" clearable placeholder="仅支持网络图片" />
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-select v-model="data.sex">
        <el-option v-for="(item, index) in sexOps" :key="index" :label="item.label" :value="item.value" />
      </el-select>
    </el-form-item>
    <el-form-item label="手机号" prop="phone">
      <el-input v-model="data.phone" clearable placeholder="请输入手机号" />
    </el-form-item>
  </el-form>
  <div f-c-c mt-10>
    <el-button mr-10 type="primary" @click="submitForm(formEl, saveForm)">保存表单</el-button>
    <el-button type="danger" plain @click="resetForm(formEl)">重置表单</el-button>
  </div>
</template>

<style scoped lang="scss"></style>
