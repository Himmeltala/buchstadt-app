<script setup lang="ts">
import { EntryApi } from "@root/apis";
import type { FormInstance, FormRules } from "element-plus";
import { submitForm } from "@root/common/el-form";

const formEl = ref<FormInstance>();
const formData = ref({
  username: "",
  password: ""
});
const formRules = ref<FormRules>({
  username: [
    {
      required: true,
      message: "请输入您的用户名！",
      trigger: "blur"
    },
    {
      min: 3,
      max: 15,
      message: "长度在 3 到 15 之间",
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
  ]
});
const router = useRouter();

function confirm() {
  EntryApi.signin(formData.value).then(() => {
    router.push("/");
  });
}
</script>

<template>
  <div class="page-content">
    <div class="f-c-c">
      <div class="w-60%">
        <img class="w-100% h-100% object-cover" src="/images/myad.jpg" />
      </div>
      <div class="w-40%">
        <h2 mb-20>用户登录</h2>
        <el-form :rules="formRules" ref="formEl" :model="formData" label-width="100px">
          <el-form-item label="用户名" prop="username">
            <el-input v-model="formData.username"></el-input>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input v-model="formData.password" type="password"></el-input>
          </el-form-item>
        </el-form>
        <div f-c-c mb-10 mt-8>
          <el-button type="primary" @click="submitForm(formEl, confirm)">点击登录</el-button>
        </div>
        <div class="f-c-c size-13px">
          <router-link to="/signup">没有账号？点击注册</router-link>
        </div>
      </div>
    </div>
  </div>
</template>
