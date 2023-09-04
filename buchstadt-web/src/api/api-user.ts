export async function queryAll() {
  const { data } = await axiosInstance.post<R<UserPojo[]>>(`/user/auth/query/all`);
  return data.data;
}

export async function queryOne(params: { id: number }) {
  const { data } = await axiosInstance.post<R<UserPojo>>(`/user/auth/query/one`, params);
  return data.data;
}

export async function insertOne(vo: UserVo) {
  return await axiosInstance.post<R<number>>(`/user/auth/insert/one`, vo);
}

export async function updateOne(vo: UserVo) {
  return await axiosInstance.post<R<number>>(`/user/auth/update/one`, vo);
}

export async function deleteOne(vo: UserVo) {
  return await axiosInstance.post<R<void>>(`/user/auth/delete/one`, vo);
}

export async function updatePwd(vo: { oldPasswd: string; newPasswd: string }) {
  const { data } = await axiosInstance.put<R<void>>("/user/auth/update/pwd", vo);

  if (data.status === 200) {
    localStorage.logout();
    location.reload();
  }
}
