<script setup lang="ts">
import { deleteOne, updateOne, queryAll } from "@root/api/api-pub";
import { submitForm, resetForm } from "@root/common/el-form-validation";
import { pubFormRules } from "@admin/common/el-form";
import { RouterPaths } from "@admin/constants/router-path";

const formEl = ref();
const data = shallowRef(await queryAll());

async function deletePublisher(item: any, index: number) {
  await deleteOne(item.id);
  data.value.splice(index, 1);
}
</script>

<template>
  <el-table border :data="data" stripe>
    <el-table-column type="expand" width="75" fixed label="操作" v-slot="{ row }">
      <div class="px-10 my-5">
        <el-form ref="formEl" :rules="pubFormRules" :model="row" label-position="left" label-width="100px">
          <FormTitle title="主表数据" sub-title="出版社的主要内容"></FormTitle>
          <el-form-item label="出版社名称" prop="name">
            <el-input v-model="row.name" clearable placeholder="请输入新的用户名" />
          </el-form-item>
          <el-form-item label="简介" prop="profile">
            <el-input type="textarea" v-model="row.profile" autosize placeholder="请输入个人简介" />
          </el-form-item>
          <el-form-item label="图标" prop="profilePhoto">
            <el-input v-model="row.profilePhoto" clearable placeholder="仅支持网络图片" />
          </el-form-item>
        </el-form>
        <div f-c-c mt-10>
          <el-button mr-10 type="primary" @click="submitForm(formEl, () => updateOne(row))">保存表单</el-button>
          <el-button @click="resetForm(formEl)">重置表单</el-button>
        </div>
      </div>
    </el-table-column>
    <el-table-column prop="id" label="ID" />
    <el-table-column prop="name" label="出版社名称" />
    <el-table-column v-slot="{ row }" label="图标">
      <img class="w-35 h-15 object-fill" :src="row.profilePhoto" />
    </el-table-column>
    <el-table-column prop="profile" label="简介" width="350" />
    <el-table-column v-slot="{ row }" label="拥有书籍">
      {{ row.buchs.length }}
    </el-table-column>
    <el-table-column v-slot="scope" label="拥有书籍">
      <el-button size="small" plain type="success" @click="$router.push(RouterPaths.pub.detail + scope.row.id)">详细</el-button>
      <el-popconfirm title="你确定要删除该出版社？" @confirm="deletePublisher(scope.row, scope.$index)">
        <template #reference>
          <el-button size="small" plain type="danger">删除</el-button>
        </template>
      </el-popconfirm>
    </el-table-column>
  </el-table>
</template>

<style scoped lang="scss"></style>
