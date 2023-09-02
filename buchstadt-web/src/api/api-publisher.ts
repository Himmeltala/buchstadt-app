export async function query(params: { id: number }) {
  const { data } = await axiosInstance.post("/publisher/query", params);
  return data;
}

export async function queryAll() {
  const { data } = await axiosInstance.post("/publisher/query/all");
  return data;
}

export async function update(params: any) {
  const { data } = await axiosInstance.post("/publisher/update", params);
  if (data == 1) {
    ElMessage.success("更新成功");
  } else {
    ElMessage.error("更新失败");
  }
}

export async function insert(params: any) {
  const { data } = await axiosInstance.post<R>("/publisher/insert", params);
}

export async function delPublisher(params: any) {
  const { data } = await axiosInstance.post<R>(`/publisher/delete`, params);
}

export async function queryPubOps() {
  const {
    data: { data: res }
  } = await axiosInstance.post<R>(`/publisher/query/ops`);
  return res;
}
