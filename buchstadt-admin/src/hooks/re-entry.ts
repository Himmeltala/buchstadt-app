import type { RouteLocationNormalizedLoaded } from "vue-router";

export function useReEntry(name: string, route: RouteLocationNormalizedLoaded, entry: Function) {
  return () => {
    let lastName = "";

    watch(route, (newVal, oldVal) => {
      console.log(route.name);

      if (lastName === name) {
        console.log("yes");
        entry();
      } else {
        console.log("no");
      }

      lastName = newVal.name.toString();
    });
  };
}
