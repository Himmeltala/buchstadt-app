<script setup lang="ts">
import { AdminApi } from "@/apis/api-admin";
import { submitForm, resetForm } from "@/common/el-form";
import { authorityOps, formRules } from "./ts/el-form";

const adminList = shallowRef(await AdminApi.queryAll());
const userInfo = JSON.parse(localStorage.getItem("userInfo"));
const formEl = ref();

function deleteAdmin(row: AdminData, index: number) {
  AdminApi.del(row).then(() => {
    adminList.value = adminList.value.toSpliced(index, 1);
  });
}

function saveForm(row: AdminData) {
  AdminApi.update(row);
}
</script>

<template>
  <el-table border :data="adminList" stripe>
    <el-table-column type="expand" width="75" fixed label="操作" v-slot="{ row }">
      <div px-10 my-5>
        <el-form ref="formEl" :rules="formRules" :model="row" label-position="left" label-width="100px">
          <div mb-5><span font-bold mr-2>主表数据</span><span class="size-13px text-gray-5">管理员的主要内容</span></div>
          <el-form-item label="用户名" prop="username">
            <el-input v-model="row.username" clearable placeholder="请输入新的用户名" />
          </el-form-item>
          <el-form-item label="头像" prop="profilePhoto">
            <el-input v-model="row.profilePhoto" clearable placeholder="仅支持网络图片" />
          </el-form-item>
          <el-form-item label="手机号" prop="phone">
            <el-input v-model="row.phone" clearable placeholder="请输入手机号" />
          </el-form-item>
          <el-form-item label="权限" prop="authority">
            <el-select v-model="row.authority" placeholder="请选择权限" :options="authorityOps">
              <el-option v-for="item in authorityOps" :value="item.value" :label="item.label" />
            </el-select>
          </el-form-item>
          <el-form-item label="密码" prop="password">
            <el-input
              v-model="row.password"
              type="password"
              :disabled="!(userInfo.authority === '超级管理员')"
              clearable
              placeholder="请输入新的密码" />
          </el-form-item>
        </el-form>
        <div f-c-c mt-10>
          <el-button mr-10 type="primary" @click="submitForm(formEl, () => saveForm(row))">保存表单</el-button>
          <el-button @click="resetForm(formEl)">重置表单</el-button>
        </div>
      </div>
    </el-table-column>
    <el-table-column fixed prop="id" sortable label="ID" show-overflow-tooltip />
    <el-table-column fixed prop="username" label="用户名" show-overflow-tooltip />
    <el-table-column label="头像" show-overflow-tooltip v-slot="{ row }">
      <img class="w-15 h-15 rd-50" :src="row.profilePhoto" />
    </el-table-column>
    <el-table-column sortable label="权限" show-overflow-tooltip v-slot="{ row }">
      <el-tag>{{ row.authority }}</el-tag>
    </el-table-column>
    <el-table-column prop="phone" sortable label="手机号" show-overflow-tooltip />
    <el-table-column label="更多" v-slot="scope">
      <el-popconfirm title="你确定要删除该管理员？" @confirm="deleteAdmin(scope.row, scope.$index)">
        <template #reference>
          <el-button size="small" plain type="danger">删除</el-button>
        </template>
      </el-popconfirm>
    </el-table-column>
  </el-table>
</template>

<style scoped lang="scss"></style>
