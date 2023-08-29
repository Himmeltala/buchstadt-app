export function signin(body: { username: string; password: string }) {
  return new Promise((resolve, reject) => {
    axiosInstance.post("/entry/signin", body).then(({ data }) => {
      if (data.status == 200) {
        localStorage.setUID(data.data.id);
        localStorage.setUser(data.data);
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
