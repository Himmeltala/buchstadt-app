# 目录说明

本项目有主项目（客户端）和子项目（管理端）。两个项目都会共用 common 模块下的函数。

```
- buchstadt-web
  - apps
    - mainapp // 主项目客户端
    - subapp-admin // 子项目管理端
  - common // 公共模块
```

# 学习总结

## 配置多应用

只需要管理好两个项目的 index.html 即可，把两个项目的目录分配正确。并且配置 vite.config.ts 文件。具体查看我的博客[Vite - 配置多页面应用](https://www.cnblogs.com/himmelbleu#/p/17681769)。

## 函数重用

使用一个项目下多个应用的目的是重用组件、函数、api 等，两个项目会共同使用很多个 ts 实体类型的定义。

## tsconfig

通过本项目更加熟悉了 tsconfig.json 配置的使用和这个文件在整个 ts 项目中起到的作用。

## TypeScript

通过本项目更加熟悉 TypeScript 的作用和使用。TypeScript 相对于 JavaScript，有更好的类型提示，在开发一个业务之前，将所需类型定义好之后，在多人项目的开发过程中不容易出错，这样可以减少因出错调式的时间，提升工作效率。

但目前，TypeScript 还是需要编译变成 JavaScript 才可以在浏览器中运行。所以，它不目前来说不可能代替 JavaScript。

## axios

后端返回统一的数据响应代码，针对这些代码，配置 axios 的响应拦截器，统一对这些响应做出请求回馈给客户端，让用户知道必要信息。

但是，不是每一个请求的接口的响应都是需要通过提示框显示在页面上的，一般，query 接口不需要显示提示框，而与操作相关的，比如 update、insert 等都会有一个消息提示，让用户知道操作是否成功。

所以，针对这一情况，以下函数非常重要，需要对特定 url 进行过滤。

```ts
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

axios.interceptors.response.use(
  config => {
    const { data } = config;

    // 对于 query 开头的请求进行过滤
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
```
