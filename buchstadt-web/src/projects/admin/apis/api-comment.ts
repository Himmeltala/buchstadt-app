export namespace CommentApi {
  export async function query(params?: { buchType?: string; buchId?: number }) {
    const {
      data: { data }
    } = await axiosInstance.get("/buch/comment/query", { params });
    return data;
  }

  export async function insert(params: { content: string; type: string; buchId: number; userId: number }) {
    const { data } = await axiosInstance.post("/buch/comment/insert", params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
    return data;
  }

  export async function delComm(params: { id: number }) {
    const { data } = await axiosInstance.post("/buch/comment/delete", params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
    return data;
  }
}
