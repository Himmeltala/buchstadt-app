export async function signin(body: { username: string; password: string }) {
  const { data } = await axiosInstance.post("/entry/signin", body);
  if (data.status == 200) {
    localStorage.setUID(data.data.id);
    localStorage.setUser(data.data);
  }
}

export async function signup(body: any) {
  return new Promise((resolve, reject) => {
    axiosInstance.post("/entry/signup", body).then(({ data }) => {
      if (data.status == 200) {
        ElMessage.success(data.message);
        setTimeout(() => {
          resolve(data);
        }, 1500);
      } else {
        ElMessage.error(data.message);
        reject(data.message);
      }
    });
  });
}
