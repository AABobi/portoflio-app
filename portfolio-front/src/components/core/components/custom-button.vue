<script setup lang="ts">
import { ElButton, buttonTypes } from "element-plus";
import {PropType,defineProps} from "vue";

defineProps({
  type: {
    type: String as PropType<buttonTypes>,
    required: false,
  }
})
</script>

<template>
   <ElButton :type="type">
      <slot/>
   </ElButton>
</template>

<style scoped lang="scss">

</style>