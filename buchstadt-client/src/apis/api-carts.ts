export async function insert(params: { buchId: number; num: number }) {
  const d = Object.assign(params, {
    userId: localStorage.getUID()
  });

  try {
    const { data } = await axiosInstance.post("/cart/insert", d, { cancelToken: axiosInstance.cancelSource.token });
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

export async function query() {
  try {
    const {
      data: { data }
    } = await axiosInstance.get("/cart/query", {
      params: {
        userId: localStorage.getUID()
      },
      cancelToken: axiosInstance.cancelSource.token
    });
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

export async function pay(params: PayForData) {
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
