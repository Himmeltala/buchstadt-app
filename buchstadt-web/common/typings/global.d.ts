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
  logout(): void;
  setToken(value: Token): void;
  getToken(): Token;
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
