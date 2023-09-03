export async function queryAll() {
  const { data } = await axiosInstance.post<R>(`/admin/auth/query/all`);
  return data.data;
}

export async function deleteOne(vo: AdminVo) {
  await axiosInstance.post<R>(`/admin/auth/delete/one`, vo);
}

export async function updateOne(vo: AdminVo) {
  await axiosInstance.post<R>(`/admin/auth/update/one`, vo);
}

export async function insertOne(vo: AdminVo) {
  await axiosInstance.post<R>(`/admin/auth/insert/one`, vo);
}
