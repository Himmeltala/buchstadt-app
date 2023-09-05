/**
 * 查询所有订单
 *
 * @param status 根据订单状态查询
 * @param uid    用户 id
 */
export async function queryAll(status?: string) {
  const { data } = await axiosInstance.get<R<OrderPoJo[]>>("/order/auth/query/all", {
    params: {
      status
    }
  });
  return data.data;
}

/**
 * 删除一个订单
 *
 * @param id  订单 id
 * @param uid 用户 id
 */
export async function deleteOne(id: number) {
  return await axiosInstance.delete<R<void>>("/order/auth/delete/one", {
    params: {
      id
    }
  });
}

/**
 * 更新订单数据
 *
 * @param map 订单实体类，与 Order 实体类对应
 * @param id  订单 id
 */
export async function updateOne(vo: any, params: { id: number }) {
  return await axiosInstance.put<R<void>>("/order/auth/update/one", vo, { params });
}
