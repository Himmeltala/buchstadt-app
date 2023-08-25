export namespace PublisherApi {
  export async function query(params: { id: number }) {
    const { data } = await axiosInstance.post("/publisher/query", params);
    return data;
  }
}
