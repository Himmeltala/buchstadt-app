<script setup lang="ts">
import { RouterPaths } from "@admin/constants/router-path";

const route = useRoute();
const router = useRouter();
const list = shallowRef(getCurrentRouteList());

function getCurrentRouteList() {
  return router.currentRoute.value.matched;
}

function getCurrentRoutePath() {
  return router.currentRoute.value.fullPath;
}

watch(route, () => {
  list.value = getCurrentRouteList();
});
</script>

<template>
  <el-container>
    <el-aside width="200px">
      <div class="ml-5 mt-4 text-gray-5 mb-2">Buchstadt 系统</div>
      <el-menu router unique-opened :default-active="getCurrentRoutePath()">
        <el-sub-menu index="1">
          <template #title>
            <i-ep-notebook mr-2 />
            <span>书籍管理</span>
          </template>
          <el-menu-item :index="RouterPaths.buchs.base">基本管理</el-menu-item>
          <el-menu-item :index="RouterPaths.buchs.add">添加书籍</el-menu-item>
          <el-menu-item :index="RouterPaths.comms.base">书籍评论</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="2">
          <template #title>
            <i-ep-user mr-2 />
            <span>用户管理</span>
          </template>
          <el-menu-item :index="RouterPaths.users.base">基本管理</el-menu-item>
          <el-menu-item :index="RouterPaths.users.add">添加用户</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="3">
          <template #title>
            <i-ep-box mr-2 />
            <span>订单管理</span>
          </template>
          <el-menu-item :index="RouterPaths.orders.base">基本管理</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="4">
          <template #title>
            <i-ep-avatar mr-2 />
            <span>管理员管理</span>
          </template>
          <el-menu-item :index="RouterPaths.admins.base">基本管理</el-menu-item>
          <el-menu-item :index="RouterPaths.admins.add">添加管理员</el-menu-item>
        </el-sub-menu>
        <el-sub-menu index="5">
          <template #title>
            <i-ep-management mr-2 />
            <span>出版社管理</span>
          </template>
          <el-menu-item :index="RouterPaths.publishers.base">基本管理</el-menu-item>
          <el-menu-item :index="RouterPaths.publishers.add">添加出版社</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </el-aside>
    <el-container>
      <el-header>
        <TopCustNavigation />
      </el-header>
      <el-main>
        <div class="f-c-s mb-10">
          <div class="f-c-c text-gray-4">
            <i-ep-location class="mr-2" />
          </div>
          <el-breadcrumb separator="/">
            <template v-for="(item, index) in list">
              <el-breadcrumb-item v-if="index != list.length - 1" :to="item.path">
                {{ item.meta.title }}
              </el-breadcrumb-item>
              <el-breadcrumb-item v-else>
                {{ item.meta.title }}
              </el-breadcrumb-item>
            </template>
          </el-breadcrumb>
        </div>
        <router-view />
      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped lang="scss"></style>
