import type { InternalAxiosRequestConfig } from "axios";

/**
 * 匹配 URL 是否包含指定字符串的拦截器
 *
 * 在 axios 拦截器中做全局的消息提示或错误处理时，或者某些 URL 可能不需要携带 Token 时可用。
 *
 * @param axiosConfig axios 的请求配置
 * @param configure 可以精准匹配 URL，也可以模糊匹配 URL 字符串
 * @returns 如果匹配到了就返回 true，如果没有匹配就返回 false
 */
export function notInterceptUrl(
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
