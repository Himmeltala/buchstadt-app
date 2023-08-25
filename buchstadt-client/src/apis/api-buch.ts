export namespace BuchApi {
  export async function collect(params: { userId: number; buchId: number }) {
    const { data } = await axiosInstance.post("/buch/collection/insert", params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
    return data;
  }

  export async function queryCollections(params: { userId: number }) {
    const {
      data: { data }
    } = await axiosInstance.get("/buch/collection/query", { params });
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
}
