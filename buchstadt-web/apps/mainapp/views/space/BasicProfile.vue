<script setup lang="ts">
import { submitForm } from "@common/elemplus/el-form-validation";
import { queryOne, updateOne, updatePwd } from "@mainapp/apis/api-user";
import { userFormRules, userUpdatePwdFormRules, updatePwdFormData } from "@mainapp/common/el-form";

const formEl = ref();
const data = ref();
const sexOps = reactive([
  {
    value: "男",
    label: "男"
  },
  {
    value: "女",
    label: "女"
  },
  {
    value: "未知",
    label: "未知"
  }
]);

async function fetchData() {
  const id = localStorage.getUserToken().id;
  data.value = await queryOne(id);
}

const formElUpdatePasswd = ref();

await fetchData();
</script>

<template>
  <div>
    <el-form ref="formEl" style="width: 80%" :rules="userFormRules" :model="data" label-position="left" label-width="100px">
      <FormTitle title="用户信息" sub-title="用户的主要内容"></FormTitle>
      <el-form-item label="用户名" prop="username">
        <el-input v-model="data.username" clearable placeholder="请输入新的用户名" />
      </el-form-item>
      <el-form-item label="注册日期" prop="registerDate">
        <el-input disabled v-model="data.registerDate" />
      </el-form-item>
      <el-form-item label="简介" prop="profile">
        <el-input type="textarea" v-model="data.profile" placeholder="请输入个人简介" />
      </el-form-item>
      <el-form-item label="头像" prop="profilePhoto">
        <el-input v-model="data.profilePhoto" clearable placeholder="仅支持网络图片" />
      </el-form-item>
      <el-form-item label="邮箱" prop="email">
        <el-input v-model="data.email" clearable placeholder="请输入电子邮箱地址" />
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
    <div class="f-c-c mt-10">
      <el-button type="primary" @click="submitForm(formEl, () => updateOne(data))">保存信息</el-button>
    </div>
  </div>
  <div>
    <el-form
      style="width: 50%"
      class="mt-10"
      ref="formElUpdatePasswd"
      :rules="userUpdatePwdFormRules"
      :model="updatePwdFormData"
      label-position="left"
      label-width="100px">
      <FormTitle title="重置密码" sub-title="重置您的密码"></FormTitle>
      <el-form-item label="原始密码" prop="oldPasswd">
        <el-input v-model="updatePwdFormData.oldPasswd" type="password" clearable placeholder="请输入原始密码" />
      </el-form-item>
      <el-form-item label="新的密码" prop="newPasswd">
        <el-input v-model="updatePwdFormData.newPasswd" type="password" clearable placeholder="请输入新的密码" />
      </el-form-item>
    </el-form>
    <div class="f-c-c mt-10 mb-5">
      <el-button @click="submitForm(formElUpdatePasswd, () => updatePwd(updatePwdFormData))">保存密码</el-button>
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
