/**
 * 购物车相关 API
 */

/**
 * 把书籍加入到购物车
 *
 * @param vo 购物车书籍项
 */
export async function insert(vo: CartItemVo) {
  await axiosInstance.post<HttpResponse>("/cart/insert", vo);
}

/**
 * 查询用户加入购物车的书籍
 */
export async function query() {
  const { data } = await axiosInstance.get<HttpResponse>("/cart/query");
  return data.data;
}

/**
 * 删除购物车中的书籍
 *
 * @param vo 购物车书籍项
 */
export async function del(vo: CartItemVo) {
  await axiosInstance.post<HttpResponse>("/cart/delete", vo);
}

/**
 * 将购物车中的书本以及收货地址插入到数据库中
 */
export async function pay(vo: PayVo) {
  await axiosInstance.post<HttpResponse>("/cart/pay", vo);
}
