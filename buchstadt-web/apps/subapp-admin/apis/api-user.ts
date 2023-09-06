export async function queryAll(params: { pageSize: number; currPage: number }) {
  const { data } = await subappAdminRequest.get<R<PageInfo<UserPoJo[]>>>(`/user/auth/query/all`, { params });
  return data.data;
}

export async function queryOne(id: number) {
  const { data } = await subappAdminRequest.get<R<UserPoJo>>(`/user/auth/query/one`, { params: { id } });
  return data.data;
}

export async function insertOne(data: UserPoJo) {
  return await subappAdminRequest.post<R<number>>(`/user/auth/insert/one`, data);
}

export async function updateOne(data: UserPoJo) {
  return await subappAdminRequest.put<R<number>>(`/user/auth/update/one`, data);
}

export async function deleteOne(data: UserPoJo) {
  return await subappAdminRequest.post<R<void>>(`/user/auth/delete/one`, data);
}

export async function updatePwd(vo: { oldPasswd: string; newPasswd: string }) {
  const { data } = await subappAdminRequest.put<R<void>>("/user/auth/update/pwd", vo);

  if (data.status === 200) {
    localStorage.logout();
    location.reload();
  }
}
