<script setup lang="ts">
import { updateOne, deleteOne, queryAll } from "@subapp-admin/apis/api-admin";
import { submitForm, resetForm } from "@common/elemplus/el-form-validation";
import { authorityOps, AdminFormRules } from "@subapp-admin/common/el-form";

const pageSize = ref(5);
const currPage = ref(1);
const pageTotal = ref(100);
const data = shallowRef();
const user = localStorage.getAdminToken();
const formEl = ref();

async function deleteAdmin(row: AdminPoJo, index: number) {
  await deleteOne(row.id);
  data.value.splice(index, 1);
}

async function fetchData() {
  const pageRes = await queryAll({
    pageSize: pageSize.value,
    currPage: currPage.value
  });
  pageTotal.value = pageRes.total;
  data.value = pageRes.list;
}

await fetchData();

async function handleCurrentPageChange() {
  await fetchData();
}
</script>

<template>
  <div class="f-c-e mb-10">
    <el-pagination
      background
      layout="prev, pager, next"
      @current-change="handleCurrentPageChange"
      :total="pageTotal"
      v-model:page-size="pageSize"
      v-model:current-page="currPage" />
  </div>
  <el-table border :data="data" stripe>
    <el-table-column type="expand" width="75" fixed label="操作" v-slot="{ row }">
      <div class="px-10 my-5">
        <el-form ref="formEl" :rules="AdminFormRules" :model="row" label-position="left" label-width="100px">
          <div class="mb-5"><span class="font-bold mr-2">主表数据</span><span class="text-0.8rem text-gray-5">管理员的主要内容</span></div>
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
              :disabled="!(user.authority === '超级管理员')"
              clearable
              placeholder="请输入新的密码" />
          </el-form-item>
        </el-form>
        <div class="f-c-c mt-10">
          <el-button class="mr-10" type="primary" @click="submitForm(formEl, async () => await updateOne(row))">保存表单</el-button>
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
      <el-popconfirm title="你确定要删除该管理员？" @confirm="deleteAdmin(scope.row.id, scope.$index)">
        <template #reference>
          <el-button :disabled="user.username === scope.row.username" size="small" plain type="danger">删除</el-button>
        </template>
      </el-popconfirm>
    </el-table-column>
  </el-table>
</template>

<style scoped lang="scss"></style>
