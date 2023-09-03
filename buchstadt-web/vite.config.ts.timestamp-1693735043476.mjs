// vite.config.ts
import { defineConfig, loadEnv } from "file:///E:/DevProjs/buchstadt-app/buchstadt-web/node_modules/.pnpm/vite@4.2.1_@types+node@20.5.7_sass@1.62.1/node_modules/vite/dist/node/index.js";
import vue from "file:///E:/DevProjs/buchstadt-app/buchstadt-web/node_modules/.pnpm/@vitejs+plugin-vue@4.1.0_vite@4.2.1_vue@3.2.47/node_modules/@vitejs/plugin-vue/dist/index.mjs";
import AutoImport from "file:///E:/DevProjs/buchstadt-app/buchstadt-web/node_modules/.pnpm/unplugin-auto-import@0.16.4_@vueuse+core@10.1.2/node_modules/unplugin-auto-import/dist/vite.js";
import Components from "file:///E:/DevProjs/buchstadt-app/buchstadt-web/node_modules/.pnpm/unplugin-vue-components@0.25.0_vue@3.2.47/node_modules/unplugin-vue-components/dist/vite.mjs";
import Icons from "file:///E:/DevProjs/buchstadt-app/buchstadt-web/node_modules/.pnpm/unplugin-icons@0.16.1/node_modules/unplugin-icons/dist/vite.mjs";
import IconsResolver from "file:///E:/DevProjs/buchstadt-app/buchstadt-web/node_modules/.pnpm/unplugin-icons@0.16.1/node_modules/unplugin-icons/dist/resolver.mjs";
import { ElementPlusResolver } from "file:///E:/DevProjs/buchstadt-app/buchstadt-web/node_modules/.pnpm/unplugin-vue-components@0.25.0_vue@3.2.47/node_modules/unplugin-vue-components/dist/resolvers.mjs";
import UnoCSS from "file:///E:/DevProjs/buchstadt-app/buchstadt-web/node_modules/.pnpm/unocss@0.52.7_postcss@8.4.29_vite@4.2.1/node_modules/unocss/dist/vite.mjs";
import { resolve } from "path";
var __vite_injected_original_dirname = "E:\\DevProjs\\buchstadt-app\\buchstadt-web";
var clientPath = "src/project/client";
var adminPath = "src/project/admin";
var vite_config_default = defineConfig(({ command, mode }) => {
  const env = loadEnv(mode, process.cwd(), "");
  return {
    build: {
      target: "modules",
      outDir: "dist/" + env.VITE_APP_NAME + "/",
      assetsDir: "static",
      sourcemap: true,
      rollupOptions: {
        input: {
          main: resolve(__vite_injected_original_dirname, "index.html"),
          projectClient: resolve(__vite_injected_original_dirname, "project/client/index.html"),
          projectAdmin: resolve(__vite_injected_original_dirname, "project/admin/index.html")
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
          /\.[tj]sx?$/,
          // .ts, .tsx, .js, .jsx
          /\.vue$/,
          /\.vue\?vue/
          // .vue
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
        "@root": resolve(__vite_injected_original_dirname, "src"),
        "@admin": resolve(__vite_injected_original_dirname, adminPath),
        "@client": resolve(__vite_injected_original_dirname, clientPath)
      }
    }
  };
});
export {
  vite_config_default as default
};
//# sourceMappingURL=data:application/json;base64,ewogICJ2ZXJzaW9uIjogMywKICAic291cmNlcyI6IFsidml0ZS5jb25maWcudHMiXSwKICAic291cmNlc0NvbnRlbnQiOiBbImNvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9kaXJuYW1lID0gXCJFOlxcXFxEZXZQcm9qc1xcXFxidWNoc3RhZHQtYXBwXFxcXGJ1Y2hzdGFkdC13ZWJcIjtjb25zdCBfX3ZpdGVfaW5qZWN0ZWRfb3JpZ2luYWxfZmlsZW5hbWUgPSBcIkU6XFxcXERldlByb2pzXFxcXGJ1Y2hzdGFkdC1hcHBcXFxcYnVjaHN0YWR0LXdlYlxcXFx2aXRlLmNvbmZpZy50c1wiO2NvbnN0IF9fdml0ZV9pbmplY3RlZF9vcmlnaW5hbF9pbXBvcnRfbWV0YV91cmwgPSBcImZpbGU6Ly8vRTovRGV2UHJvanMvYnVjaHN0YWR0LWFwcC9idWNoc3RhZHQtd2ViL3ZpdGUuY29uZmlnLnRzXCI7aW1wb3J0IHsgZGVmaW5lQ29uZmlnLCBVc2VyQ29uZmlnLCBsb2FkRW52IH0gZnJvbSBcInZpdGVcIjtcclxuaW1wb3J0IHZ1ZSBmcm9tIFwiQHZpdGVqcy9wbHVnaW4tdnVlXCI7XHJcbmltcG9ydCBBdXRvSW1wb3J0IGZyb20gXCJ1bnBsdWdpbi1hdXRvLWltcG9ydC92aXRlXCI7XHJcbmltcG9ydCBDb21wb25lbnRzIGZyb20gXCJ1bnBsdWdpbi12dWUtY29tcG9uZW50cy92aXRlXCI7XHJcbmltcG9ydCBJY29ucyBmcm9tIFwidW5wbHVnaW4taWNvbnMvdml0ZVwiO1xyXG5pbXBvcnQgSWNvbnNSZXNvbHZlciBmcm9tIFwidW5wbHVnaW4taWNvbnMvcmVzb2x2ZXJcIjtcclxuaW1wb3J0IHsgRWxlbWVudFBsdXNSZXNvbHZlciB9IGZyb20gXCJ1bnBsdWdpbi12dWUtY29tcG9uZW50cy9yZXNvbHZlcnNcIjtcclxuaW1wb3J0IFVub0NTUyBmcm9tIFwidW5vY3NzL3ZpdGVcIjtcclxuaW1wb3J0IHsgcmVzb2x2ZSB9IGZyb20gXCJwYXRoXCI7XHJcblxyXG5pbnRlcmZhY2UgVml0ZXN0Q29uZmlnRXhwb3J0IGV4dGVuZHMgVXNlckNvbmZpZyB7fVxyXG5cclxuY29uc3QgY2xpZW50UGF0aCA9IFwic3JjL3Byb2plY3QvY2xpZW50XCI7XHJcbmNvbnN0IGFkbWluUGF0aCA9IFwic3JjL3Byb2plY3QvYWRtaW5cIjtcclxuXHJcbmV4cG9ydCBkZWZhdWx0IGRlZmluZUNvbmZpZygoeyBjb21tYW5kLCBtb2RlIH0pID0+IHtcclxuICBjb25zdCBlbnYgPSBsb2FkRW52KG1vZGUsIHByb2Nlc3MuY3dkKCksIFwiXCIpO1xyXG5cclxuICByZXR1cm4ge1xyXG4gICAgYnVpbGQ6IHtcclxuICAgICAgdGFyZ2V0OiBcIm1vZHVsZXNcIixcclxuICAgICAgb3V0RGlyOiBcImRpc3QvXCIgKyBlbnYuVklURV9BUFBfTkFNRSArIFwiL1wiLFxyXG4gICAgICBhc3NldHNEaXI6IFwic3RhdGljXCIsXHJcbiAgICAgIHNvdXJjZW1hcDogdHJ1ZSxcclxuICAgICAgcm9sbHVwT3B0aW9uczoge1xyXG4gICAgICAgIGlucHV0OiB7XHJcbiAgICAgICAgICBtYWluOiByZXNvbHZlKF9fZGlybmFtZSwgXCJpbmRleC5odG1sXCIpLFxyXG4gICAgICAgICAgcHJvamVjdENsaWVudDogcmVzb2x2ZShfX2Rpcm5hbWUsIFwicHJvamVjdC9jbGllbnQvaW5kZXguaHRtbFwiKSxcclxuICAgICAgICAgIHByb2plY3RBZG1pbjogcmVzb2x2ZShfX2Rpcm5hbWUsIFwicHJvamVjdC9hZG1pbi9pbmRleC5odG1sXCIpXHJcbiAgICAgICAgfSxcclxuICAgICAgICBvdXRwdXQ6IHtcclxuICAgICAgICAgIGVudHJ5RmlsZU5hbWVzOiBcInN0YXRpYy9qcy9bbmFtZV0tW2hhc2hdLmpzXCIsXHJcbiAgICAgICAgICBjaHVua0ZpbGVOYW1lczogXCJzdGF0aWMvanMvW25hbWVdLVtoYXNoXS5qc1wiLFxyXG4gICAgICAgICAgYXNzZXRGaWxlTmFtZXM6IFwic3RhdGljL1tleHRdL25hbWUtW2hhc2hdLltleHRdXCJcclxuICAgICAgICB9XHJcbiAgICAgIH1cclxuICAgIH0sXHJcbiAgICBwbHVnaW5zOiBbXHJcbiAgICAgIHZ1ZSgpLFxyXG4gICAgICBVbm9DU1MoKSxcclxuICAgICAgQXV0b0ltcG9ydCh7XHJcbiAgICAgICAgaW5jbHVkZTogW1xyXG4gICAgICAgICAgL1xcLlt0al1zeD8kLywgLy8gLnRzLCAudHN4LCAuanMsIC5qc3hcclxuICAgICAgICAgIC9cXC52dWUkLyxcclxuICAgICAgICAgIC9cXC52dWVcXD92dWUvIC8vIC52dWVcclxuICAgICAgICBdLFxyXG4gICAgICAgIGltcG9ydHM6IFtcclxuICAgICAgICAgIFwidnVlXCIsXHJcbiAgICAgICAgICBcInBpbmlhXCIsXHJcbiAgICAgICAgICBcInZ1ZS1yb3V0ZXJcIixcclxuICAgICAgICAgIFwiQHZ1ZXVzZS9jb3JlXCIsXHJcbiAgICAgICAgICB7XHJcbiAgICAgICAgICAgIFwiQHJvb3QvYXBpL3VzZS1heGlvc1wiOiBbXCJheGlvc0luc3RhbmNlXCJdXHJcbiAgICAgICAgICB9XHJcbiAgICAgICAgXSxcclxuICAgICAgICByZXNvbHZlcnM6IFtcclxuICAgICAgICAgIEVsZW1lbnRQbHVzUmVzb2x2ZXIoKSxcclxuICAgICAgICAgIEljb25zUmVzb2x2ZXIoe1xyXG4gICAgICAgICAgICBwcmVmaXg6IFwiSWNvblwiXHJcbiAgICAgICAgICB9KVxyXG4gICAgICAgIF0sXHJcbiAgICAgICAgdnVlVGVtcGxhdGU6IHRydWUsXHJcbiAgICAgICAgZHRzOiBcIi4vYXV0by1pbXBvcnRzLmQudHNcIlxyXG4gICAgICB9KSxcclxuICAgICAgQ29tcG9uZW50cyh7XHJcbiAgICAgICAgcmVzb2x2ZXJzOiBbXHJcbiAgICAgICAgICBFbGVtZW50UGx1c1Jlc29sdmVyKCksXHJcbiAgICAgICAgICBJY29uc1Jlc29sdmVyKHtcclxuICAgICAgICAgICAgZW5hYmxlZENvbGxlY3Rpb25zOiBbXCJlcFwiXVxyXG4gICAgICAgICAgfSlcclxuICAgICAgICBdLFxyXG4gICAgICAgIGRpcnM6IFtcclxuICAgICAgICAgIFwic3JjL2NvbXBvbmVudHMvKipcIixcclxuICAgICAgICAgIGAke2NsaWVudFBhdGh9L3ZpZXdzLyoqYCxcclxuICAgICAgICAgIGAke2NsaWVudFBhdGh9L2NvbXBvbmVudHMvKipgLFxyXG4gICAgICAgICAgYCR7Y2xpZW50UGF0aH0vZnJhZ21lbnRzLyoqYCxcclxuICAgICAgICAgIGAke2FkbWluUGF0aH0vdmlld3MvKipgLFxyXG4gICAgICAgICAgYCR7YWRtaW5QYXRofS9jb21wb25lbnRzLyoqYCxcclxuICAgICAgICAgIGAke2FkbWluUGF0aH0vZnJhZ21lbnRzLyoqYFxyXG4gICAgICAgIF1cclxuICAgICAgfSksXHJcbiAgICAgIEljb25zKHtcclxuICAgICAgICBhdXRvSW5zdGFsbDogdHJ1ZVxyXG4gICAgICB9KVxyXG4gICAgXSxcclxuICAgIHJlc29sdmU6IHtcclxuICAgICAgYWxpYXM6IHtcclxuICAgICAgICBcIkByb290XCI6IHJlc29sdmUoX19kaXJuYW1lLCBcInNyY1wiKSxcclxuICAgICAgICBcIkBhZG1pblwiOiByZXNvbHZlKF9fZGlybmFtZSwgYWRtaW5QYXRoKSxcclxuICAgICAgICBcIkBjbGllbnRcIjogcmVzb2x2ZShfX2Rpcm5hbWUsIGNsaWVudFBhdGgpXHJcbiAgICAgIH1cclxuICAgIH1cclxuICB9IGFzIFZpdGVzdENvbmZpZ0V4cG9ydDtcclxufSk7XHJcbiJdLAogICJtYXBwaW5ncyI6ICI7QUFBK1MsU0FBUyxjQUEwQixlQUFlO0FBQ2pXLE9BQU8sU0FBUztBQUNoQixPQUFPLGdCQUFnQjtBQUN2QixPQUFPLGdCQUFnQjtBQUN2QixPQUFPLFdBQVc7QUFDbEIsT0FBTyxtQkFBbUI7QUFDMUIsU0FBUywyQkFBMkI7QUFDcEMsT0FBTyxZQUFZO0FBQ25CLFNBQVMsZUFBZTtBQVJ4QixJQUFNLG1DQUFtQztBQVl6QyxJQUFNLGFBQWE7QUFDbkIsSUFBTSxZQUFZO0FBRWxCLElBQU8sc0JBQVEsYUFBYSxDQUFDLEVBQUUsU0FBUyxLQUFLLE1BQU07QUFDakQsUUFBTSxNQUFNLFFBQVEsTUFBTSxRQUFRLElBQUksR0FBRyxFQUFFO0FBRTNDLFNBQU87QUFBQSxJQUNMLE9BQU87QUFBQSxNQUNMLFFBQVE7QUFBQSxNQUNSLFFBQVEsVUFBVSxJQUFJLGdCQUFnQjtBQUFBLE1BQ3RDLFdBQVc7QUFBQSxNQUNYLFdBQVc7QUFBQSxNQUNYLGVBQWU7QUFBQSxRQUNiLE9BQU87QUFBQSxVQUNMLE1BQU0sUUFBUSxrQ0FBVyxZQUFZO0FBQUEsVUFDckMsZUFBZSxRQUFRLGtDQUFXLDJCQUEyQjtBQUFBLFVBQzdELGNBQWMsUUFBUSxrQ0FBVywwQkFBMEI7QUFBQSxRQUM3RDtBQUFBLFFBQ0EsUUFBUTtBQUFBLFVBQ04sZ0JBQWdCO0FBQUEsVUFDaEIsZ0JBQWdCO0FBQUEsVUFDaEIsZ0JBQWdCO0FBQUEsUUFDbEI7QUFBQSxNQUNGO0FBQUEsSUFDRjtBQUFBLElBQ0EsU0FBUztBQUFBLE1BQ1AsSUFBSTtBQUFBLE1BQ0osT0FBTztBQUFBLE1BQ1AsV0FBVztBQUFBLFFBQ1QsU0FBUztBQUFBLFVBQ1A7QUFBQTtBQUFBLFVBQ0E7QUFBQSxVQUNBO0FBQUE7QUFBQSxRQUNGO0FBQUEsUUFDQSxTQUFTO0FBQUEsVUFDUDtBQUFBLFVBQ0E7QUFBQSxVQUNBO0FBQUEsVUFDQTtBQUFBLFVBQ0E7QUFBQSxZQUNFLHVCQUF1QixDQUFDLGVBQWU7QUFBQSxVQUN6QztBQUFBLFFBQ0Y7QUFBQSxRQUNBLFdBQVc7QUFBQSxVQUNULG9CQUFvQjtBQUFBLFVBQ3BCLGNBQWM7QUFBQSxZQUNaLFFBQVE7QUFBQSxVQUNWLENBQUM7QUFBQSxRQUNIO0FBQUEsUUFDQSxhQUFhO0FBQUEsUUFDYixLQUFLO0FBQUEsTUFDUCxDQUFDO0FBQUEsTUFDRCxXQUFXO0FBQUEsUUFDVCxXQUFXO0FBQUEsVUFDVCxvQkFBb0I7QUFBQSxVQUNwQixjQUFjO0FBQUEsWUFDWixvQkFBb0IsQ0FBQyxJQUFJO0FBQUEsVUFDM0IsQ0FBQztBQUFBLFFBQ0g7QUFBQSxRQUNBLE1BQU07QUFBQSxVQUNKO0FBQUEsVUFDQSxHQUFHO0FBQUEsVUFDSCxHQUFHO0FBQUEsVUFDSCxHQUFHO0FBQUEsVUFDSCxHQUFHO0FBQUEsVUFDSCxHQUFHO0FBQUEsVUFDSCxHQUFHO0FBQUEsUUFDTDtBQUFBLE1BQ0YsQ0FBQztBQUFBLE1BQ0QsTUFBTTtBQUFBLFFBQ0osYUFBYTtBQUFBLE1BQ2YsQ0FBQztBQUFBLElBQ0g7QUFBQSxJQUNBLFNBQVM7QUFBQSxNQUNQLE9BQU87QUFBQSxRQUNMLFNBQVMsUUFBUSxrQ0FBVyxLQUFLO0FBQUEsUUFDakMsVUFBVSxRQUFRLGtDQUFXLFNBQVM7QUFBQSxRQUN0QyxXQUFXLFFBQVEsa0NBQVcsVUFBVTtBQUFBLE1BQzFDO0FBQUEsSUFDRjtBQUFBLEVBQ0Y7QUFDRixDQUFDOyIsCiAgIm5hbWVzIjogW10KfQo=
