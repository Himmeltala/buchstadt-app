/**
 * 把书籍加入到购物车
 *
 * @param vo 购物车书籍项
 */
export async function insertCart(vo: { id: number; num?: number }) {
  return await mainappRequest.post<R<void>>("/cart/auth/insert/one-item", vo);
}

/**
 * 查询用户加入购物车的书籍
 */
export async function queryCart() {
  const { data } = await mainappRequest.get<R<CartPoJo[]>>("/cart/auth/query/all");
  return data.data;
}

/**
 * 删除购物车中的书籍
 *
 * @param id 书籍 id
 */
export async function delCart(id: number) {
  return await mainappRequest.delete<R<void>>("/cart/auth/delete/one", { params: { id } });
}

/**
 * 将购物车中的书本以及收货地址插入到数据库中
 */
export async function payOrder(vo: PayVo) {
  return await mainappRequest.post<R<void>>("/cart/auth/pay", vo);
}
