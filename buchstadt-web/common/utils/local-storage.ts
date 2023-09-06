Storage.prototype.logoutUser = () => {
  localStorage.removeItem("User-Token");
  location.reload();
};

Storage.prototype.getUserToken = () => {
  const token = localStorage.getItem("User-Token");
  if (!token) return null;
  return JSON.parse(token);
};

Storage.prototype.setUserToken = (value: any) => {
  localStorage.setItem("User-Token", JSON.stringify(value));
};

Storage.prototype.logoutAdmin = () => {
  localStorage.removeItem("Admin-Token");
  location.reload();
};

Storage.prototype.getAdminToken = () => {
  const token = localStorage.getItem("Admin-Token");
  if (!token) return null;
  return JSON.parse(token);
};

Storage.prototype.setAdminToken = (value: any) => {
  localStorage.setItem("Admin-Token", JSON.stringify(value));
};
