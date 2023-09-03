<script setup lang="ts">
import { queryAllCollection } from "@root/api/api-buch";

const data = reactive(await queryAllCollection());
</script>

<template>
  <div class="page-content flex-wrap mt-10">
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
