<script setup lang="ts">
import { signin } from "@subapp-admin/apis/api-entry";
import { userFormRules } from "@subapp-admin/common/el-form";
import { submitForm } from "@common/elemplus/el-form-validation";

const formData = reactive({
  username: "",
  password: ""
});
const formEl = ref();

async function handleSignIn() {
  await signin({ username: formData.username, password: formData.password });
  location.reload();
}
</script>

<template>
  <div class="signin">
    <div class="body">
      <div class="sidebox">
        <div class="container">
          <div class="header">
            <h2 class="explain" text-center>
              Buchstadt
              <div text-center>后台管理系统</div>
            </h2>
          </div>
          <div>
            时光滴答，梦想渐行渐远。利用好每一分钟，多学一分钟的知识，金钱就多加一分。
            <p>——郑人滏</p>
          </div>
        </div>
      </div>
      <div class="form-container f-c-c">
        <div>
          <div class="font-bold mb-15 text-1.5rem text-center">登陆</div>
          <el-form ref="formEl" :rules="userFormRules" :model="formData">
            <el-form-item prop="username">
              <el-input v-model="formData.username" placeholder="输入用户名"></el-input>
            </el-form-item>
            <el-form-item class="mt-5" prop="password">
              <el-input type="password" v-model="formData.password" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item class="mt-5">
              <el-button @click="submitForm(formEl, handleSignIn)" class="w-100%" type="primary">登 陆</el-button>
            </el-form-item>
          </el-form>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.signin {
  min-height: 100vh;

  .body {
    box-shadow: 0 2px 12px 0 rgb(0 0 0 / 30%);
    border-radius: 15px;
    display: flex;
    position: absolute;
    top: 50%;
    left: 50%;
    width: 830px;
    padding: 0;
    z-index: 1;
    -webkit-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%);
  }

  .sidebox {
    border-radius: 15px 0 0 15px;
    position: relative;
    color: #fff;
    background: linear-gradient(0deg, #409eff 0%, #607089 100%);

    .container {
      position: relative;
      z-index: 1;
      height: 100%;
      display: -webkit-box;
      display: -ms-flexbox;
      display: flex;
      -webkit-box-orient: vertical;
      -webkit-box-direction: normal;
      -ms-flex-direction: column;
      flex-direction: column;
      -webkit-box-pack: justify;
      -ms-flex-pack: justify;
      justify-content: space-between;

      .header {
        .explain {
          margin-top: 30px;
        }
      }
    }
  }

  .form-container {
    border-radius: 0 15px 15px 0;
    position: relative;
    background-color: white;
    color: #40485b;
  }

  .sidebox,
  .form-container {
    padding: 80px 80px 48px;
    margin: 0 auto;
    width: 50%;
    min-height: 564px;
  }
}
</style>
