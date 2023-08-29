<template>
  <category-bar></category-bar>
  <div class="page-content">
    <div mb-10 f-c-c>
      <div>
        <div f-c-c>
          <img mb-4 :src="data.profilePhoto" />
        </div>
        <div f-c-c mb-4 class="size-20px">{{ data.name }}</div>
        <div f-c-c text-gray-5 class="size-14px">
          {{ data.profile }}
        </div>
      </div>
    </div>
    <div v-for="item in data.buchs">
      <img cursor-pointer class="w-40 h-40" :src="item.cover" @click="$router.push('/verbose/' + item.id)" />
      <div mt-4>
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
</template>

<script setup lang="ts">
import { PublisherApi } from "@/apis";
import { concatWith } from "@/utils";

const route = useRoute();
const data = ref();

watch(route, async () => {
  await fetchData();
});

async function fetchData() {
  const id = Number(route.params.pressId as string);
  data.value = await PublisherApi.query({ id });
  console.log(data.value);
}

await fetchData();
</script>
