export function isAuthed() {
  return !!localStorage.getAdminToken();
}
