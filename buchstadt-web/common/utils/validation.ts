export function isAuthed(type: "admin" | "main") {
  if (type === "admin") return !!localStorage.getAdminToken();
  else return !!localStorage.getUserToken();
}
