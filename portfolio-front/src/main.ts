import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "element-plus/dist/index.css";
import "../src/components/core/index.scss";
import { createPinia } from "pinia";

/*
const pinia = createPinia()

createApp(App)
    .use(router)
    .use(pinia)
    .mount("#app");
*/

function main() {
  const { mount, use } = createApp(App);
  const pinia = createPinia();
  use(router);
  use(pinia);
  mount("#app");
}

main();
