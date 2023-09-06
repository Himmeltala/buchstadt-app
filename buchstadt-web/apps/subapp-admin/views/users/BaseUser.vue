<script setup lang="ts">
import { queryAll, deleteOne, updateOne } from "@common/apis/api-user";
import { dateShortcuts, disabledDate, sexOps } from "@subapp-admin/common/el-form";

const pageSize = ref(5);
const currPage = ref(1);
const pageTotal = ref(100);

const data = shallowRef();
const user = localStorage.getAdminToken();

async function fetchData() {
  const pageRes = await queryAll({
    pageSize: pageSize.value,
    currPage: currPage.value
  });
  pageTotal.value = pageRes.total;
  data.value = pageRes.list;
}

await fetchData();

async function deleteUser(item: UserPoJo, index: number) {
  await deleteOne(item);
  data.value.splice(index, 1);
}

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
  <el-table border :data="data" stripe style="width: 100%">
    <el-table-column class="fixed" type="expand" width="75" label="操作" v-slot="{ row }">
      <div class="px-10 my-5">
        <el-form ref="formEl" :model="row" label-position="left" label-width="100px">
          <FormTitle title="主表数据" sub-title="用户的主要内容"></FormTitle>
          <el-form-item label="用户名" prop="username">
            <el-input v-model="row.username" clearable placeholder="请输入新的用户名" />
          </el-form-item>
          <el-form-item label="注册日期" prop="registerDate">
            <el-date-picker
              value-format="YYYY-MM-DD hh:mm:ss"
              v-model="row.registerDate"
              type="datetime"
              placeholder="选择注册日期"
              :disabled-date="disabledDate"
              :shortcuts="dateShortcuts" />
          </el-form-item>
          <el-form-item label="简介" prop="profile">
            <el-input type="textarea" v-model="row.profile" autosize placeholder="请输入个人简介" />
          </el-form-item>
          <el-form-item label="头像" prop="profilePhoto">
            <el-input v-model="row.profilePhoto" clearable placeholder="仅支持网络图片" />
          </el-form-item>
          <el-form-item label="等级" prop="level">
            <el-input-number size="small" :min="1" :max="6" v-model="row.level" clearable placeholder="仅支持网络图片" />
          </el-form-item>
          <el-form-item label="邮箱" prop="email">
            <el-input v-model="row.email" clearable placeholder="请输入电子邮箱地址" />
          </el-form-item>
          <el-form-item label="性别" prop="sex">
            <el-select v-model="row.sex">
              <el-option v-for="(item, index) in sexOps" :key="index" :label="item.label" :value="item.value" />
            </el-select>
          </el-form-item>
          <el-form-item label="手机号" prop="phone">
            <el-input v-model="row.phone" clearable placeholder="请输入手机号" />
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
        <div class="f-c-c mt-5">
          <el-button type="primary" @click="updateOne(row)">保存表单</el-button>
        </div>
      </div>
    </el-table-column>
    <el-table-column class="fixed" prop="id" sortable label="ID" show-overflow-tooltip />
    <el-table-column class="fixed" prop="username" label="用户名" show-overflow-tooltip width="180" />
    <el-table-column label="头像" show-overflow-tooltip width="100" v-slot="{ row }">
      <img class="w-15 h-15 rd-50%" :src="row.profilePhoto" />
    </el-table-column>
    <el-table-column prop="registerDate" sortable show-overflow-tooltip label="注册日期" width="200" />
    <el-table-column sortable label="等级" width="90" show-overflow-tooltip v-slot="{ row }">
      <el-tag>Lv {{ row.level }}</el-tag>
    </el-table-column>
    <el-table-column prop="phone" sortable label="手机号" show-overflow-tooltip width="130" />
    <el-table-column prop="sex" label="性别" show-overflow-tooltip />
    <el-table-column prop="email" label="邮箱" show-overflow-tooltip width="220" />
    <el-table-column label="更多" v-slot="scope">
      <el-popconfirm title="你确定要删除该用户？" @confirm="deleteUser(scope.row, scope.$index)">
        <template #reference>
          <el-button size="small" :disabled="user.username === scope.row.username" plain type="danger">删除</el-button>
        </template>
      </el-popconfirm>
    </el-table-column>
  </el-table>
</template>

<style scoped lang="scss"></style>
