/**
 * 查询一个出版社
 *
 * @param id 出版社 id
 */
export async function queryOne(id: number) {
  const { data } = await mainappRequest.get<R<PublisherPoJo>>("/pub/public/query/one", { params: { id } });
  return data.data;
}
