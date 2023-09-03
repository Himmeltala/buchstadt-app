<script setup lang="ts">
defineProps({
  title: {
    type: String,
    required: true
  },
  subTitle: {
    type: String,
    required: true
  }
});
</script>

<template>
  <div class="mb-5">
    <span class="font-bold mr-2">{{ title }}</span
    ><span class="text-0.8rem text-gray-5">{{ subTitle }}</span>
  </div>
</template>

<style scoped lang="scss"></style>
