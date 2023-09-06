export async function signin(body: { username: string; password: string }) {
  const {
    data: { data }
  } = await mainappRequest.post<TokenR>("/entry/public/user-signin", body);
  localStorage.setUserToken(data);
}

export async function signup(body: any) {
  await mainappRequest.post("/entry/public/signup", body);
}
