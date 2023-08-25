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

<script setup lang="ts"></script>

<style scoped lang="scss"></style>
