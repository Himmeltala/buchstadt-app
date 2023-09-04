<script setup lang="ts">
import { concatWith } from "@root/util";
import { queryAll } from "@root/api/api-buch";

const data = ref();

onMounted(async () => {
  data.value = await queryAll({ isPrime: 1 });
});
</script>

<template>
  <div class="index">
    <CategoryBar></CategoryBar>
    <div class="page-content">
      <el-carousel height="395px" direction="vertical" :autoplay="true" :loop="true">
        <el-carousel-item>
          <img class="h-100% w-100% object-cover" src="/images/index_ad.jpg" />
        </el-carousel-item>
        <el-carousel-item>
          <img class="h-100% w-100% object-cover" src="/images/index_ad0.jpg" />
        </el-carousel-item>
        <el-carousel-item>
          <img class="h-100% w-100% object-cover" src="/images/index_ad4.jpg" />
        </el-carousel-item>
        <el-carousel-item>
          <img class="h-100% w-100% object-cover" src="/images/index_ad5.jpg" />
        </el-carousel-item>
      </el-carousel>
      <img class="mt-10 object-cover h-30px" src="/images/billboard.gif" />
      <div class="f-s-b">
        <div class="w-40%">
          <div class="mb-4 text-0.9rem">尊敬的各位用户：</div>
          <div class="mb-4 text-0.9rem">
            为了让大家有更高的购物体验，8月27日起，当日达业务关小黑屋回炉升级！具体开放时间请留意公告，感谢大家的支持与理解，祝大家购物愉快！
          </div>
          <div class="text-end text-0.8rem">9月4日，图书管理部</div>
        </div>
        <div class="w-55% f-s-b flex-nowrap">
          <BuchItem
            v-for="item in data"
            :key="item.id"
            :id="item.id"
            :cover="item.cover"
            :name="item.name"
            :price="item.price"
            :discount="item.discount"></BuchItem>
        </div>
      </div>
    </div>
  </div>
</template>
