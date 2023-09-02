export async function signin(body: { username: string; password: string }) {
  const {
    data: { data }
  } = await axiosInstance.post<HttpResponse>("/entry/signin", body);
  localStorage.setUID(data.id);
  localStorage.setUser(data);
}

export async function signup(body: any) {
  await axiosInstance.post("/entry/signup", body);
}

export async function adminSignin(body: { username: string; password: string }) {
  const {
    data: { data }
  } = await axiosInstance.post<HttpResponse>("/entry/admin/signin", body);
  localStorage.setUID(data.id);
  localStorage.setUser(data);
}
