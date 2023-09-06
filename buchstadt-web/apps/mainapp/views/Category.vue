<script setup lang="ts">
import { queryAll } from "@mainapp/apis/api-buch";

const pageSize = ref(12);
const currPage = ref(1);
const pageTotal = ref(100);

const route = useRoute();
const data = ref();

async function fetchData() {
  const type = route.params.type as string;
  let pageRes;

  if (type == "all") {
    pageRes = await queryAll({ pageSize: pageSize.value, currPage: currPage.value });
  } else {
    pageRes = await queryAll({ type, pageSize: pageSize.value, currPage: currPage.value });
  }

  data.value = pageRes.list;
  pageTotal.value = pageRes.total;
}

await fetchData();

watch(route, async () => {
  await fetchData();
});

async function handleCurrentPageChange() {
  await fetchData();
}
</script>

<template>
  <div class="category">
    <category-bar />
    <div class="page-content">
      <div class="f-c-b flex-wrap flex-gap-10">
        <BuchItem
          v-for="item in data"
          :id="item.id"
          :cover="item.cover"
          :name="item.name"
          :pubName="item.pub.name"
          :price="item.price"
          :authors="item.authors.map((i:any) => i.author)"
          :discount="item.discount">
        </BuchItem>
      </div>
      <div class="f-c-e mt-10">
        <el-pagination
          background
          layout="prev, pager, next"
          @current-change="handleCurrentPageChange"
          :total="pageTotal"
          v-model:page-size="pageSize"
          v-model:current-page="currPage" />
      </div>
    </div>
  </div>
</template>
