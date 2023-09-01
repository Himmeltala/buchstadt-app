import { defineConfig, UserConfig, loadEnv } from "vite";
import vue from "@vitejs/plugin-vue";
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import Icons from "unplugin-icons/vite";
import IconsResolver from "unplugin-icons/resolver";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import UnoCSS from "unocss/vite";
import { resolve } from "path";

interface VitestConfigExport extends UserConfig {}

const clientPath = "src/project/client";
const adminPath = "src/project/admin";

export default defineConfig(({ command, mode }) => {
  const env = loadEnv(mode, process.cwd(), "");

  return {
    build: {
      target: "modules",
      outDir: "dist/" + env.VITE_APP_NAME + "/",
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
          `${clientPath}/views/**`,
          `${clientPath}/components/**`,
          `${clientPath}/fragments/**`,
          `${adminPath}/views/**`,
          `${adminPath}/components/**`,
          `${adminPath}/fragments/**`
        ]
      }),
      Icons({
        autoInstall: true
      })
    ],
    resolve: {
      alias: {
        "@root": resolve(__dirname, "src"),
        "@admin": resolve(__dirname, adminPath),
        "@client": resolve(__dirname, clientPath)
      }
    }
  } as VitestConfigExport;
});
