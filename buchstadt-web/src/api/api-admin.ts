export async function queryAll() {
  const { data } = await axiosInstance.post<R>(`/admin/query/all`);
  return data.data;
}

export async function del(params: AdminVo) {
  await axiosInstance.post<R>(`/admin/delete`, params);
}

export async function update(params: AdminVo) {
  await axiosInstance.post<R>(`/admin/update`, params);
}

export async function insert(params: AdminVo) {
  await axiosInstance.post<R>(`/admin/insert`, params);
}
