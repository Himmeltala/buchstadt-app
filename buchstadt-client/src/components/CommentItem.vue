<script setup lang="ts">
defineProps({
  avatar: {
    type: String
  },
  username: {
    type: String
  },
  level: {
    type: String
  },
  content: {
    type: String
  },
  digg: {
    type: Number
  },
  bury: {
    type: Number
  },
  date: {
    type: String
  }
});
</script>

<template>
  <div class="item f-s-b pb-5">
    <div class="w-15%">
      <div class="f-c-c">
        <img class="w-15 h-15 object-cover" :src="avatar" rd-50 />
      </div>
    </div>
    <div class="w-85%">
      <div class="f-c-s text-gray-5">
        <div class="mr-2">
          {{ username }}
        </div>
        <el-tag size="small">Lv: {{ level }} </el-tag>
      </div>
      <div class="text-gray-5 mt-6">
        {{ content }}
      </div>
      <div class="f-c-b text-gray-5 mt-6 text-0.8rem">
        <div class="f-c-c">
          <div class="mr-4 f-c-c">
            <i-ep-top />
            <div>点赞({{ digg }})</div>
          </div>
          <div class="f-c-c">
            <i-ep-bottom />
            <div>反对({{ bury }})</div>
          </div>
        </div>
        <div class="f-c-c text-gray-4">发表日期：{{ date }}</div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.item {
  --uno: b-b-1 b-b-solid b-b-color-#DCDCDC my-10;

  &:last-child {
    --uno: b-b-0 mb-5;
  }
}
</style>
