import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "uno.css";

import "@client/style.scss";
import "@root/utils/local-storage";

const app = createApp(App);

app.use(router);
app.mount("#app");
