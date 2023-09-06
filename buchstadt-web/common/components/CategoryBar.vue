<script setup lang="ts">
const categories = [
  {
    name: "文学",
    href: "/category/literature"
  },
  {
    name: "生活",
    href: "/category/living"
  },
  {
    name: "计算机",
    href: "/category/computer"
  },
  {
    name: "外语",
    href: "/category/language"
  },
  {
    name: "经营",
    href: "/category/business"
  },
  {
    name: "励志",
    href: "/category/motivation"
  },
  {
    name: "社科",
    href: "/category/social"
  },
  {
    name: "学术",
    href: "/category/academic"
  },
  {
    name: "少儿",
    href: "/category/children"
  },
  {
    name: "艺术",
    href: "/category/art"
  },
  {
    name: "原版",
    href: "/category/origin"
  },
  {
    name: "科技",
    href: "/category/technology"
  },
  {
    name: "考试",
    href: "/category/examine"
  },
  {
    name: "生活百科",
    href: "/category/encyclopedia"
  },
  {
    name: "全部商品",
    href: "/category/all"
  }
];
</script>

<template>
  <div class="category-bar">
    <ul class="ul">
      <li class="li" v-for="(item, index) in categories" :key="index">
        <router-link v-bind:to="item.href">
          {{ item.name }}
        </router-link>
      </li>
    </ul>
  </div>
</template>

<style lang="scss" scoped>
.category-bar {
  background: #337ecc;
  margin: 25px 0;
  padding: 10px 15%;

  .ul {
    margin: 0;
    padding: 0;
    display: flex;
    list-style: none;
    justify-content: space-between;

    .li {
      margin: 0 10px;

      a {
        color: white;
        font-size: 17px;
      }
    }

    .li:first-child {
      margin: 0 10px 0 0;
    }

    .li:last-child {
      margin: 0 0 0 10px;
    }
  }
}
</style>
