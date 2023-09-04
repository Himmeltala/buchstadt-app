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

/**
 * 新增一个地址
 *
 * @param data 地址实体类
 */
export async function insertOneAddress(data: AddressVo) {
  return await axiosInstance.post<R<number>>("/user/auth/insert/one-address", data);
}

/**
 * 获取该用户所有的地址
 */
export async function queryAllAddresses() {
  const { data } = await axiosInstance.get<R<AddressPojo[]>>("/user/auth/query/all-addresses");
  return data.data;
}

/**
 * 设置地址为默认地址
 *
 * @param id 地址 id
 */
export async function setAddressIsDefault(id: number) {
  return await axiosInstance.put<R<number>>("/user/auth/update/address-default", {}, { params: { id } });
}
