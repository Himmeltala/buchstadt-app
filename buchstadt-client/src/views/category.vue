<template>
  <div class="category">
    <category-bar />
    <div class="page-content f-s-b flex-wrap">
      <div v-for="item in data" class="w-45" mb-10>
        <img cursor-pointer class="w-40 h-40" :src="item.cover" @click="$router.push('/verbose/' + item.id)" />
        <div mt-4 text-ellipsis line-clamp-2>
          {{ item.name }}
        </div>
        <div mt-2 class="size-13px text-gray-5">
          作者：{{
            concatWith(
              "，",
              item.authors.map((i: any) => i.author)
            )
          }}
        </div>
        <div mt-2 text-gray-5 class="size-13px">出版社：{{ item.publisher.name }}</div>
        <div mt-2 class="text-gray-4 size-13px">原价：¥{{ item.price }}</div>
        <div mt-2 class="text-red">折扣：¥{{ item.price * item.discount }}</div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { concatWith } from "@/utils";
import { BuchApi } from "@/apis/api-buch.js";

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
