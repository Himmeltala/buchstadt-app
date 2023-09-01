export async function queryAll() {
  const { data } = await axiosInstance.post<HttpResponse>(`/admin/query/all`);
  return data.data;
}

export async function del(params: AdminVo) {
  await axiosInstance.post<HttpResponse>(`/admin/delete`, params);
}

export async function update(params: AdminVo) {
  await axiosInstance.post<HttpResponse>(`/admin/update`, params);
}

export async function insert(params: AdminVo) {
  await axiosInstance.post<HttpResponse>(`/admin/insert`, params);
}
