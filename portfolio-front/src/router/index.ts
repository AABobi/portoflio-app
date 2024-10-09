import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import AuthPage from "@/components/authentication/components/AuthPage.vue";
import AboutMe from "@/components/home-page/components/AboutMe.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/auth",
    name: "auth-page",
    component: AuthPage,
  },
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
