/**
 * 购物车相关 API
 */

/**
 * 把书籍加入到购物车
 *
 * @param id 书籍 ID
 * @param num 书籍数量
 */
export async function insert(id: number, num: number) {
  await axiosInstance.post(
    "/cart/insert",
    {},
    {
      params: {
        id,
        num
      }
    }
  );
}

/**
 * 查询用户加入购物车的书籍
 */
export async function query() {
  const {
    data: { data }
  } = await axiosInstance.get("/cart/query");
  return data;
}

/**
 * 删除购物车中的书籍
 *
 * @param id 书籍 ID
 */
export async function del(id: number) {
  await axiosInstance.post(
    "/cart/delete",
    {},
    {
      params: {
        id
      }
    }
  );
}

/**
 * 将购物车中的书本以及收货地址插入到数据库中
 */
export async function pay(params: PayForData) {
  await axiosInstance.post("/cart/pay", params);
}
