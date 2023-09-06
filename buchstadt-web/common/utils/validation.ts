export function isAuthed() {
  return !!localStorage.getToken();
}
