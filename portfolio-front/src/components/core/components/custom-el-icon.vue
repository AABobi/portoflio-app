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

</template>

<style scoped lang="scss">

</style>