<script setup lang="ts">
import { concatWith, formatDate } from "@root/utils";
import { BuchApi, TrolleyApi, CommentApi } from "@root/apis";

const data = ref();
const cartItemNum = ref(0);
const commentList = ref();
const commentTypeOptions = ref([
  {
    value: "好评",
    label: "好评"
  },
  {
    value: "中评",
    label: "中评"
  },
  {
    value: "差评",
    label: "差评"
  }
]);
const commentType = ref("好评");
const formData = reactive({
  content: ""
});
const formRules = ref({
  content: [
    {
      required: true,
      message: "请输入评论内容",
      trigger: "blur"
    },
    {
      min: 4,
      max: 500,
      message: "长度在 4 到 500 个字符",
      trigger: "blur"
    }
  ]
});
const route = useRoute();
const paramId = Number(route.params.id);

function postComment() {
  CommentApi.insert({
    content: formData.content,
    type: commentType.value,
    id: paramId
  });
}

const tabList = ref([
  { label: "全部评论", name: "全部" },
  { label: "好评", name: "好评" },
  { label: "中评", name: "中评" },
  { label: "差评", name: "差评" }
]);
const tabPanelName = ref("全部");
async function onTabChange(type: string) {
  if (type === "全部") {
    commentList.value = await CommentApi.query(null, paramId);
  } else {
    commentList.value = await CommentApi.query(type, paramId);
  }
}

async function fetchData() {
  data.value = await BuchApi.query(paramId);
  commentList.value = await CommentApi.query(null, paramId);
}

await fetchData();

watch(route, async () => {
  await fetchData();
});
</script>

<template>
  <div class="page-content">
    <div class="f-s-b">
      <div class="w25%">
        <el-carousel>
          <el-carousel-item v-for="item in data.previews">
            <img :src="item.url" class="object-cover w-100% h-100%" />
          </el-carousel-item>
        </el-carousel>
      </div>
      <div class="w70%">
        <div class="color-#323232">
          <div class="text-1.2rem font-bold mb-4">
            {{ data.name }}
          </div>
          <div class="text-1rem mb-4 text-ellipsis line-clamp-3">
            {{ data.profile }}
          </div>
        </div>
        <div f-c-s class="text-0.9rem">
          <div class="item">
            作者：
            {{
              concatWith(
                ",",
                data.authors.map((i: any) => i.author)
              )
            }}
          </div>
          <div class="item f-c-s hover">
            <div>出版社：</div>
            <el-link @click="$router.push('/publisher/' + data.publisher.id)">
              {{ data.publisher.name }}
            </el-link>
          </div>
          <div class="item">出版时间：{{ data.postDate }}</div>
        </div>
        <div class="bg-#fcfaf7 my-6 h-35">
          <div class="f-s-b">
            <div class="mt-5 ml-5 mb-5">
              <div class="text-1.2rem color-#e52222">¥{{ data.price * data.discount }}</div>
              <div class="mt-1 color-#e52222 text-0.8rem">{{ data.discount * 10 }}折</div>
              <div class="mt-4 color-#646464 text-1rem">
                定价：<span class="line-through">¥{{ data.price }}</span>
              </div>
            </div>
            <img class="h-100% w-270px object-cover" src="https://img60.ddimg.cn/assets/pc_image/minaAttract-product-price.gif" />
          </div>
        </div>
        <div class="my-10 f-c-s">
          <el-tag class="mr-2 f-c-c" v-for="item in data.tags">{{ item.tag }}</el-tag>
        </div>
        <div class="f-c-s mb-10 text-0.9rem">
          <div class="color-#969696">服务：</div>
          <div class="item text-gray">
            {{ formatDate("ch", "hours") }}
            前完成下单，预计
            <span class="font-bold">
              {{ formatDate("ch", "day", 1000 * 60 * 60 * 24 * 2) }}
            </span>
            可送达
          </div>
        </div>
        <div class="f-c-s mb-10">
          <div class="color-#969696">数量：</div>
          <el-input-number v-model="cartItemNum" :min="1" :max="99"></el-input-number>
        </div>
        <el-button type="primary" @click="async () => await TrolleyApi.insert(paramId, cartItemNum)">加入购物车</el-button>
        <el-button @click="async () => await BuchApi.collect(paramId)"> 收藏书籍 </el-button>
      </div>
    </div>
    <div class="f-s-b mt-10">
      <div b="width-1 solid #e6e6fa" class="h-200px w-20% mr-10 rd-2">
        <div class="bg-#fafafa color-#333333 h-30px text-1rem rd-2 f-c-c font-bold">{{ data.publisher.name }}</div>
        <div class="text-0.8rem color-#999999">
          <div f-c-b px-3 py-2>
            <div>描 述</div>
            <div>服 务</div>
            <div>物 流</div>
          </div>
          <div class="color-#ff0038 f-c-b px-3 py-2">
            <div>{{ data.publisher.desc }} -</div>
            <div>{{ data.publisher.serv }} ↑</div>
            <div>{{ data.publisher.logistics }} ↑</div>
          </div>
          <div class="f-c-b mt-4 px-2">
            <el-button size="small" @click="$router.push('/publisher/' + data.publisher.id)">进入店铺</el-button>
            <el-button size="small">收藏店铺</el-button>
          </div>
        </div>
      </div>
      <div class="comment-wrapper w-80%">
        <div class="f-c-b mt-5 mb-10">
          <el-select class="w-15%" v-model="commentType" placeholder="请选择评论类型">
            <el-option v-for="item in commentTypeOptions" :key="item.value" :label="item.label" :value="item.value"> </el-option>
          </el-select>
          <div class="w-70%">
            <el-form autosize :rules="formRules" :model="formData" hide-required-asterisk>
              <el-form-item prop="content">
                <el-input type="textarea" v-model="formData.content"></el-input>
              </el-form-item>
            </el-form>
          </div>
          <div class="f-c-c w-10%">
            <el-button type="primary" plain @click="postComment">发表</el-button>
          </div>
        </div>
        <el-tabs class="rd-2" v-model="tabPanelName" type="border-card" @tab-change="onTabChange">
          <el-tab-pane v-for="tabItem in tabList" :key="tabItem.name" :label="tabItem.label" :name="tabItem.name">
            <CommentItem
              v-if="commentList.length"
              v-for="item in commentList"
              :key="item.id"
              :level="item.user.level"
              :date="item.postDate"
              :bury="item.bury"
              :digg="item.digg"
              :content="item.content"
              :username="item.user.username"
              :avatar="item.user.profilePhoto"></CommentItem>
            <el-empty v-else description="暂无评论" />
          </el-tab-pane>
        </el-tabs>
        <div class="text-1rem line-height-8 mt-10">
          <div class="text-1.2rem font-bold mb-5">书籍简介</div>
          {{ data.profile }}
        </div>
      </div>
    </div>
  </div>
</template>

<style lang="scss" scoped>
.item {
  margin-right: 15px;
}

.item:last-child {
  margin-right: 0;
}
</style>
