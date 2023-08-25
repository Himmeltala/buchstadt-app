import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import Icons from "unplugin-icons/vite";
import IconsResolver from "unplugin-icons/resolver";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import UnoCSS from "unocss/vite";

export default defineConfig({
  base: "/buchstadt-admin",
  server: {
    port: 5273
  },
  plugins: [
    vue(),
    UnoCSS({
      configFile: "./uno.config.ts"
    }),
    AutoImport({
      include: [
        /\.[tj]sx?$/, // .ts, .tsx, .js, .jsx
        /\.vue$/,
        /\.vue\?vue/ // .vue
      ],
      imports: [
        "vue",
        "pinia",
        "vue-router",
        "@vueuse/core",
        {
          "@/apis/use-axios": ["axiosInstance"]
        }
      ],
      resolvers: [
        ElementPlusResolver(),
        IconsResolver({
          prefix: "Icon"
        })
      ],
      vueTemplate: true,
      dts: "./auto-imports.d.ts"
    }),
    Components({
      resolvers: [
        ElementPlusResolver(),
        IconsResolver({
          enabledCollections: ["ep"]
        })
      ],
      dirs: ["./src/views/**", "./src/components/**", "./src/segements/**"]
    }),
    Icons({
      autoInstall: true
    })
  ],
  resolve: {
    alias: {
      "@": "/src"
    }
  }
});
