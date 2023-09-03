export async function queryAll(status?: string) {
  const { data } = await axiosInstance.post<R>(
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
  await axiosInstance.post<R>(
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
  await axiosInstance.post<R>("/order/auth/update/one", vo, { params });
}
