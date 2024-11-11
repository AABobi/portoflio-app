<script setup lang="ts">
import { computed, defineProps } from "vue";

const props = defineProps({
  borderTop: {
    type: Boolean,
    default: true,
  },
  borderBottom: {
    type: Boolean,
    default: false,
  },
  borderSides: {
    type: Boolean,
    default: false,
  }
})

const classes = computed( () => ({
  FooterArea: true,
  "FooterArea--borderTop": props.borderTop,
  "FooterArea--borderBottom": props.borderBottom,
  "FooterArea--borderSides": props.borderSides,
}))

</script>

<template>
<section>
  <div :class="classes">
      <slot />
  </div>
</section>
</template>

<style scoped lang="scss">
.FooterArea {
  height: 70px;
  width: 100%;

  &--borderBottom {
     border-bottom: solid 1px black;
  }

  &--borderTop {
    border-top: solid 1px black;
  }

  &--borderSides{
    border-left: solid 1px black;
    border-right: solid 1px black;
  }
}
</style>