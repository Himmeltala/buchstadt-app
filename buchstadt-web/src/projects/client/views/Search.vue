<script setup lang="ts">
import { BuchApi } from "@root/apis";
import { concatWith } from "@root/utils";

const route = useRoute();
const list = shallowRef();
const routeName = ref("");

async function fetchData() {
  routeName.value = route.params.name as string;
  list.value = await BuchApi.queryAll({ buchName: routeName.value });
  console.log(list.value);
}

await fetchData();

watch(route, async () => {
  await fetchData();
});
</script>

<template>
  <div class="page-content">
    <div font-bold mb-10 class="size-18px">搜索关键字：{{ routeName }}</div>
    <div f-s-b flex-wrap>
      <div v-for="item in list" class="w-45">
        <img cursor-pointer class="w-40 h-40" :src="item.cover" @click="$router.push('/detail/' + item.id)" />
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

<style scoped lang="scss"></style>
