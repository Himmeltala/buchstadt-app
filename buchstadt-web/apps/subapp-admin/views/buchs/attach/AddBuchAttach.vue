<script setup lang="ts">
import { queryOne, insertOneAttach } from "@subapp-admin/apis/api-buch";

const route = useRoute();
const attchData = reactive({
  id: parseInt(route.params.id as string),
  tags: [],
  previews: [],
  authors: []
});
const data = reactive(await queryOne(parseInt(route.params.id as string)));

function addItem(arr: any[], key: string) {
  arr.push({ [key]: "" });
}
</script>

<template>
  <div class="mt-5">
    <el-descriptions title="当前修改" :column="2" border>
      <template #extra>
        <el-button plain type="success" @click="$router.back()">返回上一级</el-button>
      </template>
      <el-descriptions-item>
        <template #label>
          <div>书籍ID</div>
        </template>
        <div>{{ data.id }}</div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>书籍名称</div>
        </template>
        <div>{{ data.name }}</div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>出版日期</div>
        </template>
        <div>{{ data.postDate }}</div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>已有标签集</div>
        </template>
        <div class="text-ellipsis line-clamp-3">
          <el-tag class="mr-2" v-for="item in data.tags">{{ item.tag }}</el-tag>
        </div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>已有预览集</div>
        </template>
        <span class="mr-2">{{ data.previews.length }}</span>
      </el-descriptions-item>
      <el-descriptions-item :width="500">
        <template #label>
          <div>已有作者集</div>
        </template>
        <div class="text-ellipsis line-clamp-">
          <span class="mr-2" v-for="item in data.authors">{{ item.author }}</span>
        </div>
      </el-descriptions-item>
      <el-descriptions-item>
        <template #label>
          <div>书籍封面</div>
        </template>
        <img class="w-30 h-30" :src="data.cover" />
      </el-descriptions-item>
    </el-descriptions>
  </div>
  <el-form class="mt-10" :data="attchData">
    <el-form-item label="预览集">
      <div class="flex-wrap f-c-s mr-6" v-for="(item, index) in attchData.previews" :key="index + 'u'">
        <el-input v-model="item.url" placeholder="仅支持网络图片" />
      </div>
      <el-button round plain @click="addItem(attchData.previews, 'url')" type="primary">+</el-button>
      <el-button v-if="attchData.previews.length" plain type="danger" round @click="attchData.previews.pop()">-</el-button>
    </el-form-item>
    <el-form-item label="标签集">
      <div clas="flex-wrap f-c-s mr-6" v-for="(item, index) in attchData.tags" :key="index + 't'">
        <el-input v-model="item.tag" placeholder="满300减30、满100减10" />
      </div>
      <el-button round plain @click="addItem(attchData.tags, 'tag')" type="primary">+</el-button>
      <el-button v-if="attchData.tags.length" plain type="danger" round @click="attchData.tags.pop()">-</el-button>
    </el-form-item>
    <el-form-item label="作者集">
      <div class="flex-wrap f-c-s mr-6" v-for="(item, index) in attchData.authors" :key="index + 'a'">
        <el-input v-model="item.author" placeholder="图书的作者" />
      </div>
      <el-button round plain @click="addItem(attchData.authors, 'author')" type="primary">+</el-button>
      <el-button v-if="attchData.authors.length" plain type="danger" round @click="attchData.authors.pop()">-</el-button>
    </el-form-item>
  </el-form>
  <div class="mt-10 f-c-c">
    <el-button type="primary" @click="async () => await insertOneAttach(attchData)">提交表单</el-button>
  </div>
</template>

<style scoped lang="scss"></style>
