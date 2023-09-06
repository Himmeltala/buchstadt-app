export async function signin(body: { username: string; password: string }) {
  const {
    data: { data }
  } = await subappAdminRequest.post<TokenR>("/entry/public/admin-signin", body);
  localStorage.setAdminToken(data);
}
