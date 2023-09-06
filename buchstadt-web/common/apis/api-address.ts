/**
 * 新增一个地址
 *
 * @param data 地址实体类
 */
export async function insertOne(data: AddressPoJo, uid: number) {
  return await commonRequest.post<R<number>>("/user/auth/insert/one-address", data, { params: { uid } });
}

/**
 * 获取某用户的所有地址
 *
 * @param uid 用户 id
 */
export async function queryAllAddressByUid(uid: number, pageSize?: number, currPage?: number) {
  const { data } = await commonRequest.get<R<PageInfo<AddressPoJo[]>>>("/user/auth/query/all-address-by-uid", {
    params: { uid, pageSize, currPage }
  });
  return data.data;
}

/**
 * 设置地址为默认地址
 *
 * @param id 地址 id
 */
export async function updateDefault(id: number, uid: number) {
  return await commonRequest.put<R<number>>("/user/auth/update/address-default", {}, { params: { id, uid } });
}

/**
 * 更新地址
 *
 * @param data 地址实体类
 */
export async function updateOne(data: AddressPoJo, uid: number) {
  return await commonRequest.put<R<number>>("/user/auth/update/one-address", data, { params: { uid } });
}

/**
 * 删除地址
 *
 * @param id 地址 id
 */
export async function deleteOne(id: number, uid: number) {
  return await commonRequest.delete<R<number>>("/user/auth/delete/one-address", { params: { id, uid } });
}

/**
 * 查询用户的某一个地址
 *
 * @param params 是否为默认值
 */
export async function queryOne(params: { isDefault: number }) {
  const { data } = await commonRequest.get<R<AddressPoJo>>("/user/auth/query/one-address", { params });
  return data.data;
}
