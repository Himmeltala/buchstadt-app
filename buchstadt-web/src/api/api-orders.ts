export async function query(status: string) {
  const {
    data: { data }
  } = await axiosInstance.post(
    "/order/query",
    {},
    {
      params: {
        status
      }
    }
  );
  return data;
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

export async function update(params: { id: number; status: string }, o: { id: number }) {
  await axiosInstance.post("/order/update", params, { params: o });
}
