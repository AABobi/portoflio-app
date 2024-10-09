<script setup lang="ts">
import { ElImage, ElText } from "@/components/core/components/index.ts"
import RouterHeader from "@/components/home-page/components/RouterHeader.vue";
import {useRouter} from "vue-router";

const router = useRouter();

const headerButtons = ["about","home"];

const routePath = () => {
  router.push("/auth")
}

const t1 = [routePath]
</script>

<template>
  <section>
    <RouterHeader :button-name="headerButtons" :route-path="t1"/>
    <div class="AboutMe">
      <div class="AboutMe__photoContainer">
         <ElImage class="AboutMe__photo" :src="require('@/assets/img/me.jpg')"/>
      </div>
      <div class="AboutMe__descriptionContainer">
        <h4 class="AboutMe__header">Who Am I?</h4>
        <ElText class="AboutMe__descriptionContainer--text" size="large">
          I am <strong>Radosław Kopeć</strong>, a passionate and dedicated full-stack developer with a strong foundation in creating engaging and user-friendly web experiences.
        </ElText>
        <ElText class="AboutMe__descriptionContainer--text" size="large">
          I have over <strong>two years of experience</strong>, mainly in <strong>front-end</strong> development in the <strong>Vue.js</strong> framework
        </ElText>
        <ElText class="AboutMe__descriptionContainer--text" size="large">
          I have refined my skills in crafting dynamic, responsive interfaces that seamlessly blend functionality with modern design.
        </ElText>
        <ElText class="AboutMe__descriptionContainer--text" size="large">
          My journey as a developer is driven by curiosity and a commitment to staying at the forefront of emerging technologies.
        </ElText>
        <ElText class="AboutMe__descriptionContainer--text" size="large">
          I thrive on collaboration, problem-solving, and bringing creative ideas to life through code.
        </ElText>
        <ElText class="AboutMe__descriptionContainer--text" size="large">
          I am currently a <strong>full-stack developer</strong>, working with <strong>Java</strong> on the backend side.
        </ElText>
        <span class="AboutMe__descriptionContainer--text">asdsa</span>
        <span class="AboutMe__descriptionContainer--text">asdsa</span>
<!--        <ElText> Test</ElText>
        <ElText> Test</ElText>-->

      </div>
    </div>
  </section>
</template>

<style scoped lang="scss">
.AboutMe {
  display: grid;
  grid-template-columns: 1fr 2fr;
  padding-top: 100px;

  &__header {
    font-size: 30px;
    padding-bottom: 10px;
  }

  &__photoContainer {
    justify-self: end;
    padding-left: 50px;
  }

  &__photo {
    width: 500px;
    height: 100%;
    padding-right: 50px;
  }

  &__descriptionContainer {
    display: flex;
    flex-direction: column;
    justify-content: start;
    max-width: 700px;
    box-sizing: border-box;
    padding-left: 50px;

    
    &--text {
      overflow-wrap: break-word;
     // max-width: 200px;
      overflow: hidden;
      text-align: left;
      margin-bottom: 30px;
      align-self: start;
    }
  }
}
</style>