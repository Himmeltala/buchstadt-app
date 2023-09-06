export async function queryOne(id: number) {
  const { data } = await mainappRequest.get<R<UserPoJo>>(`/user/auth/query/one`, { params: { id } });
  return data.data;
}

export async function updateOne(data: UserPoJo) {
  return await mainappRequest.put<R<number>>(`/user/auth/update/one`, data);
}

export async function updatePwd(vo: { oldPasswd: string; newPasswd: string }) {
  const { data } = await mainappRequest.put<R<void>>("/user/auth/update/pwd", vo);

  if (data.status === 200) {
    localStorage.logout();
    location.reload();
  }
}
