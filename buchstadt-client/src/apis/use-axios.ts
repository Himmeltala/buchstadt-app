import axios from "axios";

const axiosInstance = axios.create({
  baseURL: `http://${import.meta.env.VITE_URL}:9000/api`
});

axiosInstance.cancelSource = axios.CancelToken.source();
axiosInstance.isCancel = axios.isCancel;

axiosInstance.interceptors.request.use(
  config => {
    if (!localStorage.getUID()) {
      axiosInstance.cancelSource.cancel("您没有登陆，本次操作取消！");
    }

    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

axiosInstance.interceptors.request.use(
  config => {
    return config;
  },
  error => {
    return Promise.reject(error);
  }
);

export { axiosInstance };
