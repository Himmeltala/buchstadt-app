declare type HttpResponse = {
  data: any;
  message: string;
  status: number;
};

declare interface Storage {
  setUID(value: string): void;
  getUID(): numbere;
  setUser(value: any): void;
  getUser(): any;
  logout(): void;
}
