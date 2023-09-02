/**
 * 查询书籍的评论列表
 */
export async function query(vo: BuchCommentVo) {
  const { data } = await axiosInstance.post<HttpResponse>("/buch-comment/query", vo);
  return data.data;
}

/**
 * 插入一条评论
 */
export function insert(body: { content: string; type: string; buchId: number; userId?: number }) {
  return axiosInstance.post<HttpResponse>("/buch-comment/insert", body);
}

export async function delComm(params: { id: number }) {
  const { data } = await axiosInstance.post<HttpResponse>("/buch-comment/delete", params);
  return data.data;
}
