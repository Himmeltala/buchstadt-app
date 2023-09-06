import { defineConfig } from "vite";
import vue from "@vitejs/plugin-vue";
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import Icons from "unplugin-icons/vite";
import IconsResolver from "unplugin-icons/resolver";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import UnoCSS from "unocss/vite";
import { resolve } from "path";

export default defineConfig(({ command, mode }) => {
  return {
    build: {
      target: "modules",
      outDir: "dist/",
      assetsDir: "static",
      sourcemap: true,
      rollupOptions: {
        input: {
          mainApp: resolve(__dirname, "index.html"),
          subappAdmin: resolve(__dirname, "apps/subapp-admin/index.html")
        },
        output: {
          entryFileNames: "static/js/[name]-[hash].js",
          chunkFileNames: "static/js/[name]-[hash].js",
          assetFileNames: "static/[ext]/name-[hash].[ext]"
        }
      }
    },
    plugins: [
      vue(),
      UnoCSS(),
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
            "@mainapp/apis/use-axios": ["mainappRequest"]
          },
          {
            "@common/apis/use-axios": ["axiosInstance"]
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
        dirs: [
          "common/components/**",
          "common/fragments/**",
          `apps/mainapp/views/**`,
          `apps/mainapp/components/**`,
          `apps/mainapp/fragments/**`,
          `apps/subapp-admin/views/**`,
          `apps/subapp-admin/components/**`,
          `apps/subapp-admin/fragments/**`
        ]
      }),
      Icons({
        autoInstall: true
      })
    ],
    resolve: {
      alias: {
        "@common": resolve(__dirname, "common"),
        "@mainapp": resolve(__dirname, "apps/mainapp"),
        "@subapp-admin": resolve(__dirname, "apps/subapp-admin")
      }
    }
  };
});
