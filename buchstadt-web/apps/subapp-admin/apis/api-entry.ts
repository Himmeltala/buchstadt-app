export async function signin(body: { username: string; password: string }) {
  const {
    data: { data }
  } = await axiosInstance.post<TokenR>("/entry/public/admin-signin", body);
  localStorage.setAdminToken(data);
}
