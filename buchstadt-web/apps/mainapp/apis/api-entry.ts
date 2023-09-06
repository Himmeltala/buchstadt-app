export async function signin(body: { username: string; password: string }) {
  const {
    data: { data }
  } = await axiosInstance.post<TokenR>("/entry/public/user-signin", body);
  localStorage.setToken(data);
}

export async function signup(body: any) {
  await axiosInstance.post("/entry/public/signup", body);
}
