<script setup lang="ts">
import type { FormInstance } from "element-plus";
import { signup } from "@common/apis/api-entry";
import { submitForm } from "@common/elemplus/el-form-validation";
import { registerFormData, registerFormRules } from "@mainapp/common/el-form";

const formEl = ref<FormInstance>();
const router = useRouter();

async function confirm() {
  await signup(registerFormData);
  router.push("/signin");
}
</script>

<template>
  <div class="page-content">
    <div class="mb-20 font-bold text-1.2rem">用户注册</div>
    <el-form class="my-15 px-70" :rules="registerFormRules" ref="formEl" :model="registerFormData" label-width="100px">
      <el-form-item class="form-item" label="用户名：" prop="username">
        <el-input placeholder="字母、中文、-、_，不能以数字开头、-、_开头，长度在4~16" v-model="registerFormData.username"></el-input>
      </el-form-item>
      <el-form-item class="form-item" label="初次密码：" prop="password">
        <el-input placeholder="英文、.、数字，长度在8~16" v-model="registerFormData.password" type="password" show-password></el-input>
      </el-form-item>
      <el-form-item class="form-item" label="确认密码：" prop="rePasswd">
        <el-input placeholder="两次密码要保持一致！" v-model="registerFormData.rePasswd" type="rePasswd" show-password></el-input>
      </el-form-item>
      <el-form-item class="form-item" label="联系电话：" prop="phone">
        <el-input placeholder="好让客服联系你！" v-model="registerFormData.phone"></el-input>
      </el-form-item>
      <el-form-item class="form-item" label="个人简介：" prop="profile">
        <el-input
          placeholder="简单介绍一下自己吧！"
          v-model="registerFormData.profile"
          type="textarea"
          :rows="3"
          maxlength="50"
          show-word-limit></el-input>
      </el-form-item>
    </el-form>
    <div class="f-c-c">
      <el-button type="primary" @click="submitForm(formEl, confirm)">同意并注册</el-button>
    </div>
    <div class="text-end text-0.8rem mt-10">
      <router-link class="hover" to="/signin">已有账号？点击登陆</router-link>
    </div>
  </div>
</template>
