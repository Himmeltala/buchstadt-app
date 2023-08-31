<script setup lang="ts">
import { formRules, typeOps, primeOps } from "./ts/el-form";
import { shortcuts, disabledDate } from "@/common/el-date";
import { submitForm, resetForm } from "@/common/el-form";
import { BuchApi } from "@/apis/api-buch";
import { PublisherApi } from "@/apis/api-publisher";

const router = useRouter();
const data = ref({
  name: "",
  postDate: "",
  price: 10,
  discount: 0.5,
  profile: "",
  type: "literature",
  isPrime: 0,
  cover: "",
  publisherId: "",
  tags: [{ tag: "" }],
  previews: [{ url: "" }],
  authors: [{ author: "" }]
});
const pubOps = ref(await PublisherApi.queryPubOps());
const formEl = ref();

function saveForm() {
  BuchApi.insert(data.value).then(() => {
    router.back();
  });
}

function addItem(arr: any[], key: string) {
  arr.push({ [key]: "" });
}
</script>

<template>
  <el-form ref="formEl" :model="data" :rules="formRules" label-position="left" label-width="100px">
    <div mb-5><span font-bold mr-2>主表数据</span><span class="size-13px text-gray-5">书籍的主要内容</span></div>
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
      <el-input v-model="data.cover" clearable placeholder="仅支持网络图片" />
    </el-form-item>
    <el-form-item label="所属出版社" prop="publisher">
      <el-select v-model="data.publisherId" placeholder="选择书籍所属的出版社">
        <el-option v-for="item in pubOps" :key="item.value" :label="item.label" :value="item.value" />
      </el-select>
    </el-form-item>
    <div mb-5><span font-bold mr-2>附表数据</span><span class="size-13px text-gray-5">书籍的其余的集合内容</span></div>
    <el-form-item label="预览集">
      <div flex-wrap f-c-s mr-6 v-for="(item, index) in data.previews" :key="index + 'u'">
        <el-input v-model="item.url" clearable placeholder="仅支持网络图片" />
      </div>
      <el-button round plain @click="addItem(data.previews, 'url')" type="primary">+</el-button>
      <el-button v-if="data.previews.length > 1" plain type="danger" round @click="data.previews.pop()">-</el-button>
    </el-form-item>
    <el-form-item label="标签集">
      <div flex-wrap f-c-s mr-6 v-for="(item, index) in data.tags" :key="index + 't'">
        <el-input v-model="item.tag" clearable placeholder="满300减30、满100减10" />
      </div>
      <el-button round plain @click="addItem(data.tags, 'tag')" type="primary">+</el-button>
      <el-button v-if="data.tags.length > 1" plain type="danger" round @click="data.tags.pop()">-</el-button>
    </el-form-item>
    <el-form-item label="作者集">
      <div flex-wrap f-c-s mr-6 v-for="(item, index) in data.authors" :key="index + 'a'">
        <el-input v-model="item.author" clearable placeholder="图书的作者" />
      </div>
      <el-button round plain @click="addItem(data.authors, 'author')" type="primary">+</el-button>
      <el-button v-if="data.authors.length > 1" plain type="danger" round @click="data.authors.pop()">-</el-button>
    </el-form-item>
  </el-form>
  <div my-10 f-c-c>
    <div>
      <el-button type="primary" @click="submitForm(formEl, saveForm)">提交表单</el-button>
    </div>
    <div ml-20>
      <el-button plain type="danger" @click="resetForm(formEl)">重置表单</el-button>
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
