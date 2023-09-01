export async function queryAll() {
  const { data } = await axiosInstance.post<HttpResponse>(`/user/query/all`);
  return data.data;
}

export async function query(params: { id: number }) {
  const { data } = await axiosInstance.post<HttpResponse>(`/user/query`, params);
  return data.data;
}

export async function insert(vo: UserVo) {
  await axiosInstance.post(`/user/insert`, vo);
}

export async function update(vo: UserVo) {
  await axiosInstance.post(`/user/update`, vo);
}

export async function del(vo: UserVo) {
  await axiosInstance.post(`/user/delete`, vo);
}
