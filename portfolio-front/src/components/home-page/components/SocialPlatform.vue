<script setup lang="ts">
import { ref, defineProps } from "vue";
import { ElImage } from "@/components/core/components/index.ts";
import { SocialAttributes } from "./AboutMe.vue";
import { getImgUrl } from "@/components/home-page/domain/index.ts";

const headerTitle = ref("Contact me:");

const props = defineProps<{
  socialAttributes: SocialAttributes[];
}>();

const openSocialLink = (url: string) => {
  window.open(url, "_blank");
};
</script>
<template>
  <div class="SocialPlatform">
    <header class="SocialPlatform__header">{{ headerTitle }}</header>
    <section
      class="SocialPlatform__section"
      v-for="(socialAttributes, key) in props.socialAttributes"
      :key="key"
    >
      <ElImage
        :src="getImgUrl(socialAttributes.imagePath)"
        alt="@/assets/linkeLinIcon.png"
        @click="openSocialLink(socialAttributes.url)"
      />
    </section>
  </div>
</template>

<style scoped lang="scss">
.SocialPlatform {
  padding: 10px;

  &__header {
    margin: 10px;
    font-style: italic;
    font-weight: bold;
    font-size: 20px;
  }

  &__section {
    display: inline-block;
    padding: 15px;
    width: 22px;
    height: 22px;
    color: grey;
  }
}
</style>
