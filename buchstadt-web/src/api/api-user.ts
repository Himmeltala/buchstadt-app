export async function queryAll() {
  const { data } = await axiosInstance.post<R<UserPojo[]>>(`/user/auth/query/all`);
  return data.data;
}

export async function queryOne(id: number) {
  const { data } = await axiosInstance.get<R<UserPojo>>(`/user/auth/query/one`, { params: { id } });
  return data.data;
}

export async function insertOne(data: UserPojo) {
  return await axiosInstance.post<R<number>>(`/user/auth/insert/one`, data);
}

export async function updateOne(data: UserPojo) {
  return await axiosInstance.put<R<number>>(`/user/auth/update/one`, data);
}

export async function deleteOne(data: UserPojo) {
  return await axiosInstance.post<R<void>>(`/user/auth/delete/one`, data);
}

export async function updatePwd(vo: { oldPasswd: string; newPasswd: string }) {
  const { data } = await axiosInstance.put<R<void>>("/user/auth/update/pwd", vo);

  if (data.status === 200) {
    localStorage.logout();
    location.reload();
  }
}

export namespace AddressApi {
  /**
   * 新增一个地址
   *
   * @param data 地址实体类
   */
  export async function insertOne(data: AddressPoJo) {
    return await axiosInstance.post<R<number>>("/user/auth/insert/one-address", data);
  }

  /**
   * 获取该用户所有的地址
   */
  export async function queryAll() {
    const { data } = await axiosInstance.get<R<AddressPoJo[]>>("/user/auth/query/all-addresses");
    return data.data;
  }

  /**
   * 设置地址为默认地址
   *
   * @param id 地址 id
   */
  export async function updateDefault(id: number) {
    return await axiosInstance.put<R<number>>("/user/auth/update/address-default", {}, { params: { id } });
  }

  /**
   * 更新地址
   *
   * @param data 地址实体类
   */
  export async function updateOne(data: AddressPoJo) {
    return await axiosInstance.put<R<number>>("/user/auth/update/one-address", data);
  }

  /**
   * 删除地址
   *
   * @param id 地址 id
   */
  export async function deleteOne(id: number) {
    return await axiosInstance.delete<R<number>>("/user/auth/delete/one-address", { params: { id } });
  }
}
