Storage.prototype.logout = () => {
  localStorage.removeItem("Token");
  location.reload();
};

Storage.prototype.getToken = () => {
  const token = localStorage.getItem("Token");
  if (!token) return null;
  return JSON.parse(token);
};

Storage.prototype.setToken = (value: any) => {
  localStorage.setItem("Token", JSON.stringify(value));
};
