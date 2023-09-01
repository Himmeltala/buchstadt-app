export async function query(status?: string) {
  const { data } = await axiosInstance.post<HttpResponse>(
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
  await axiosInstance.post(
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
  await axiosInstance.post("/order/update", vo, { params });
}
