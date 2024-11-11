<script setup lang="ts">
import {
  ElImage,
  ElText,
  ElRow,
  ElCol,
} from "@/components/core/components/index.ts";
import RouterHeader from "@/components/home-page/components/RouterHeader.vue";
import SocialPlatform from "@/components/home-page/components/SocialPlatform.vue";
import FooterArea from "@/components/home-page/components/FooterArea.vue";

export interface SocialAttributes {
  imagePath: string;
  url: string;
}

const socialAttributes: SocialAttributes[] = [
  {
    imagePath: "linkeLinIcon",
    url: "https://www.linkedin.com/in/radoslaw-kopec/",
  },
  {
    imagePath: "githubIcon",
    url: "https://github.com/RadoslawKopec93 ",
  },
];
</script>

<template>
  <section>
    <RouterHeader />
    <div class="AboutMe">
      <ElRow>
        <ElCol class="AboutMe__descriptionContainer" :span="12">
          <h4 class="AboutMe__header">Who Am I?</h4>
          <ElText class="AboutMe__descriptionContainer--text" size="large">
            I am <strong>Radosław Kopeć</strong>, a passionate and dedicated
            full-stack developer with a strong foundation in creating engaging
            and user-friendly web experiences.
          </ElText>
          <ElText class="AboutMe__descriptionContainer--text" size="large">
            I have over <strong>two years of experience</strong>, mainly in
            <strong>front-end</strong> development in the
            <strong>Vue.js</strong> framework
          </ElText>
          <ElText class="AboutMe__descriptionContainer--text" size="large">
            Currently I am a <strong>full-stack developer</strong>, working with
            <strong>Java</strong> on the backend side.
          </ElText>
          <ElText class="AboutMe__descriptionContainer--text" size="large">
            I have refined my skills in crafting dynamic, responsive interfaces
            that seamlessly blend functionality with modern design.
          </ElText>
          <ElText class="AboutMe__descriptionContainer--text" size="large">
            My journey as a developer is driven by curiosity and a commitment to
            staying at the forefront of emerging technologies.
          </ElText>
          <ElText class="AboutMe__descriptionContainer--text" size="large">
            I thrive on collaboration, problem-solving, and bringing creative
            ideas to life through code.
          </ElText>
        </ElCol>
        <ElCol :span="12">
          <ElImage
            class="AboutMe__photoContainer--photo"
            :src="require('@/assets/img/me.jpg')"
          />
        </ElCol>
      </ElRow>
      <ElRow>
        <ElCol :span="12" :offset="12">
          <SocialPlatform
            class="AboutMe__footer--social"
            :social-attributes="socialAttributes"
          />
        </ElCol>
      </ElRow>
      <FooterArea />
    </div>
  </section>
</template>

<style scoped lang="scss">
.AboutMe {
  padding-top: 100px;

  &__footer {
    padding-top: 50px;
    padding-bottom: 50px;

    &--social {
      padding-left: 150px;
    }
  }

  &__header {
    font-size: 30px;
    padding-bottom: 10px;
    width: 750px;
    align-self: end;
  }

  &__photoContainer {
    justify-self: start;

    &--photo {
      width: 550px;
      height: 100%;
      padding-left: 150px;
    }
  }

  &__descriptionContainer {
    display: flex;
    flex-direction: column;
    justify-content: start;
    align-items: center;
    width: 100%;
    box-sizing: border-box;
    padding-right: 50px;

    &--text {
      line-height: 2.8;
      overflow-wrap: break-word;
      overflow: hidden;
      width: 750px;
      text-align: left;
      margin-bottom: 30px;
      align-self: end;
    }
  }
}
</style>
