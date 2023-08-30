import { defineConfig, UserConfig, loadEnv } from "vite";
import vue from "@vitejs/plugin-vue";
import AutoImport from "unplugin-auto-import/vite";
import Components from "unplugin-vue-components/vite";
import Icons from "unplugin-icons/vite";
import IconsResolver from "unplugin-icons/resolver";
import { ElementPlusResolver } from "unplugin-vue-components/resolvers";
import UnoCSS from "unocss/vite";
import path from "path";

interface VitestConfigExport extends UserConfig {}

const clientPath = "src/projects/client";
const adminPath = "src/projects/admin";

export default defineConfig(({ command, mode }) => {
  const env = loadEnv(mode, process.cwd(), "");

  return {
    client: {
      entry: path.resolve(__dirname, "src/projects/client/main.ts"),
      outDir: path.resolve(__dirname, "dist/client"),
      html: {
        filename: "index.html",
        title: "client"
      }
    },
    admin: {
      entry: path.resolve(__dirname, "src/projects/admin/main.ts"),
      outDir: path.resolve(__dirname, "dist/admin"),
      html: {
        filename: "index.html",
        title: "admin"
      }
    },
    build: {
      target: "modules",
      outDir: "dist/" + env.VITE_APP_NAME + "/",
      assetsDir: "static",
      sourcemap: true,
      rollupOptions: {
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
            "@root/apis/use-axios": ["axiosInstance"]
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
          clientPath + "/views/**",
          clientPath + "/components/**",
          clientPath + "/fragments/**",
          adminPath + "/views/**",
          adminPath + "/components/**",
          adminPath + "/fragments/**"
        ]
      }),
      Icons({
        autoInstall: true
      })
    ],
    resolve: {
      alias: {
        "@root": path.resolve(__dirname, "src"),
        "@admin": path.resolve(__dirname, adminPath),
        "@client": path.resolve(__dirname, clientPath)
      }
    }
  } as VitestConfigExport;
});
