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
export function insert(body: { content: string; type: string; id: number }) {
  return axiosInstance.post("/buch/comment/insert", body);
}
