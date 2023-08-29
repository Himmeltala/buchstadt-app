export async function insert(id: number, num: number) {
  try {
    const { data } = await axiosInstance.post(
      "/cart/insert",
      { cancelToken: axiosInstance.cancelSource.token },
      {
        params: {
          id,
          num
        }
      }
    );
    if (data.status == 200) {
      ElMessage.success(data.message);
    }
  } catch (error) {
    if (axiosInstance.isCancel(error)) {
      ElMessage.warning(error.message);
    }
  }
}

export async function query() {
  const {
    data: { data }
  } = await axiosInstance.get("/cart/query");
  return data;
}

export async function del(id: number) {
  const { data } = await axiosInstance.post("/cart/delete", {
    params: {
      id
    }
  });
  if (data.status == 200) {
    ElMessage.success(data.message);
  }
}

export async function pay(params: PayForData) {
  const { data } = await axiosInstance.post("/cart/pay", params);
  if (data.status == 200) {
    ElMessage.success(data.message);
  }
}
