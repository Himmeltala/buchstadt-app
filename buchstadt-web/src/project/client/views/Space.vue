<script setup lang="ts">
import { queryOne, updateOne, updatePwd } from "@root/api/api-user";
import { userFormRules, userUpdatePwdFormRules, updatePwdFormData } from "@client/common/el-form";
import { submitForm } from "@root/common/el-form-validation";

const formEl = ref();
const route = useRoute();
const userData = ref();
const userId = ref(0);
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
  userId.value = Number(route.params.id);
  userData.value = await queryOne({ id: userId.value });
}

const formElUpdatePasswd = ref();

await fetchData();

watch(route, async () => {
  await fetchData();
});
</script>

<template>
  <div class="page-content">
    <div class="px-30 py-10">
      <el-form ref="formEl" :rules="userFormRules" :model="userData" label-position="left" label-width="100px">
        <FormTitle title="用户信息" sub-title="用户的主要内容"></FormTitle>
        <el-form-item label="用户名" prop="username">
          <el-input v-model="userData.username" clearable placeholder="请输入新的用户名" />
        </el-form-item>
        <el-form-item label="注册日期" prop="registerDate">
          <el-input disabled v-model="userData.registerDate" />
        </el-form-item>
        <el-form-item label="简介" prop="profile">
          <el-input type="textarea" v-model="userData.profile" autosize placeholder="请输入个人简介" />
        </el-form-item>
        <el-form-item label="头像" prop="profilePhoto">
          <el-input v-model="userData.profilePhoto" clearable placeholder="仅支持网络图片" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="userData.email" clearable placeholder="请输入电子邮箱地址" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-select v-model="userData.sex">
            <el-option v-for="(item, index) in sexOps" :key="index" :label="item.label" :value="item.value" />
          </el-select>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="userData.phone" clearable placeholder="请输入手机号" />
        </el-form-item>
      </el-form>
      <div class="f-c-c mt-15">
        <el-button type="primary" @click="submitForm(formEl, () => updateOne(userData))">保存信息</el-button>
      </div>
    </div>
    <div class="px-30 pt-5 pb-10">
      <el-form
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
      <div class="f-c-c mt-15">
        <el-button @click="submitForm(formElUpdatePasswd, () => updatePwd(updatePwdFormData))">修改密码</el-button>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
