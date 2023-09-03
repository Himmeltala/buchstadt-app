export async function queryOne(params: { id: number }) {
  const { data } = await axiosInstance.post<R<PublisherPojo>>("/publisher/public/query/one", params);
  return data.data;
}

export async function queryAll() {
  const { data } = await axiosInstance.post<R<PublisherPojo[]>>("/publisher/auth/query/all");
  return data.data;
}

export async function updateOne(params: any) {
  return await axiosInstance.post<R<number>>("/publisher/auth/update/one", params);
}

export async function insertOne(params: any) {
  return await axiosInstance.post<R<number>>("/publisher/auth/insert/one", params);
}

export async function deleteOne(params: any) {
  return await axiosInstance.post<R<number>>(`/publisher/auth/delete/one`, params);
}

export async function queryPubOps() {
  const { data } = await axiosInstance.post<R<{ label: string; value: string }[]>>(`/publisher/auth/query/ops`);
  return data.data;
}
