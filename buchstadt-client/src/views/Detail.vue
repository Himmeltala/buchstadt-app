<template>
  <div class="page-content">
    <div f-s-b>
      <div class="w25%">
        <el-carousel>
          <el-carousel-item v-for="item in data.previews">
            <img :src="item.url" class="w-100% h-100%" />
          </el-carousel-item>
        </el-carousel>
      </div>
      <div class="w70%">
        <div class="color-#323232">
          <h1 class="size-18px">
            {{ data.name }}
          </h1>
          <div class="size-16px mb-4" text-ellipsis line-clamp-3>
            {{ data.profile }}
          </div>
        </div>
        <div f-c-s class="color-#646464 size-13px">
          <div class="item">
            作者：
            {{
              concatWith(
                ",",
                data.authors.map((i: any) => i.author)
              )
            }}
          </div>
          <div f-c-s class="item">
            <div>出版社：</div>
            <el-link @click="$router.push('/press/' + data.publisher.id)">
              {{ data.publisher.name }}
            </el-link>
          </div>
          <div class="item">出版时间：{{ data.postDate }}</div>
        </div>
        <div class="price bg-#fcfaf7 my-6 h-35">
          <div class="col-1 f-s-b">
            <div class="col-1-left mt-5 ml-5 mb-5">
              <p class="size-26px color-#e52222">
                ¥{{ data.price * data.discount }}
                <span class="size-13px">{{ data.discount * 10 }}折</span>
              </p>
              <p class="color-#646464 size-13px">
                定价<span class="line-through">¥{{ data.price }}</span>
              </p>
            </div>
            <img class="h-100% w-270px" src="https://img60.ddimg.cn/assets/pc_image/minaAttract-product-price.gif" />
          </div>
        </div>
        <div class="my-10 f-c-s">
          <el-tag class="mr-2 f-c-c" v-for="item in data.tags">{{ item.tag }}</el-tag>
        </div>
        <div class="f-c-s mb-10 size-14px">
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
          <el-input-number v-model="num" :min="1" :max="99"></el-input-number>
        </div>
        <el-button type="primary" @click="setIntoTrolley">加入购物车</el-button>
        <el-button @click="collectToCollection"> 收藏书籍 </el-button>
      </div>
    </div>
    <div f-s-b mt-10>
      <div b="width-1 solid #e6e6fa" mr-10 rd-2 class="h-200px w-20%">
        <div rd-2 f-c-c font-bold class="bg-#fafafa color-#333333 h-30px size-13px">{{ data.publisher.name }}</div>
        <div class="size-13px color-#999999">
          <div f-c-b px-3 py-2>
            <div>描 述</div>
            <div>服 务</div>
            <div>物 流</div>
          </div>
          <div f-c-b px-3 py-2 class="color-#ff0038">
            <div>{{ data.publisher.desc }} -</div>
            <div>{{ data.publisher.serv }} ↑</div>
            <div>{{ data.publisher.logistics }} ↑</div>
          </div>
          <div f-c-b mt-4 px-2>
            <el-button size="small" @click="$router.push('/press/' + data.publisher.id)">进入店铺</el-button>
            <el-button size="small">收藏店铺</el-button>
          </div>
        </div>
      </div>
      <div class="comment-wrapper w-80%">
        <ul>
          <li v-for="(item, index) in commentTypeList" :key="index" class="li" @click="queryCommentList(item.value)">
            {{ item.label }}
          </li>
        </ul>
        <div class="f-c-b" mt-5 mb-10>
          <el-select class="w-15%" v-model="commentType" placeholder="请选择评论类型">
            <el-option v-for="item in commentTypeOptions" :key="item.value" :label="item.label" :value="item.value"> </el-option>
          </el-select>
          <div class="w-70%">
            <el-form autosize :rules="commentFormRules" :model="commentFormData" hide-required-asterisk>
              <el-form-item prop="commentContent">
                <el-input type="textarea" v-model="commentFormData.commentContent"></el-input>
              </el-form-item>
            </el-form>
          </div>
          <div class="f-c-c w-10%">
            <el-button type="primary" plain @click="postComment">发表</el-button>
          </div>
        </div>
        <div>
          <div v-for="(item, index) in commentList" :key="index" class="f-s-b mb-10" b-b="width-1 solid color-#DCDCDC" pb-5>
            <div class="w-15%">
              <div class="f-c-c">
                <img class="w-15 h-15" :src="item.user.profilePhoto" rd-50 />
              </div>
            </div>
            <div class="w-85%">
              <div class="f-c-s text-gray-5">
                <div class="mr-2">
                  {{ item.user.username }}
                </div>
                <el-tag size="small">Lv: {{ item.user.level }} </el-tag>
              </div>
              <div text-gray-5 mt-6>
                {{ item.content }}
              </div>
              <div f-c-b text-gray-5 mt-6 class="size-13px">
                <div f-c-c>
                  <div mr-4 f-c-c>
                    <i-ep-top />
                    <div>点赞({{ item.digg }})</div>
                  </div>
                  <div f-c-c>
                    <i-ep-bottom />
                    <div>反对({{ item.bury }})</div>
                  </div>
                </div>
                <div f-c-c text-gray-4 class="size-13px">发表日期：{{ item.postDate }}</div>
              </div>
            </div>
          </div>
        </div>
        <div class="size-16px line-height-8">
          <div font-bold mb-5 class="size-18px">书籍简介</div>
          {{ data.profile }}
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { concatWith, formatDate } from "@/utils";
import { BuchApi, TrolleyApi, CommentApi } from "@/apis";

const data = ref();
const num = ref(0);
const commentList = ref();
const commentTypeList = [
  { value: "全部", label: "全部" },
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
];
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
const commentFormData = ref({
  commentContent: ""
});
const commentFormRules = ref({
  commentContent: [
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
const buchId = Number(route.params.id);

async function queryCommentList(buchType: string) {
  if (buchType == "全部") {
    commentList.value = await CommentApi.query({ buchId });
  } else {
    commentList.value = await CommentApi.query({
      buchId,
      buchType
    });
  }
}

function postComment() {
  CommentApi.insert({
    content: commentFormData.value.commentContent,
    type: commentType.value,
    buchId
  });
}

function setIntoTrolley() {
  TrolleyApi.insert({
    buchId,
    num: num.value
  });
}

async function fetchData() {
  data.value = await BuchApi.query({ buchId });
  commentList.value = await CommentApi.query({ buchId });
}

async function collectToCollection() {
  await BuchApi.collect({
    buchId
  });
}

await fetchData();

watch(route, async () => {
  await fetchData();
});
</script>

<style lang="scss" scoped>
.item {
  margin-right: 15px;
}

.item:last-child {
  margin-right: 0;
}

.comment-wrapper {
  ul {
    list-style: none;
    padding-left: 0;
    --uno: f-c-b;

    li {
      --uno: rd-2 py-2 mr-10 text-center w-100%;
      border: 1px solid #e6e6fa;
      transition: 0.3s;
    }

    .li:last-child {
      margin-right: 0;
    }

    .li:hover {
      background-color: #409eff;
      cursor: pointer;
      transition: 0.3s;
      color: white;
    }
  }
}
</style>
