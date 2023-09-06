/**
 * 查询一个书籍
 *
 * @param id 书籍 id
 */
export async function queryOne(id: number) {
  const { data } = await mainappRequest.get<R<BuchPoJo>>(`/buch/public/query/one`, {
    params: { id }
  });
  return data.data;
}

/**
 * 查询所有书籍
 *
 * @param params isPrime、name、type
 */
export async function queryAll(params?: { isPrime?: number; name?: string; type?: string; currPage?: number; pageSize?: number }) {
  const { data } = await mainappRequest.get<R<PageInfo<BuchPoJo[]>>>(`/buch/public/query/all`, { params });
  return data.data;
}

/**
 * 通过页码查询所有书籍
 *
 * @param params currPage、pageSize
 */
export async function queryAllByPage(params: { currPage: number; pageSize: number }) {
  const { data } = await mainappRequest.get<R<PageInfo<BuchPoJo>>>(`/buch/public/query/all-by-page`, { params });
  return data.data;
}

/**
 * 收藏书籍
 *
 * @param buchId 书籍 id
 */
export async function insertOneCollection(buchId: number) {
  return await mainappRequest.post<R<void>>("/buch/auth/insert/one-collection", {}, { params: { buchId } });
}

/**
 * 查询所有收藏的书籍
 */
export async function queryAllCollection() {
  const { data } = await mainappRequest.get<R<CollectionPoJo[]>>("/buch/auth/query/all-collection");
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
  const { data } = await mainappRequest.get<R<CommentPoJo[]>>("/buch/public/query/all-comment", { params });
  return data.data;
}

/**
 * 插入一条评论
 *
 * @param data 评论实体类
 */
export function insertOneComment(data: { content: string; type: string; buchId: number; userId?: number }) {
  return mainappRequest.post<R<void>>("/buch/auth/insert/one-comment", data);
}
