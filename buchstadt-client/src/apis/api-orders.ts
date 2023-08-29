export async function query(params: { userId: number; status: string }) {
  try {
    const {
      data: { data }
    } = await axiosInstance.post("/order/query", params, { cancelToken: axiosInstance.cancelSource.token });
    return data;
  } catch (error) {
    if (axiosInstance.isCancel(error)) {
      ElMessage.warning(error.message);
    }
  }
}

export async function del(params: { userId: number; id: number }) {
  return new Promise(async (resolve, reject) => {
    try {
      const { data } = await axiosInstance.post("/order/delete", params);
      if (data.status == 200) {
        resolve(data.status);
      } else {
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

export async function update(params: { id: number; status: string }, o: { id: number }) {
  return new Promise(async (resolve, reject) => {
    try {
      const { data } = await axiosInstance.post("/order/update", params, { params: o });
      if (data.status == 200) {
        resolve(data.status);
      } else {
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
