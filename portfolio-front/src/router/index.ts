import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import AuthPage from "@/components/authentication/components/AuthPage.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/",
    name: "auth-page",
    component: AuthPage,
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
