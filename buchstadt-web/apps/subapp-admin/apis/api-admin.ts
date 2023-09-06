/**
 * 查询所有管理员
 */
export async function queryAll(params: { pageSize: number; currPage: number }) {
  const { data } = await subappAdminRequest.get<R<PageInfo<AdminPoJo[]>>>(`/admin/auth/query/all`, { params });
  return data.data;
}

/**
 * 删除一个管理员
 *
 * @param id 管理员 id
 */
export async function deleteOne(id: number) {
  await subappAdminRequest.delete<R<number>>(`/admin/auth/delete/one`, {
    params: { id }
  });
}

/**
 * 更新管理员信息
 *
 * @param data 管理员实体类
 */
export async function updateOne(data: AdminPoJo) {
  await subappAdminRequest.put<R<number>>(`/admin/auth/update/one`, data);
}

/**
 * 插入一个新的管理员
 *
 * @param data 管理员实体类
 */
export async function insertOne(data: AdminPoJo) {
  await subappAdminRequest.post<R<number>>(`/admin/auth/insert/one`, data);
}
