export async function query(status?: string) {
  const { data } = await axiosInstance.post<R>(
    "/order/query",
    {},
    {
      params: {
        status
      }
    }
  );
  return data.data;
}

export async function del(id: number) {
  await axiosInstance.post<R>(
    "/order/delete",
    {},
    {
      params: {
        id
      }
    }
  );
}

export async function update(vo: any, params: { id: number }) {
  await axiosInstance.post<R>("/order/update", vo, { params });
}
