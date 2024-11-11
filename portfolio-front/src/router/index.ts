import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import AboutMe from "@/components/home-page/components/AboutMe.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "about-me",
    component: AboutMe,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
