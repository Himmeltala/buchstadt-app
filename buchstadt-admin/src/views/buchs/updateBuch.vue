<script setup lang="ts">
import { BuchApi } from "@/apis/api-buch";
import { RouterPaths } from "@/constants/router-path";
import { submitForm, resetForm } from "@/common/el-form";
import { shortcuts, disabledDate } from "@/common/el-date";
import { formRules, typeOps, primeOps } from "./ts/el-form";

const route = useRoute();
const data = ref();
const formEl = ref();

async function saveForm() {
  await BuchApi.update(data.value);
}

async function fetchData() {
  const buchId = parseInt(route.params.id as string);
  data.value = await BuchApi.query({ buchId });
}

await fetchData();
</script>

<template>
  <el-form ref="formEl" :model="data" :rules="formRules" label-position="left" label-width="100px">
    <div mb-5><span font-bold mr-2>主表数据</span><span class="size-13px text-gray-5">书籍的主要内容</span></div>
    <el-form-item label="ID" prop="id">
      <el-input disabled v-model="data.id" />
    </el-form-item>
    <el-form-item label="书名" prop="name">
      <el-input v-model="data.name" clearable placeholder="请输入书籍名称" />
    </el-form-item>
    <el-form-item label="出版日期" prop="postDate">
      <el-date-picker
        value-format="YYYY-MM-DD"
        v-model="data.postDate"
        type="date"
        placeholder="选择出版日期"
        :disabled-date="disabledDate"
        :shortcuts="shortcuts" />
    </el-form-item>
    <el-form-item label="单价" prop="price">
      <el-input type="number" clearable placeholder="请输入书籍单价" v-model="data.price" />
    </el-form-item>
    <el-form-item label="折扣" prop="discount">
      <el-input type="number" clearable placeholder="请输入书籍折扣" v-model="data.discount" />
    </el-form-item>
    <el-form-item label="简介" prop="profile">
      <el-input type="textarea" v-model="data.profile" autosize placeholder="请输入书籍简介" />
    </el-form-item>
    <el-form-item label="类型" prop="type">
      <el-select v-model="data.type" placeholder="选择书籍类型">
        <el-option v-for="item in typeOps" :key="item.value" :label="item.label" :value="item.value" />
      </el-select>
    </el-form-item>
    <el-form-item label="首推" prop="isPrime">
      <el-select v-model="data.isPrime" placeholder="是否首推到首页">
        <el-option v-for="item in primeOps" :key="item.value" :label="item.label" :value="item.value" />
      </el-select>
    </el-form-item>
    <el-form-item label="封面" prop="cover">
      <el-input v-model="data.cover" placeholder="仅支持网络图片" />
    </el-form-item>
    <div mb-5 f-c-b>
      <div><span font-bold mr-2>附表数据</span><span class="size-13px text-gray-5">书籍的其余的集合内容 </span></div>
      <div>
        <span class="text-gray-5 size-14px">其他操作：</span>
        <el-button text size="small" type="primary" @click="$router.push(RouterPaths.attach.add + data.id)">增加附表数据</el-button>
        <el-button text size="small" type="primary" @click="$router.push(RouterPaths.attach.delete + data.id)">删除附表数据</el-button>
      </div>
    </div>
    <el-form-item label="预览集">
      <div flex-wrap f-c-s mr-6 v-for="(item, index) in data.previews" :key="index + 'u'">
        <el-input v-model="item.url" placeholder="仅支持网络图片" />
      </div>
    </el-form-item>
    <el-form-item label="标签集">
      <div flex-wrap f-c-s mr-6 v-for="(item, index) in data.tags" :key="index + 't'">
        <el-input v-model="item.tag" placeholder="满300减30、满100减10" />
      </div>
    </el-form-item>
    <el-form-item label="作者集">
      <div flex-wrap f-c-s mr-6 v-for="(item, index) in data.authors" :key="index + 'a'">
        <el-input v-model="item.author" placeholder="图书的作者" />
      </div>
    </el-form-item>
  </el-form>
  <div my-10 f-c-c>
    <div>
      <el-button type="primary" @click="submitForm(formEl, saveForm)">提交表单</el-button>
    </div>
    <div ml-20>
      <el-button plain @click="resetForm(formEl)">重置表单</el-button>
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
