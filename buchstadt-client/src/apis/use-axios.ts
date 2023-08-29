import axios from "axios";
import type { InternalAxiosRequestConfig } from "axios";

const axiosInstance = axios.create({
  baseURL: `http://${import.meta.env.VITE_URL}:9000/api`
});

axiosInstance.cancelSource = axios.CancelToken.source();
axiosInstance.isCancel = axios.isCancel;

/**
 * 配置需要登录验证的接口
 */
function UrlAuthInterceptor(config: InternalAxiosRequestConfig): boolean {
  const url = ["/entry/signin", "/entry/signup", "/buch/query", "/buch/query/all", "/buch/comment/query"];
  const ths = url.find((v, i) => config.url === v);
  const pass = !(config.url === ths);
  return ths ? false : pass;
}

axiosInstance.interceptors.request.use(
  config => {
    if (!localStorage.getUID() && UrlAuthInterceptor(config)) {
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

/**
 * 配置不需要消息提示的接口
 */
function UrlNotMessageInterceptor(config: InternalAxiosRequestConfig): boolean {
  const url = ["/buch/query", "/buch/query/all", "/buch/comment/query"];
  const ths = url.find((v, i) => config.url === v);
  const pass = !(config.url === ths);
  return ths ? false : pass;
}

axiosInstance.interceptors.response.use(
  config => {
    const { data, config: conf } = config;

    if (data.status === 200 && UrlNotMessageInterceptor(conf)) {
      ElMessage.success(data.message);
    }

    if (data.status === 500) {
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
