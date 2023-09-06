import axios from "axios";
import { notInterceptUrl } from "@common/utils/interceptor";
import { isAuthed } from "@mainapp/utils/validation";

const mainappRequest = axios.create({
  baseURL: `http://127.0.0.1:9000/api`
});

mainappRequest.interceptors.request.use(
  config => {
    if (
      isAuthed() &&
      !notInterceptUrl(config, {
        fuzzy: ["signin", "signup", "public"]
      })
    ) {
      const token = localStorage.getUserToken();
      if (token) {
        config.headers["Uid"] = token.id;
        config.headers["Token"] = "Bearer " + token.value;
      }
    }

    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

mainappRequest.interceptors.response.use(
  config => {
    const { data } = config;

    if (
      data.status === 200 &&
      !notInterceptUrl(config.config, {
        fuzzy: ["query"]
      })
    ) {
      ElMessage.success(data.message);
    }

    if (data.status === 400) {
      ElMessage.warning(data.message);
    }

    if (data.status === 500) {
      ElMessage.error(data.message);
    }

    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

export { mainappRequest };
