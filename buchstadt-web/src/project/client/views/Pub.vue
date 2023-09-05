<script setup lang="ts">
import { queryOne } from "@root/api/api-pub";

const route = useRoute();
const data = ref<PublisherPoJo>();

watch(route, async () => {
  await fetchData();
});

async function fetchData() {
  const id = Number(route.params.id as string);
  data.value = await queryOne(id);
}

await fetchData();
</script>

<template>
  <category-bar></category-bar>
  <div class="page-content">
    <div class="mb-10 f-c-c">
      <div>
        <div class="f-c-c">
          <img class="mb-4 object-cover" :src="data.profilePhoto" />
        </div>
        <div class="f-c-c mb-4 size-20px">{{ data.name }}</div>
        <div f-c-c text-gray-5 class="size-14px">
          {{ data.profile }}
        </div>
      </div>
    </div>
    <div class="f-c-b flex-wrap flex-gap-10">
      <BuchItem
        v-for="item in data.buchs"
        :id="item.id"
        :cover="item.cover"
        :name="item.name"
        :price="item.price"
        :authors="item.authors.map((i:any) => i.author)"
        :discount="item.discount"></BuchItem>
    </div>
  </div>
</template>
