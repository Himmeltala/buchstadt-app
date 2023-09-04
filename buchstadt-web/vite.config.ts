import { defineConfig, loadEnv } from "vite";
import vue from "@vitejs/plugin-vue";
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import Icons from "unplugin-icons/vite";
import IconsResolver from "unplugin-icons/resolver";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import UnoCSS from "unocss/vite";
import { resolve } from "path";
import { injectHtml } from "./vite-index";

const script = process.env.npm_lifecycle_event;
const { name } = injectHtml("./", script, { title: "Buchstadt" });

const CLIENT_PATH = "src/project/client";
const ADMIN_PATTH = "src/project/admin";

export default defineConfig(({ command, mode }) => {
  return {
    build: {
      target: "modules",
      outDir: "dist/" + name + "/",
      assetsDir: "static",
      sourcemap: true,
      rollupOptions: {
        input: {
          main: resolve(__dirname, "index.html"),
          projectClient: resolve(__dirname, "project/client/index.html"),
          projectAdmin: resolve(__dirname, "project/admin/index.html")
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
            "@root/api/use-axios": ["axiosInstance"]
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
          "src/components/**",
          `${CLIENT_PATH}/views/**`,
          `${CLIENT_PATH}/components/**`,
          `${CLIENT_PATH}/fragments/**`,
          `${ADMIN_PATTH}/views/**`,
          `${ADMIN_PATTH}/components/**`,
          `${ADMIN_PATTH}/fragments/**`
        ]
      }),
      Icons({
        autoInstall: true
      })
    ],
    resolve: {
      alias: {
        "@root": resolve(__dirname, "src"),
        "@admin": resolve(__dirname, ADMIN_PATTH),
        "@client": resolve(__dirname, CLIENT_PATH)
      }
    }
  };
});
