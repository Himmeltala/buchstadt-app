/**
 * 查询一个书籍
 *
 * @param id 书籍 id
 */
export async function queryOne(id: number) {
  const { data } = await axiosInstance.get<R<BuchPojo>>(`/buch/public/query/one`, {
    params: { id }
  });
  return data.data;
}

/**
 * 查询所有书籍
 *
 * @param params isPrime、name、type
 */
export async function queryAll(params?: { isPrime?: number; name?: string; type?: string }) {
  const { data } = await axiosInstance.get<R<BuchPojo[]>>(`/buch/public/query/all`, { params });
  return data.data;
}

/**
 * 更新一个书籍
 *
 * @param data 书籍实体类
 */
export async function updateOne(data: BuchPojo) {
  return await axiosInstance.put<R<void>>(`/buch/auth/update/one`, data);
}

/**
 * 插入书籍
 *
 * @param data 书籍实体类
 */
export async function insertOne(data: BuchPojo) {
  return await axiosInstance.post<R<void>>(`/buch/auth/insert/one`, data);
}

/**
 * 插入书籍的附表数据
 *
 * @param data 书籍实体类
 */
export async function insertOneAttach(data: BuchPojo) {
  return await axiosInstance.post<R<void>>(`/buch/auth/insert/one-attach`, data);
}

/**
 * 删除书籍下的一个标签
 *
 * @param tagId 标签 id
 * @param buchId 书籍 id
 */
export async function deleteOneTag(tagId: number, buchId: number) {
  return await axiosInstance.delete<R<void>>(`/buch/auth/delete/one-tag`, { params: { tagId, buchId } });
}

/**
 * 删除书籍下的一个作者
 *
 * @param authorId 作者 id
 * @param buchId 书籍 id
 */
export async function deleteOneAuthor(authorId: number, buchId: number) {
  return await axiosInstance.delete<R<void>>(`/buch/auth/delete/one-author`, { params: { authorId, buchId } });
}

/**
 * 删除书籍下的一个预览图
 *
 * @param previewId 预览图 id
 * @param buchId 书籍 id
 */
export async function deleteOnePreview(previewId: number, buchId: number) {
  return await axiosInstance.delete<R<void>>(`/buch/auth/delete/one-preview`, { params: { previewId, buchId } });
}

/**
 * 删除一个书籍
 *
 * @param id 书籍 id
 */
export async function deleteOne(id: number) {
  return await axiosInstance.delete<R<void>>(`/buch/auth/delete/one`, { params: { id } });
}

/**
 * 收藏书籍
 *
 * @param buchId 书籍 id
 */
export async function insertOneCollection(buchId: number) {
  return await axiosInstance.post<R<void>>("/buch/auth/insert/one-collection", {}, { params: { buchId } });
}

/**
 * 查询所有收藏的书籍
 */
export async function queryAllCollection() {
  const { data } = await axiosInstance.get<R<CollectionPojo[]>>("/buch/auth/query/all-collection");
  return data.data;
}

/**
 * 根据条件查询所有评论
 *
 * @param id     根据书籍 id 查询评论
 * @param type   根据书籍类型查询评论
 * @param diggOp 根据书籍赞成类型查询
 * @param buryOp 根据书籍反对类型查询
 * @param digg   根据书籍赞成数量查询，与 diggOp 搭配使用
 * @param bury   根据书籍反对数量查询，与 buryOp 搭配使用
 */
export async function queryAllComment(params: {
  id?: number;
  type?: string;
  diggOp?: string;
  buryOp?: string;
  digg?: number;
  bury?: number;
}) {
  const { data } = await axiosInstance.get<R<CommentPojo[]>>("/buch/public/query/all-comment", { params });
  return data.data;
}

/**
 * 插入一条评论
 *
 * @param data 评论实体类
 */
export function insertOneComment(data: { content: string; type: string; buchId: number; userId?: number }) {
  return axiosInstance.post<R<void>>("/buch/auth/insert/one-comment", data);
}

/**
 * 删除一条评论
 *
 * @param id 评论 id
 */
export async function deleteOneComment(id: number) {
  return await axiosInstance.delete<R<void>>("/buch/auth/delete/one-comment", { params: id });
}
