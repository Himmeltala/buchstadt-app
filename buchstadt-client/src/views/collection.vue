<template>
  <div class="page-content flex-wrap">
    <div class="f-c-b flex-wrap">
      <div v-for="item in data" class="w-45">
        <img cursor-pointer class="w-40 h-40" :src="item.buch.cover" @click="$router.push('/verbose/' + item.buch.id)" />
        <div mt-4 text-ellipsis line-clamp-2>
          {{ item.buch.name }}
        </div>
        <div mt-2 class="size-13px text-gray-5">
          作者：{{
            concatWith(
              "，",
              item.authors.map((i: any) => i.author)
            )
          }}
        </div>
        <el-link mt-2 class="size-13px" @click="$router.push('/press/' + item.publisher.id)">出版社：{{ item.publisher.name }}</el-link>
        <div mt-2 class="text-red">折扣：¥{{ item.buch.price * item.buch.discount }}</div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { concatWith } from "@/utils";
import { BuchApi } from "@/apis/api-buch";

const data = ref();

data.value = await BuchApi.queryCollections({
  userId: Number(localStorage.getItem("userId"))
});
</script>
