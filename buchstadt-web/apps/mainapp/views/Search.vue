<script setup lang="ts">
import { queryAll } from "@mainapp/apis/api-buch";

const route = useRoute();
const data = shallowRef();
const routeName = ref("");

async function fetchData() {
  routeName.value = route.params.name as string;
  const pageRes = await queryAll({ name: routeName.value });
  data.value = pageRes.list;
}

await fetchData();

watch(route, async () => {
  await fetchData();
});
</script>

<template>
  <div class="page-content">
    <div class="text-1.2rem font-bold mb-10">搜索关键字：{{ routeName }}</div>
    <div class="f-s-b flex-wrap">
      <BuchItem
        v-for="item in data"
        :id="item.id"
        :key="item.id"
        :name="item.name"
        :price="item.price"
        :discount="item.discount"
        :cover="item.cover"></BuchItem>
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
