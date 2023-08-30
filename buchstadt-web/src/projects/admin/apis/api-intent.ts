export namespace IntentApi {
  export async function query(params?: { userId: number; status: string }) {
    const {
      data: { data }
    } = await axiosInstance.post("/order/query", params);
    return data;
  }

  export async function del(params: { userId: number; id: number }) {
    return new Promise(async (resolve, reject) => {
      const { data } = await axiosInstance.post("/order/delete", params);
      if (data.status == 200) {
        resolve(data.status);
      } else {
        reject();
      }
    });
  }

  export async function update(
    params: {
      location: string;
      id: number;
      status: string;
      payway: string;
      holderName: string;
      holderPhoe: string;
    },
    id: string | number
  ) {
    const { data } = await axiosInstance.post("/order/update", params, { params: { id } });
    if (data.status == 200) {
      ElMessage.success("更新订单信息成功！");
    } else {
      ElMessage.error("更新订单信息失败");
    }
  }
}
