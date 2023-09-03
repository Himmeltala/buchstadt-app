<script setup lang="ts">
import { insertOne } from "@root/api/api-publisher";
import { submitForm, resetForm } from "@root/common/el-form-validation";
import { publisherFormRules } from "@admin/common/el-form";

const formEl = ref();
const publisherData = reactive({
  name: "",
  profile: "",
  profilePhoto: ""
});

async function saveForm() {
  await insertOne(publisherData);
  resetForm(formEl.value);
}
</script>

<template>
  <el-form ref="formEl" :rules="publisherFormRules" :model="publisherData" label-position="left" label-width="100px">
    <FormTitle title="主表数据" sub-title="出版社的主要内容"></FormTitle>
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
  <div class="f-c-c mt-10">
    <el-button class="mr-10" type="primary" @click="submitForm(formEl, saveForm)">保存表单</el-button>
    <el-button @click="resetForm(formEl)">重置表单</el-button>
  </div>
</template>

<style scoped lang="scss"></style>
