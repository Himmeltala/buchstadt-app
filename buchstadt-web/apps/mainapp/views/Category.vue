<script setup lang="ts">
import { queryAll } from "@common/apis/api-buch";

const route = useRoute();
const data = ref();

async function fetchData() {
  const type = route.params.type as string;
  if (type == "all") {
    data.value = await queryAll({});
  } else {
    data.value = await queryAll({ type });
  }
}

await fetchData();

watch(route, async () => {
  await fetchData();
});
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
    </div>
  </div>
</template>
