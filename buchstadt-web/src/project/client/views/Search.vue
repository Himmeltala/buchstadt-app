<script setup lang="ts">
import { queryAll } from "@root/api/api-buch";

const route = useRoute();
const list = shallowRef();
const routeName = ref("");

async function fetchData() {
  routeName.value = route.params.name as string;
  list.value = await queryAll({ name: routeName.value });
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
        v-for="item in list"
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
