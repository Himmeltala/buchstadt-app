export async function queryAll() {
  const { data } = await axiosInstance.post<R>(`/user/auth/query/all`);
  return data.data;
}

export async function query(params: { id: number }) {
  const { data } = await axiosInstance.post<R>(`/user/auth/query`, params);
  return data.data;
}

export async function insert(vo: UserVo) {
  await axiosInstance.post<R>(`/user/auth/insert`, vo);
}

export async function update(vo: UserVo) {
  await axiosInstance.post<R>(`/user/auth/update`, vo);
}

export async function del(vo: UserVo) {
  await axiosInstance.post<R>(`/user/auth/delete`, vo);
}
