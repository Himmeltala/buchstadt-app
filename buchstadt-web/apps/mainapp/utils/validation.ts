export function isAuthed() {
  return !!localStorage.getUserToken();
}
