<script setup lang="ts">
import { UserApi } from "@/apis/api-user";
import { sexOps } from "./ts/el-form";
import { shortcuts, disabledDate } from "@/common/el-date";

const route = useRoute();
const userList = shallowRef(await UserApi.queryAll());
const userInfo = JSON.parse(localStorage.getItem("userInfo"));

watch(route, async () => {
  userList.value = await UserApi.queryAll();
});

function saveForm(item: UserData) {
  UserApi.update(item);
}

function deleteUser(item: UserData, index: number) {
  UserApi.del(item).then(() => {
    userList.value = userList.value.toSpliced(index, 1);
  });
}
</script>

<template>
  <el-table border :data="userList" stripe style="width: 100%">
    <el-table-column type="expand" width="75" fixed label="操作" v-slot="{ row }">
      <div px-10 my-5>
        <el-form ref="formEl" :model="row" label-position="left" label-width="100px">
          <div mb-5><span font-bold mr-2>主表数据</span><span class="size-13px text-gray-5">用户的主要内容</span></div>
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
              :shortcuts="shortcuts" />
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
              :disabled="!(userInfo.authority === '超级管理员')"
              clearable
              placeholder="请输入新的密码" />
          </el-form-item>
        </el-form>
        <div f-c-c mt-5>
          <el-button type="primary" @click="saveForm(row)">保存表单</el-button>
        </div>
      </div>
    </el-table-column>
    <el-table-column fixed prop="id" sortable label="ID" show-overflow-tooltip />
    <el-table-column fixed prop="username" label="用户名" show-overflow-tooltip width="180" />
    <el-table-column label="头像" show-overflow-tooltip width="100" v-slot="{ row }">
      <img class="w-15 h-15 rd-50" :src="row.profilePhoto" />
    </el-table-column>
    <el-table-column prop="registerDate" sortable show-overflow-tooltip label="注册日期" width="200" />
    <el-table-column sortable label="等级" width="90" show-overflow-tooltip v-slot="{ row }">
      <el-tag>Lv {{ row.level }}</el-tag>
    </el-table-column>
    <el-table-column prop="phone" sortable label="手机号" show-overflow-tooltip width="150" />
    <el-table-column prop="sex" label="性别" show-overflow-tooltip />
    <el-table-column prop="email" label="邮箱" show-overflow-tooltip width="250" />
    <el-table-column label="更多" v-slot="scope">
      <el-popconfirm title="你确定要删除该用户？" @confirm="deleteUser(scope.row, scope.$index)">
        <template #reference>
          <el-button size="small" plain type="danger">删除</el-button>
        </template>
      </el-popconfirm>
    </el-table-column>
  </el-table>
</template>

<style scoped lang="scss"></style>
