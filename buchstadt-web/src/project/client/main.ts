import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "@client/style.scss";

import "uno.css";
import "@root/util/local-storage";

const app = createApp(App);

app.use(router);
app.mount("#app");
