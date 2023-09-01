<script setup lang="ts">
import { formRules } from "./ts/el-form";
import { PublisherApi } from "@/apis/api-publisher";
import { submitForm, resetForm } from "@/common/el-form";

const formEl = reactive();
const publisherData = reactive({
  name: "",
  profile: "",
  profilePhoto: ""
});

function saveForm() {
  PublisherApi.insert(publisherData.value).then(() => {
    resetForm(formEl.value);
  });
}
</script>

<template>
  <el-form ref="formEl" :rules="formRules" :model="publisherData" label-position="left" label-width="100px">
    <div mb-5><span font-bold mr-2>主表数据</span><span class="size-13px text-gray-5">出版社的主要内容</span></div>
    <el-form-item label="出版社名称" prop="name">
      <el-input v-model="publisherData.name" clearable placeholder="请输入新的用户名" />
    </el-form-item>
    <el-form-item label="简介" prop="profile">
      <el-input type="textarea" v-model="publisherData.profile" autosize placeholder="请输入个人简介" />
    </el-form-item>
    <el-form-item label="图标" prop="profilePhoto">
      <el-input v-model="publisherData.profilePhoto" clearable placeholder="仅支持网络图片" />
    </el-form-item>
  </el-form>
  <div f-c-c mt-10>
    <el-button mr-10 type="primary" @click="submitForm(formEl, saveForm)">保存表单</el-button>
    <el-button @click="resetForm(formEl)">重置表单</el-button>
  </div>
</template>

<style scoped lang="scss"></style>
