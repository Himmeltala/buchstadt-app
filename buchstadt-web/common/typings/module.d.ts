export {};

declare module "axios" {
  interface AxiosInstance {}
}

declare module "vue" {
  interface ComponentCustomProperties {}
}

declare module "vue-router" {
  interface RouteMeta {
    title: string;
  }
}
