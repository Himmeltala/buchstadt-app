export async function collect(id: number) {
  const { data } = await axiosInstance.post(
    "/buch/collection/insert",
    {},
    {
      params: {
        id
      }
    }
  );
  if (data.status == 200) {
    ElMessage.success(data.message);
  }
  return data;
}

export async function queryCollections() {
  const {
    data: { data }
  } = await axiosInstance.get("/buch/collection/query");
  return data;
}

export async function query(id: number) {
  const { data } = await axiosInstance.get(`/buch/query`, {
    params: {
      id
    }
  });
  return data;
}

export async function queryAll(params?: { isPrime?: number; buchName?: string; type?: string }) {
  const { data } = await axiosInstance.get(`/buch/query/all`, {
    params
  });
  return data;
}
