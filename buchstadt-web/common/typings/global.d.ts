declare type R<T> = {
  data: T;
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
  logoutAdmin(): void;
  logoutUser(): void;
  /**
   * 设置客户端用户的 Token
   */
  setUserToken(vlaue: Token): void;
  /**
   * 获取客户端用户的 Token
   */
  getUserToken(): Token;
  /**
   * 设置管理端管理员的 Token
   */
  setAdminToken(vlaue: Token): void;
  /**
   * 获取管理端管理员的 Token
   */
  getAdminToken(): Token;
}

declare type PageInfo<T> = {
  total: number;
  list: T[];
  pageNum: number;
  pageSize: number;
  size: number;
  startRow: number;
  endRow: number;
  pages: number;
  prePage: number;
  nextPage: number;
  isFirstPage: boolean;
  isLastPage: boolean;
  hasPreviousPage: boolean;
  hasNextPage: boolean;
  navigatePages: number;
  navigatePageNums: number[];
  navigateFirstPage: number;
  navigateLastPage: number;
};
