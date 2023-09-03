declare type R = {
  data: any;
  message: string;
  status: number;
};

declare type Token = {
  authority?: string;
  username: string;
  avatar: string;
  value: string;
  type: string;
  id: number;
};

declare type TokenR = {
  data: Token;
  message: string;
  status: number;
};

declare interface Storage {
  logout(): void;
  setToken(value: Token): void;
  getToken(): Token;
}
