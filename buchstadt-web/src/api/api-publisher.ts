export async function queryOne(params: { id: number }) {
  const { data } = await axiosInstance.post("/publisher/public/query/one", params);
  return data;
}

export async function queryAll() {
  const { data } = await axiosInstance.post("/publisher/auth/query/all");
  return data;
}

export async function updateOne(params: any) {
  await axiosInstance.post("/publisher/auth/update/one", params);
}

export async function insertOne(params: any) {
  await axiosInstance.post<R>("/publisher/auth/insert/one", params);
}

export async function deleteOne(params: any) {
  await axiosInstance.post<R>(`/publisher/auth/delete/one`, params);
}

export async function queryPubOps() {
  const {
    data: { data: res }
  } = await axiosInstance.post<R>(`/publisher/auth/query/ops`);
  return res;
}
