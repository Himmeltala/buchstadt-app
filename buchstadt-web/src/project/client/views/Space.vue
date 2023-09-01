<script setup lang="ts">
import { query, update } from "@root/api/api-user";

const route = useRoute();
const userData = ref();
const userId = ref(0);
const sexOps = ref([
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
  userData.value = await query({ id: userId.value });
}

function saveForm() {
  update(userData.value);
}

await fetchData();

watch(route, async () => {
  await fetchData();
});
</script>

<template>
  <div class="page-content">
    <div class="px-30 py-10">
      <el-form ref="formEl" :model="userData" label-position="left" label-width="100px">
        <div class="mb-5"><span class="font-bold mr-2">用户信息</span><span class="text-0.8rem text-gray-5">用户的主要内容</span></div>
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
        <el-form-item label="密码" prop="password">
          <el-input v-model="userData.password" type="password" clearable placeholder="请输入新的密码" />
        </el-form-item>
      </el-form>
      <div f-c-c mt-15>
        <el-button type="primary" @click="saveForm">保存表单</el-button>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
