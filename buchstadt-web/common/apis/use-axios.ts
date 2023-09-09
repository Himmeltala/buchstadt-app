import axios from "axios";
import type { AxiosResponse } from "axios";
import { notInterceptUrl } from "@common/utils/interceptor";
import { isAuthed } from "@common/utils/validation";

const instanceConfig = {
  baseURL: `http://127.0.0.1:9000/api`,
  timeout: 5000
};

const responseConfig = (config: AxiosResponse) => {
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
};

const mainappRequest = axios.create(instanceConfig);

/* mainapp axios instance */

mainappRequest.interceptors.request.use(
  config => {
    if (
      isAuthed("main") &&
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

mainappRequest.interceptors.response.use(responseConfig, error => {
  return Promise.reject(error);
});

/* subapp admin axios instance */

const subappAdminRequest = axios.create(instanceConfig);

subappAdminRequest.interceptors.request.use(
  config => {
    if (
      isAuthed("admin") &&
      !notInterceptUrl(config, {
        fuzzy: ["signin", "signup", "public"]
      })
    ) {
      const token = localStorage.getAdminToken();
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

subappAdminRequest.interceptors.response.use(responseConfig, error => {
  return Promise.reject(error);
});

export { mainappRequest, subappAdminRequest };
