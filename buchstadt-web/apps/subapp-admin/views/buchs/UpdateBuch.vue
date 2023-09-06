<script setup lang="ts">
import { queryOne, updateOne } from "@subapp-admin/apis/api-buch";
import { RouterPaths } from "@subapp-admin/constants/router-path";
import { submitForm } from "@common/elemplus/el-form-validation";
import { buchFormRules, buchTypeOps, buchPrimeOps, dateShortcuts, disabledDate } from "@subapp-admin/common/el-form";

const formEl = ref();
const route = useRoute();
const data = reactive(await queryOne(parseInt(route.params.id + "")));
</script>

<template>
  <el-form ref="formEl" :model="data" :rules="buchFormRules" label-position="left" label-width="100px">
    <FormTitle title="主表数据" sub-title="书籍的主要内容"></FormTitle>
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
        :shortcuts="dateShortcuts" />
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
        <el-option v-for="item in buchTypeOps" :key="item.value" :label="item.label" :value="item.value" />
      </el-select>
    </el-form-item>
    <el-form-item label="首推" prop="isPrime">
      <el-select v-model="data.isPrime" placeholder="是否首推到首页">
        <el-option v-for="item in buchPrimeOps" :key="item.value" :label="item.label" :value="item.value" />
      </el-select>
    </el-form-item>
    <el-form-item label="封面" prop="cover">
      <el-input v-model="data.cover" placeholder="仅支持网络图片" />
    </el-form-item>
    <div class="mb-5 f-c-b">
      <FormTitle title="附表数据" sub-title="书籍的其余的集合内容"></FormTitle>
      <div>
        <span class="text-gray-5">其他操作：</span>
        <el-button text size="small" type="primary" @click="$router.push(RouterPaths.attach.add + data.id)">增加附表数据</el-button>
        <el-button text size="small" type="primary" @click="$router.push(RouterPaths.attach.delete + data.id)">删除附表数据</el-button>
      </div>
    </div>
    <el-form-item label="预览集">
      <div class="flex-wrap f-c-s mr-6" v-for="(item, index) in data.previews" :key="index + 'u'">
        <el-input v-model="item.url" placeholder="仅支持网络图片" />
      </div>
    </el-form-item>
    <el-form-item label="标签集">
      <div class="flex-wrap f-c-s mr-6" v-for="(item, index) in data.tags" :key="index + 't'">
        <el-input v-model="item.tag" placeholder="满300减30、满100减10" />
      </div>
    </el-form-item>
    <el-form-item label="作者集">
      <div class="flex-wrap f-c-s mr-6" v-for="(item, index) in data.authors" :key="index + 'a'">
        <el-input v-model="item.author" placeholder="图书的作者" />
      </div>
    </el-form-item>
  </el-form>
  <div class="my-10 f-c-c">
    <el-button type="primary" @click="submitForm(formEl, async () => await updateOne(data))">提交表单</el-button>
  </div>
</template>

<style scoped lang="scss"></style>
