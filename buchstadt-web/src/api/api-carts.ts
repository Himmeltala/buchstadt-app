/**
 * 把书籍加入到购物车
 *
 * @param vo 购物车书籍项
 */
export async function insert(vo: CartItemVo) {
  return await axiosInstance.post<R<void>>("/cart/auth/insert/one-item", vo);
}

/**
 * 查询用户加入购物车的书籍
 */
export async function query() {
  const { data } = await axiosInstance.get<R<CartPojo[]>>("/cart/auth/query/all");
  return data.data;
}

/**
 * 删除购物车中的书籍
 *
 * @param id 书籍 id
 */
export async function del(id: number) {
  return await axiosInstance.delete<R<void>>("/cart/auth/delete/one", { params: { id } });
}

/**
 * 将购物车中的书本以及收货地址插入到数据库中
 */
export async function pay(vo: PayVo) {
  return await axiosInstance.post<R<void>>("/cart/auth/pay", vo);
}
