import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import "@mainapp/style.scss";

import "uno.css";
import "@common/utils/local-storage";

const app = createApp(App);

app.use(router);
app.mount("#app");
