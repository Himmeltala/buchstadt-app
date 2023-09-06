<script setup lang="ts">
import type { FormInstance } from "element-plus";
import { signin } from "@mainapp/apis/api-entry";
import { submitForm } from "@common/elemplus/el-form-validation";
import { loginFormRules, loginFormData } from "@mainapp/common/el-form";

const formEl = ref<FormInstance>();

async function confirm() {
  await signin(loginFormData);
  location.reload();
}
</script>

<template>
  <div class="page-content">
    <div class="f-c-c">
      <div class="w-60%">
        <img class="w-100% h-100% object-cover" src="/images/myad.jpg" />
      </div>
      <div class="w-40% px-10">
        <div class="mb-20 font-bold text-1.2rem">用户登录</div>
        <el-form :rules="loginFormRules" ref="formEl" :model="loginFormData">
          <el-form-item prop="username">
            <el-input size="large" placeholder="请输入用户名" v-model="loginFormData.username"></el-input>
          </el-form-item>
          <el-form-item class="mt-8" prop="password">
            <el-input size="large" placeholder="请输入密码" v-model="loginFormData.password" type="password"></el-input>
          </el-form-item>
        </el-form>
        <div class="text-center mb-10 mt-10">
          <el-button type="primary" @click="submitForm(formEl, confirm)">登录</el-button>
        </div>
        <div class="text-end text-0.8rem">
          <router-link class="hover" to="/signup">没有账号？点击注册</router-link>
        </div>
      </div>
    </div>
  </div>
</template>
