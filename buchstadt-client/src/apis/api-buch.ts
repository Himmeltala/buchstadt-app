/**
 * 关于书籍的 API
 */

/**
 * 收藏书籍
 *
 * @param id 书籍 ID
 */
export async function collect(id: number) {
  const { data } = await axiosInstance.post(
    "/buch/collection/insert",
    {},
    {
      params: {
        id
      }
    }
  );
  return data;
}

/**
 * 查询收藏的书籍
 */
export async function queryCollections() {
  const {
    data: { data }
  } = await axiosInstance.get("/buch/collection/query");
  return data;
}

/**
 * 查询书籍
 *
 * @param id 书籍 ID
 */
export async function query(id: number) {
  const { data } = await axiosInstance.get<HttpResponse>(`/buch/query`, {
    params: {
      id
    }
  });

  return data.data;
}

/**
 * 查询书籍列表
 *
 * isPrime：是否热门
 * buchName：书籍名称
 * type：书籍类别
 *
 * @param params 查询参数
 */
export async function queryAll(params?: { isPrime?: number; buchName?: string; type?: string }) {
  const { data } = await axiosInstance.get<HttpResponse>(`/buch/query/all`, {
    params
  });
  return data.data;
}
