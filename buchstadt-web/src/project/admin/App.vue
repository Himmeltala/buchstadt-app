<script setup lang="ts"></script>

<template>
  <RouterView v-slot="{ Component }">
    <template v-if="Component">
      <KeepAlive>
        <Suspense>
          <component :is="Component" />
        </Suspense>
      </KeepAlive>
    </template>
  </RouterView>
</template>

<style scoped lang="scss"></style>
