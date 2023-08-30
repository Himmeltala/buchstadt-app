export namespace EntryApi {
  export async function signin(body: { username: string; password: string }) {
    return new Promise(async (resolve, reject) => {
      const { data } = await axiosInstance.post("/entry/admin/signin", body);
      if (data.status == 200) {
        localStorage.setItem("userId", data.data.id);
        localStorage.setItem("userInfo", JSON.stringify(data.data));
        ElMessage.success(data.message);
        setTimeout(() => {
          resolve("");
        }, 1500);
      } else {
        ElMessage.error(data.message);
        reject(data.message);
      }
    });
  }
}
