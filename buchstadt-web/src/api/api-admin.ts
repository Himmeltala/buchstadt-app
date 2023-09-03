/**
 * 查询所有管理员
 */
export async function queryAll() {
  const { data } = await axiosInstance.get<R<AdminPojo[]>>(`/admin/auth/query/all`);
  return data.data;
}

/**
 * 删除一个管理员
 *
 * @param id 管理员 id
 */
export async function deleteOne(id: number) {
  await axiosInstance.delete<R<number>>(`/admin/auth/delete/one`, {
    params: { id }
  });
}

/**
 * 更新管理员信息
 *
 * @param data 管理员实体类
 */
export async function updateOne(data: AdminPojo) {
  await axiosInstance.put<R<number>>(`/admin/auth/update/one`, data);
}

/**
 * 插入一个新的管理员
 *
 * @param data 管理员实体类
 */
export async function insertOne(data: AdminPojo) {
  await axiosInstance.post<R<number>>(`/admin/auth/insert/one`, data);
}
