export function useSplicedRef<T>(value: T) {
  return customRef((track, trigger) => {
    return {
      get() {
        track();
        return value;
      },
      set(newValue) {
        //

        console.log(newValue);

        value = newValue;

        trigger();
      }
    };
  });
}
