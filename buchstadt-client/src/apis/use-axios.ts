import axios from "axios";
import type { InternalAxiosRequestConfig } from "axios";

const axiosInstance = axios.create({
  baseURL: `http://${import.meta.env.VITE_URL}:9000/api`
});

axiosInstance.cancelSource = axios.CancelToken.source();
axiosInstance.isCancel = axios.isCancel;

/**
 * URL 拦截器。
 *
 * 在 axios 拦截器中做全局的消息提示或错误处理时，某些 URL 可能不需要这些拦截处理。
 *
 * @param axiosConfig axios 的请求配置
 * @param configure 可以精准匹配 URL，也可以模糊匹配 URL 字符串
 * @returns 如果匹配到了就返回 false，如果没有匹配就返回 true
 */
function UrlNotTypeMessageInterceptor(
  axiosConfig: InternalAxiosRequestConfig,
  configure?: {
    precise?: string[];
    fuzzy?: string[];
  }
): boolean {
  if (configure.fuzzy && !configure.precise) {
    const ths = configure.fuzzy.some(ele => {
      const regex = new RegExp(ele);
      return regex.test(axiosConfig.url);
    });
    return !ths;
  } else {
    const ths = configure.precise.find(v => axiosConfig.url === v);
    return !(axiosConfig.url === ths);
  }
}

const authUrl = ["/entry/signin", "/entry/signup", "/buch/query", "/buch/query/all", "/buch/comment/query", "/publisher/query"];

axiosInstance.interceptors.request.use(
  config => {
    if (
      !localStorage.getUID() &&
      UrlNotTypeMessageInterceptor(config, {
        precise: authUrl
      })
    ) {
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

    if (
      data.status === 200 &&
      UrlNotTypeMessageInterceptor(config.config, {
        fuzzy: ["query"]
      })
    ) {
      ElMessage.success(data.message);
    }

    if (data.status === 400) {
      ElMessage.warning(data.message);
      return Promise.reject(data.message);
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
