<template>
  <div class="index">
    <category-bar />
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
      <div class="f-s-c ml-1">
        <div>
          <div class="mb-4">尊敬的各位用户：</div>
          <div class="mb-4">
            为了让大家有更高的购物体验，4月25日起，当日达业务关小黑屋回炉升级！具体开放时间请留意公告，感谢大家的支持与理解，祝大家购物愉快！
          </div>
          <div class="text-end">5月10日，图书管理部</div>
        </div>
        <div ml-2 class="f-s-c">
          <div v-for="item in data" class="w-45">
            <img cursor-pointer class="w-40 h-40" :src="item.cover" @click="$router.push('/verbose/' + item.id)" />
            <div mt-4 text-ellipsis line-clamp-2>
              {{ item.name }}
            </div>
            <div mt-2 class="size-13px text-gray-5">
              {{
                concatWith(
                  "，",
                  item.authors.map((i: any) => i.author)
                )
              }}
            </div>
            <div mt-2 class="text-red">现价：¥{{ item.price * item.discount }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { concatWith } from "@/utils";
import { BuchApi } from "@/apis";

const data = ref();

onMounted(async () => {
  data.value = await BuchApi.queryAll({ isPrime: 1 });
});
</script>
