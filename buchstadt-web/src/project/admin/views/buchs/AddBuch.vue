<script setup lang="ts">
import { insertOne } from "@root/api/api-buch";
import { queryPubOps } from "@root/api/api-publisher";
import { submitForm } from "@root/common/el-form-validation";
import { buchFormRules, buchFormData, buchTypeOps, buchPrimeOps, dateShortcuts, disabledDate } from "@admin/common/el-form";

const router = useRouter();
const pubOps = reactive(await queryPubOps());
const formEl = ref();

async function saveForm() {
  await insertOne(buchFormData);
  router.back();
}

function addItem(arr: any[], key: string) {
  arr.push({ [key]: "" });
}
</script>

<template>
  <el-form ref="formEl" :model="buchFormData" :rules="buchFormRules" label-position="left" label-width="100px">
    <FormTitle title="主表数据" sub-title="书籍的主要内容"></FormTitle>
    <el-form-item label="书名" prop="name">
      <el-input v-model="buchFormData.name" clearable placeholder="请输入书籍名称" />
    </el-form-item>
    <el-form-item label="出版日期" prop="postDate">
      <el-date-picker
        value-format="YYYY-MM-DD"
        v-model="buchFormData.postDate"
        type="date"
        placeholder="选择出版日期"
        :disabled-date="disabledDate"
        :shortcuts="dateShortcuts" />
    </el-form-item>
    <el-form-item label="单价" prop="price">
      <el-input type="number" clearable placeholder="请输入书籍单价" v-model="buchFormData.price" />
    </el-form-item>
    <el-form-item label="折扣" prop="discount">
      <el-input type="number" clearable placeholder="请输入书籍折扣" v-model="buchFormData.discount" />
    </el-form-item>
    <el-form-item label="简介" prop="profile">
      <el-input type="textarea" v-model="buchFormData.profile" autosize placeholder="请输入书籍简介" />
    </el-form-item>
    <el-form-item label="类型" prop="type">
      <el-select v-model="buchFormData.type" placeholder="选择书籍类型">
        <el-option v-for="item in buchTypeOps" :key="item.value" :label="item.label" :value="item.value" />
      </el-select>
    </el-form-item>
    <el-form-item label="首推" prop="isPrime">
      <el-select v-model="buchFormData.isPrime" placeholder="是否首推到首页">
        <el-option v-for="item in buchPrimeOps" :key="item.value" :label="item.label" :value="item.value" />
      </el-select>
    </el-form-item>
    <el-form-item label="封面" prop="cover">
      <el-input v-model="buchFormData.cover" clearable placeholder="仅支持网络图片" />
    </el-form-item>
    <el-form-item label="所属出版社" prop="publisher">
      <el-select v-model="buchFormData.publisherId" placeholder="选择书籍所属的出版社">
        <el-option v-for="item in pubOps" :key="item.value" :label="item.label" :value="item.value" />
      </el-select>
    </el-form-item>
    <FormTitle title="附表数据" sub-title="书籍的其余的集合内容"></FormTitle>
    <el-form-item label="预览集">
      <div class="flex-wrap f-c-s mr-6" v-for="(item, index) in buchFormData.previews" :key="index + 'u'">
        <el-input v-model="item.url" clearable placeholder="仅支持网络图片" />
      </div>
      <el-button round plain @click="addItem(buchFormData.previews, 'url')" type="primary">+</el-button>
      <el-button v-if="buchFormData.previews.length > 1" plain type="danger" round @click="buchFormData.previews.pop()">-</el-button>
    </el-form-item>
    <el-form-item label="标签集">
      <div class="flex-wrap f-c-s mr-6" v-for="(item, index) in buchFormData.tags" :key="index + 't'">
        <el-input v-model="item.tag" clearable placeholder="满300减30、满100减10" />
      </div>
      <el-button round plain @click="addItem(buchFormData.tags, 'tag')" type="primary">+</el-button>
      <el-button v-if="buchFormData.tags.length > 1" plain type="danger" round @click="buchFormData.tags.pop()">-</el-button>
    </el-form-item>
    <el-form-item label="作者集">
      <div class="flex-wrap f-c-s mr-6" v-for="(item, index) in buchFormData.authors" :key="index + 'a'">
        <el-input v-model="item.author" clearable placeholder="图书的作者" />
      </div>
      <el-button round plain @click="addItem(buchFormData.authors, 'author')" type="primary">+</el-button>
      <el-button v-if="buchFormData.authors.length > 1" plain type="danger" round @click="buchFormData.authors.pop()">-</el-button>
    </el-form-item>
  </el-form>
  <div class="my-10 f-c-c">
    <el-button type="primary" @click="submitForm(formEl, saveForm)">提交表单</el-button>
  </div>
</template>

<style scoped lang="scss"></style>
