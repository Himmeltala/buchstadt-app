<script setup lang="ts">
const bottomList = [
  {
    type: "创作",
    items: [
      {
        label: "关于我们",
        href: "#"
      },
      {
        label: "联系我们",
        href: "#"
      }
    ]
  },
  {
    type: "官方",
    items: [
      {
        label: "新浪微博",
        href: "#"
      },
      {
        label: "官方网店",
        href: "#"
      },
      {
        label: "微信公众号",
        href: "#"
      }
    ]
  },
  {
    type: "下载",
    items: [
      {
        label: "移动客户端",
        href: "#"
      },
      {
        label: "官方工具包",
        href: "#"
      }
    ]
  },
  {
    type: "反馈",
    items: [
      {
        label: "帮助中心",
        href: "#"
      },
      {
        label: "用户反馈",
        href: "#"
      },
      {
        label: "用户协议",
        href: "#"
      },
      {
        label: "隐私政策",
        href: "#"
      },
      {
        label: "侵权举报申诉",
        href: "#"
      }
    ]
  }
];
</script>

<template>
  <Navigation></Navigation>
  <RouterView v-slot="{ Component }">
    <template v-if="Component">
      <Suspense>
        <component :is="Component" />
      </Suspense>
    </template>
  </RouterView>
  <div class="mt-10 h-100%" style="background: rgb(249, 249, 249); padding: 1% 15%">
    <div class="f-c-b">
      <div class="item" v-for="(listItem, index) in bottomList" :key="index">
        <div class="color-#b5b5b5 mb-2">{{ listItem.type }}</div>
        <div class="f-c-c">
          <div v-for="(item, i) in listItem.items" :key="i">
            <el-link class="mr-4" v-bind:href="item.href">
              {{ item.label }}
            </el-link>
          </div>
        </div>
      </div>
    </div>
    <div class="w-100% text-center">
      <img class="w-100px h-30px mt-4" src="/images/logo_2.jpg" />
      <div class="mt-4 size-14px color-#8a8484">
        Copyright © 2020-2023 郑人滏. 保留代码权利<br />
        <el-link type="info" href="https://github.com/himmelbleu">GitHub</el-link>
        |
        <el-link type="info" href="https://gitee.com/himmelbleu"> Gitee </el-link>
        |
        <el-link type="info" href="https://www.cnblogs.com/himmelbleu/">博客园</el-link>
      </div>
    </div>
  </div>
</template>

<style scoped lang="scss">
.item {
  margin-right: 20px;
}

.item:last-child {
  margin-right: 0;
}
</style>
