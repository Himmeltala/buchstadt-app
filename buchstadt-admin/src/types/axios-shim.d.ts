export {};

declare module "axios" {
  interface AxiosInstance {
    cancelSource: CancelTokenSource;
    isCancel(value: any): value is Cancel;
  }
}
