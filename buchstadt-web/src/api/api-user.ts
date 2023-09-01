export async function queryAll() {
  const { data } = await axiosInstance.post(`/user/query/all`);
  return data;
}

export async function query(params: { id: number }) {
  const { data } = await axiosInstance.post(`/user/query`, params);
  return data;
}

export async function insert(params: UserData) {
  await axiosInstance.post(`/user/insert`, params);
}

export async function update(params: UserData) {
  await axiosInstance.post(`/user/update`, params);
}

export async function del(params: UserData) {
  await axiosInstance.post(`/user/delete`, params);
}
