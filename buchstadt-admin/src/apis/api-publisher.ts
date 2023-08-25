export namespace PublisherApi {
  export async function query(params: { id: number }) {
    const { data } = await axiosInstance.post("/publisher/query", params);
    return data;
  }

  export async function queryAll() {
    const { data } = await axiosInstance.post("/publisher/query/all");
    return data;
  }

  export async function update(params: any) {
    const { data } = await axiosInstance.post("/publisher/update", params);
    if (data == 1) {
      ElMessage.success("更新成功");
    } else {
      ElMessage.error("更新失败");
    }
  }

  export async function insert(params: any) {
    const { data } = await axiosInstance.post("/publisher/insert", params);
    if (data == 1) {
      ElMessage.success("添加成功");
    } else {
      ElMessage.error("添加失败");
    }
  }

  export async function delPublisher(params: any) {
    const { data } = await axiosInstance.post(`/publisher/delete`, params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }

  export async function queryPubOps() {
    const { data } = await axiosInstance.post(`/publisher/query/ops`);
    return data;
  }
}
