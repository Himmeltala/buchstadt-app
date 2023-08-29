/**
 * 查询书籍的评论列表
 *
 * @param type 评论类型
 * @param id 书籍 ID
 */
export async function query(type?: string, id?: number) {
  const {
    data: { data }
  } = await axiosInstance.get("/buch/comment/query", {
    params: {
      type,
      id
    }
  });
  return data;
}

/**
 * 插入一条评论
 */
export async function insert(params: { content: string; type: string; buchId: number }) {
  const { data } = await axiosInstance.post("/buch/comment/insert", params);
  return data;
}
