import axios from "axios";
import type { InternalAxiosRequestConfig } from "axios";

const axiosInstance = axios.create({
  baseURL: `http://${import.meta.env.VITE_URL}:9000/api`
});

axiosInstance.cancelSource = axios.CancelToken.source();
axiosInstance.isCancel = axios.isCancel;

function UrlInterceptor(config: InternalAxiosRequestConfig) {
  const url = ["/entry/signin", "/entry/signup", "/buch/query", "/buch/query/all", "/buch/comment/query"];
  const ths = url.find((v, i) => config.url === v);
  const pass = !(config.url === ths);
  return ths ? false : pass;
}

axiosInstance.interceptors.request.use(
  config => {
    if (!localStorage.getUID() && UrlInterceptor(config)) {
      axiosInstance.cancelSource.cancel("您没有登陆！");
      ElMessage.error("您没有权限这样做，请先登录！");
      return Promise.reject();
    }

    config.headers["Uid"] = localStorage.getUID();

    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

axiosInstance.interceptors.response.use(
  config => {
    const { data } = config;

    if (data.code === 500) {
      ElMessage.error(data.message);
      return Promise.reject(data.message);
    }

    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

export { axiosInstance };
