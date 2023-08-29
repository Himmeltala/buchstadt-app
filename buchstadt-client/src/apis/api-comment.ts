export async function query(params?: { buchType?: string; buchId?: number }) {
  const {
    data: { data }
  } = await axiosInstance.get("/buch/comment/query", { params });
  return data;
}

export async function insert(params: { content: string; type: string; buchId: number }) {
  const d = Object.assign(params, {
    userId: localStorage.getUID()
  });

  const { data } = await axiosInstance.post("/buch/comment/insert", d);
  if (data.status == 200) {
    ElMessage.success(data.message);
  } else {
    ElMessage.error(data.message);
  }
  return data;
}
