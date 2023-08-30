<script setup lang="ts">
import { concatWith } from "@root/utils";

defineProps({
  id: {
    type: Number,
    required: true
  },
  cover: {
    type: String,
    required: true
  },
  name: {
    type: String,
    required: true
  },
  authors: {
    type: Array as PropType<any[]>,
    required: true
  },
  pubName: {
    type: String,
    required: false
  },
  price: {
    type: Number,
    required: true
  },
  discount: {
    type: Number,
    required: true
  }
});
</script>

<template>
  <div class="item">
    <img class="cursor-pointer w-40 h-40 object-cover" :src="cover" @click="$router.push('/verbose/' + id)" />
    <div class="mt-4 text-ellipsis line-clamp-1">
      {{ name }}
    </div>
    <div class="mt-2 text-gray-5 text-ellipsis line-clamp-1">
      {{ concatWith("，", authors) }}
    </div>
    <div v-if="pubName" class="mt-2 text-gray-5 text-0.8rem text-ellipsis line-clamp-1">出版社：{{ pubName }}</div>
    <div class="mt-2 text-gray-4 text-0.8rem">原价：¥{{ price }}</div>
    <div class="mt-2 text-red">折扣：¥{{ (price * discount).toFixed(2) }}</div>
  </div>
</template>

<style scoped lang="scss">
.item {
  flex: 0 1 20% !important;
}
</style>
