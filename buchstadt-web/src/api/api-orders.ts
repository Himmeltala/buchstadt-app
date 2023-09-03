export async function queryAll(status?: string) {
  const { data } = await axiosInstance.post<R<OrderPojo[]>>(
    "/order/auth/query/all",
    {},
    {
      params: {
        status
      }
    }
  );
  return data.data;
}

export async function deleteOne(id: number) {
  return await axiosInstance.post<R<void>>(
    "/order/auth/delete/one",
    {},
    {
      params: {
        id
      }
    }
  );
}

export async function updateOne(vo: any, params: { id: number }) {
  return await axiosInstance.post<R<void>>("/order/auth/update/one", vo, { params });
}
