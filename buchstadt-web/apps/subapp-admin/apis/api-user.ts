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

export namespace AddressApi {
  /**
   * 新增一个地址
   *
   * @param data 地址实体类
   */
  export async function insertOne(data: AddressPoJo) {
    return await subappAdminRequest.post<R<number>>("/user/auth/insert/one-address", data);
  }

  /**
   * 获取该用户所有的地址
   */
  export async function queryAll(params?: { uid: boolean }) {
    let queryParams = {};
    if (params?.uid) {
      const uid = localStorage.getToken().id;
      queryParams = Object.assign(params, { uid });
    } else queryParams = params;
    const { data } = await subappAdminRequest.get<R<AddressPoJo[]>>("/user/auth/query/all-addresses", {
      params: queryParams
    });
    return data.data;
  }

  /**
   * 设置地址为默认地址
   *
   * @param id 地址 id
   */
  export async function updateDefault(id: number) {
    return await subappAdminRequest.put<R<number>>("/user/auth/update/address-default", {}, { params: { id } });
  }

  /**
   * 更新地址
   *
   * @param data 地址实体类
   */
  export async function updateOne(data: AddressPoJo) {
    return await subappAdminRequest.put<R<number>>("/user/auth/update/one-address", data);
  }

  /**
   * 删除地址
   *
   * @param id 地址 id
   */
  export async function deleteOne(id: number) {
    return await subappAdminRequest.delete<R<number>>("/user/auth/delete/one-address", { params: { id } });
  }

  export async function queryOne(params: { isDefault: number }) {
    const { data } = await subappAdminRequest.get<R<AddressPoJo>>("/user/auth/query/one-address", { params });
    return data.data;
  }
}
