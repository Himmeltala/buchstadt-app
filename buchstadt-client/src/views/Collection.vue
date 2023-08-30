<template>
  <div class="page-content flex-wrap">
    <div class="f-c-b flex-wrap">
      <BuchItem
        v-for="item in data"
        :id="item.buch.id"
        :cover="item.buch.cover"
        :price="item.buch.price"
        :name="item.buch.name"
        :authors="item.authors.map((i:any) => i.author)"
        :discount="item.buch.discount"></BuchItem>
    </div>
  </div>
</template>

<script setup lang="ts">
import { BuchApi } from "@/apis";

const data = ref();

data.value = await BuchApi.queryCollections();
</script>
