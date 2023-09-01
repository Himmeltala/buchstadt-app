export namespace TrolleyApi {
  export async function insert(params: { userId: number; buchId: number; num: number }) {
    try {
      const { data } = await axiosInstance.post("/cart/insert", params, { cancelToken: axiosInstance.cancelSource.token });
      if (data.status == 200) {
        ElMessage.success(data.message);
      } else {
        ElMessage.error(data.message);
      }
    } catch (error) {
      if (axiosInstance.isCancel(error)) {
        ElMessage.warning(error.message);
      }
    }
  }

  export async function query(params: { userId: number }) {
    try {
      const {
        data: { data }
      } = await axiosInstance.get("/cart/query", { params, cancelToken: axiosInstance.cancelSource.token });
      return data;
    } catch (error) {
      if (axiosInstance.isCancel(error)) {
        ElMessage.warning(error.message);
      }
    }
  }

  export async function del(params: { id: number }) {
    try {
      const { data } = await axiosInstance.post("/cart/delete", params, { cancelToken: axiosInstance.cancelSource.token });
      if (data.status == 200) {
        ElMessage.success(data.message);
      } else {
        ElMessage.error(data.message);
      }
    } catch (error) {
      if (axiosInstance.isCancel(error)) {
        ElMessage.warning(error.message);
      }
    }
  }

  export async function pay(params: PayVo) {
    return new Promise(async (resolve, reject) => {
      try {
        const { data } = await axiosInstance.post("/cart/payfor", params, { cancelToken: axiosInstance.cancelSource.token });
        if (data.status == 200) {
          ElMessage.success(data.message);
          resolve(data.status);
        } else {
          ElMessage.error(data.message);
          reject();
        }
      } catch (error) {
        if (axiosInstance.isCancel(error)) {
          ElMessage.warning(error.message);
        }
        reject();
      }
    });
  }
}
