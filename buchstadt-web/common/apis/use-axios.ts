import axios from "axios";
import type { InternalAxiosRequestConfig } from "axios";
import { isAuthed } from "@common/utils/validation";

const axiosInstance = axios.create({
  baseURL: `http://127.0.0.1:9000/api`
});

/**
 * 匹配 URL 是否包含指定字符串的拦截器
 *
 * 在 axios 拦截器中做全局的消息提示或错误处理时，或者某些 URL 可能不需要携带 Token 时可用。
 *
 * @param axiosConfig axios 的请求配置
 * @param configure 可以精准匹配 URL，也可以模糊匹配 URL 字符串
 * @returns 如果匹配到了就返回 true，如果没有匹配就返回 false
 */
function notInterceptUrl(
  axiosConfig: InternalAxiosRequestConfig,
  configure: {
    precise?: string[];
    fuzzy?: string[];
  }
): boolean {
  if (configure.fuzzy && !configure.precise) {
    const ths = configure.fuzzy.some(ele => {
      const regex = new RegExp(ele);
      return regex.test(axiosConfig.url);
    });
    return !!ths;
  } else {
    const ths = configure.precise.find(v => axiosConfig.url === v);
    return !!(axiosConfig.url === ths);
  }
}

axiosInstance.interceptors.request.use(
  config => {
    // 已经认证，且 URL 不是 signin、signup、public
    if (
      isAuthed() &&
      !notInterceptUrl(config, {
        fuzzy: ["signin", "signup", "public"]
      })
    ) {
      const token = localStorage.getToken();
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

axiosInstance.interceptors.response.use(
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

export { axiosInstance };
