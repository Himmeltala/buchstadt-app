<script setup lang="ts">
import { BuchApi } from "@/apis/api-buch";

const route = useRoute();
const buchId = parseInt(route.params.id as string);
const data = ref({
  id: buchId,
  tags: [],
  previews: [],
  authors: []
});
const buch = ref(await BuchApi.query({ buchId }));

function addItem(arr: any[], key: string) {
  arr.push({ [key]: "" });
}

function saveForm() {
  BuchApi.insertAttach(data.value);
}
</script>

<template>
  <div mt-5>
    <el-descriptions title="当前修改" :column="2" border>
      <template #extra>
        <el-button plain type="success" @click="$router.back()">返回上一级</el-button>
      </template>
      <el-descriptions-item>
        <template #label>
          <div>书籍ID</div>
        </template>
        <div>{{ buch.id }}</div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>书籍名称</div>
        </template>
        <div>{{ buch.name }}</div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>出版日期</div>
        </template>
        <div>{{ buch.postDate }}</div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>已有标签集</div>
        </template>
        <div text-ellipsis line-clamp-3>
          <el-tag mr-2 v-for="item in buch.tags">{{ item.tag }}</el-tag>
        </div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>已有预览集</div>
        </template>
        <span mr-2>{{ buch.previews.length }}</span>
      </el-descriptions-item>
      <el-descriptions-item :width="500">
        <template #label>
          <div>已有作者集</div>
        </template>
        <div text-ellipsis line-clamp-2>
          <span mr-2 v-for="item in buch.authors">{{ item.author }}</span>
        </div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>书籍封面</div>
        </template>
        <img class="w-30 h-30" :src="buch.cover" />
      </el-descriptions-item>
    </el-descriptions>
  </div>
  <el-form mt-10 :data="data">
    <el-form-item label="预览集">
      <div flex-wrap f-c-s mr-6 v-for="(item, index) in data.previews" :key="index + 'u'">
        <el-input v-model="item.url" placeholder="仅支持网络图片" />
      </div>
      <el-button round plain @click="addItem(data.previews, 'url')" type="primary">+</el-button>
      <el-button v-if="data.previews.length" plain type="danger" round @click="data.previews.pop()">-</el-button>
    </el-form-item>
    <el-form-item label="标签集">
      <div flex-wrap f-c-s mr-6 v-for="(item, index) in data.tags" :key="index + 't'">
        <el-input v-model="item.tag" placeholder="满300减30、满100减10" />
      </div>
      <el-button round plain @click="addItem(data.tags, 'tag')" type="primary">+</el-button>
      <el-button v-if="data.tags.length" plain type="danger" round @click="data.tags.pop()">-</el-button>
    </el-form-item>
    <el-form-item label="作者集">
      <div flex-wrap f-c-s mr-6 v-for="(item, index) in data.authors" :key="index + 'a'">
        <el-input v-model="item.author" placeholder="图书的作者" />
      </div>
      <el-button round plain @click="addItem(data.authors, 'author')" type="primary">+</el-button>
      <el-button v-if="data.authors.length" plain type="danger" round @click="data.authors.pop()">-</el-button>
    </el-form-item>
  </el-form>
  <div mt-10 f-c-c>
    <el-button type="primary" @click="saveForm">提交表单</el-button>
  </div>
</template>

<style scoped lang="scss"></style>
