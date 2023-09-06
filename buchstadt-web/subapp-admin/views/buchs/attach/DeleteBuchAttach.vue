<script setup lang="ts">
import { deleteOneTag, deleteOneAuthor, deleteOnePreview, queryOne } from "@common/apis/api-buch";

const route = useRoute();
const id = parseInt(route.params.id as string);
const data = ref(await queryOne(id));

async function delTag(v: any, index: number) {
  await deleteOneTag(v.id, id);
  data.value.tags.splice(index, 1);
}

async function delAuthor(v: any, index: number) {
  await deleteOneAuthor(v.id, id);
  data.value.authors.splice(index, 1);
}

async function delPreview(v: any, index: number) {
  await deleteOnePreview(v.id, id);
  data.value.previews.splice(index, 1);
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
        <div class="text-ellipsis line-clamp-2">
          <span class="mr-2" v-for="item in data.authors">{{ item.author }}</span>
        </div>
      </el-descriptions-item>
    </el-descriptions>
  </div>
  <el-form class="mt-10" :data="data">
    <el-form-item label="预览集">
      <div class="mb-2 f-c-s mr-6" v-for="(item, index) in data.previews" :key="index + 'u'">
        <img class="w-25 h-25" :src="item.url" disabled />
        <div class="ml-2">
          <el-button v-if="data.previews.length > 1" size="small" plain type="danger" round @click="delPreview(item, index)">-</el-button>
        </div>
      </div>
    </el-form-item>
    <el-form-item label="标签集">
      <div class="mb-2 f-c-s mr-6" v-for="(item, index) in data.tags" :key="index + 't'">
        <el-input v-model="item.tag" disabled />
        <div class="ml-2">
          <el-button v-if="data.tags.length > 1" plain size="small" type="danger" round @click="delTag(item, index)">-</el-button>
        </div>
      </div>
    </el-form-item>
    <el-form-item label="作者集">
      <div class="mb-2 f-c-s mr-6" v-for="(item, index) in data.authors" :key="index + 'a'">
        <el-input v-model="item.author" disabled />
        <div class="ml-2">
          <el-button v-if="data.authors.length > 1" plain size="small" type="danger" round @click="delAuthor(item, index)">-</el-button>
        </div>
      </div>
    </el-form-item>
  </el-form>
</template>

<style scoped lang="scss"></style>
