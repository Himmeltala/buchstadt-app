export function isAuthed(isAdmin: boolean) {
  if (isAdmin) return !!localStorage.getAdminToken();
  else return !!localStorage.getUserToken();
}
