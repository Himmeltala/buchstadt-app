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
          :pubName="item.publisher.name"
          :price="item.price"
          :authors="item.authors.map((i:any) => i.author)"
          :discount="item.discount">
        </BuchItem>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { BuchApi } from "@/apis";

const route = useRoute();
const data = ref();

async function fetchData() {
  const type = route.params.type as string;
  if (type == "all") {
    data.value = await BuchApi.queryAll();
  } else {
    data.value = await BuchApi.queryAll({ type });
  }
}

await fetchData();

watch(route, async () => {
  await fetchData();
});
</script>
