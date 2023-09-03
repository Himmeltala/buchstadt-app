<script setup lang="ts"></script>

<template>
  <div class="page-content">
    <div class="mx-10 my-10">
      <el-tabs type="border-card">
        <el-tab-pane class="px-10 mt-5" label="个人资料">
          <BasicProfile></BasicProfile>
        </el-tab-pane>
        <el-tab-pane class="px-10 mt-5" label="设置头像">
          <AvatarSetting></AvatarSetting>
        </el-tab-pane>
        <el-tab-pane class="mx-10 mt-5" label="地址管理">
          <AddressManager></AddressManager>
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>

<style scoped lang="scss"></style>
