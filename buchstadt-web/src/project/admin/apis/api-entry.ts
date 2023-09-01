export namespace EntryApi {
  export async function signin(body: { username: string; password: string }) {
    const { data } = await axiosInstance.post("/entry/admin/signin", body);
    if (data.status == 200) {
      localStorage.setItem("userId", data.data.id);
      localStorage.setItem("userInfo", JSON.stringify(data.data));
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }
}
