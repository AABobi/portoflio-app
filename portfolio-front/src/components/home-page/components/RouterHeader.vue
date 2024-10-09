<script setup lang="ts">
import { Button } from "@/components/core/components/index.ts"
import {defineProps} from "vue";

defineProps({
  buttonName: {
    type: Array,
    required: true,
  },
  routePath: {
    type: Array,
    required: true,
    default: () => [],
    validator: value => value.every(item => typeof item === 'function')
  }
})
</script>

<template>
  <header class="RouterHeader">
   <Button class="RouterHeader__button" v-for="(name, index) in buttonName" :key="index" @click="routePath[index]">{{ name }}</Button>
  </header>
</template>

<style scoped lang="scss">
.RouterHeader {
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 25px;
  height: 100px;
  border: 1px solid rgb(219, 219, 219);

  &__button {
    width: 100px;
  }
}
</style>