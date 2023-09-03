/**
 * 查询一个出版社
 *
 * @param id 出版社 id
 */
export async function queryOne(id: number) {
  const { data } = await axiosInstance.get<R<PublisherPojo>>("/publisher/public/query/one", { params: { id } });
  return data.data;
}

/**
 * 查询所有出版社
 */
export async function queryAll() {
  const { data } = await axiosInstance.get<R<PublisherPojo[]>>("/publisher/auth/query/all");
  return data.data;
}

/**
 * 更新出版社信息
 *
 * @param data 出版社实体类
 */
export async function updateOne(data: any) {
  return await axiosInstance.put<R<number>>("/publisher/auth/update/one", data);
}

/**
 * 插入一个出版社
 *
 * @param data 出版社实体类
 */
export async function insertOne(data: any) {
  return await axiosInstance.post<R<number>>("/publisher/auth/insert/one", data);
}

/**
 * 删除一个出版社
 *
 * @param id 出版社 id
 */
export async function deleteOne(id: number) {
  return await axiosInstance.delete<R<number>>(`/publisher/auth/delete/one`, { params: { id } });
}

/**
 * 查询出版社作为 element-plus 组件使用
 */
export async function queryPubOps() {
  const { data } = await axiosInstance.get<R<{ label: string; value: string }[]>>(`/publisher/auth/query/ops`);
  return data.data;
}
