Storage.prototype.setUID = (value: string) => {
  localStorage.setItem("UID", value);
};

Storage.prototype.getUID = () => {
  return Number(localStorage.getItem("UID"));
};

Storage.prototype.setUser = (value: any) => {
  localStorage.setItem("User", JSON.stringify(value));
};

Storage.prototype.getUser = () => {
  const user = localStorage.getItem("User");
  return JSON.parse(user);
};

Storage.prototype.logout = () => {
  localStorage.removeItem("User");
  localStorage.removeItem("UID");
};
