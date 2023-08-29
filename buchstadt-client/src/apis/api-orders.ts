export async function query(status: string) {
  try {
    const {
      data: { data }
    } = await axiosInstance.post(
      "/order/query",
      { cancelToken: axiosInstance.cancelSource.token },
      {
        params: {
          status
        }
      }
    );
    return data;
  } catch (error) {
    if (axiosInstance.isCancel(error)) {
      ElMessage.warning(error.message);
    }
  }
}

export async function del(params: { id: number }) {
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
