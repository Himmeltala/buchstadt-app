<script setup lang="ts">
import { EntryApi } from "@root/apis";
import type { FormInstance, FormRules } from "element-plus";
import { submitForm } from "@root/common/el-form";

const formData = ref({
  username: "",
  password: "",
  rePassword: "",
  phone: "",
  profile: ""
});

const formRules = ref<FormRules>({
  username: [
    {
      required: true,
      message: "请输入您的用户名！",
      trigger: "blur"
    },
    {
      min: 4,
      max: 15,
      message: "长度在 4 到 15 之间",
      trigger: "blur"
    }
  ],
  password: [
    {
      required: true,
      message: "请输入您的密码！",
      trigger: "blur"
    },
    {
      min: 6,
      max: 20,
      message: "长度在 6 到 20 之间",
      trigger: "blur"
    }
  ],
  rePassword: [
    {
      required: true,
      message: "请重复您的密码！",
      trigger: "blur"
    },
    {
      min: 6,
      max: 20,
      message: "长度在 6 到 20 之间",
      trigger: "blur"
    }
  ],
  profile: [
    {
      message: "请填写个人简介！",
      trigger: "blur"
    }
  ]
});
const formEl = ref<FormInstance>();
const router = useRouter();

function confirm() {
  EntryApi.signup({
    username: formData.value.username,
    password: formData.value.password,
    profile: formData.value.profile,
    phone: formData.value.phone
  }).then(() => {
    router.push("/signin");
  });
}
</script>

<template>
  <div class="page-content">
    <h2>新用户注册</h2>
    <el-form class="my-15 px-70" :rules="formRules" ref="formEl" :model="formData" label-width="100px">
      <el-form-item class="form-item" label="用户名：" prop="username">
        <el-input v-model="formData.username"></el-input>
      </el-form-item>
      <el-form-item class="form-item" label="初次密码：" prop="password">
        <el-input v-model="formData.password" type="password" show-password></el-input>
      </el-form-item>
      <el-form-item class="form-item" label="联系电话：" prop="phone">
        <el-input v-model="formData.phone"></el-input>
      </el-form-item>
      <el-form-item class="form-item" label="个人简介：" prop="profile">
        <el-input v-model="formData.profile" type="textarea" :rows="3" maxlength="50" show-word-limit></el-input>
      </el-form-item>
    </el-form>
    <div f-c-c>
      <el-button type="primary" @click="submitForm(formEl, confirm)">同意并注册</el-button>
    </div>
    <div class="text-center size-13px mt-10">
      <router-link to="/signin">已有账号？点击登陆</router-link>
    </div>
  </div>
</template>
