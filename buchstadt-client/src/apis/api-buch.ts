export async function collect(params: { buchId: number }) {
  const d = Object.assign(params, {
    userId: localStorage.getUID()
  });

  const { data } = await axiosInstance.post("/buch/collection/insert", d);
  if (data.status == 200) {
    ElMessage.success(data.message);
  } else {
    ElMessage.error(data.message);
  }
  return data;
}

export async function queryCollections() {
  const {
    data: { data }
  } = await axiosInstance.get("/buch/collection/query", {
    params: {
      userId: localStorage.getUID()
    }
  });
  return data;
}

export async function query(params: { buchId: number }) {
  const { data } = await axiosInstance.get(`/buch/query`, {
    params
  });
  return data;
}

export async function queryAll(params?: { isPrime?: number; buchName?: string; type?: string }) {
  const { data } = await axiosInstance.get(`/buch/query/all`, {
    params
  });
  return data;
}
