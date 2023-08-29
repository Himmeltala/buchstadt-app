import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@/views/Index.vue"),
    name: "index"
  },
  {
    path: "/signin",
    meta: {
      title: "登录"
    },
    component: () => import("@/views/SignIn.vue"),
    name: "signin"
  },
  {
    path: "/signup",
    meta: {
      title: "注册"
    },
    component: () => import("@/views/SignUp.vue"),
    name: "signup"
  },
  {
    path: "/verbose/:id",
    meta: {
      title: "书籍详细"
    },
    component: () => import("@/views/Detail.vue"),
    name: "verbose"
  },
  {
    path: "/trolley",
    meta: {
      title: "购物车"
    },
    component: () => import("@/views/Carts.vue"),
    name: "trolley"
  },
  {
    path: "/indents",
    meta: {
      title: "订单"
    },
    component: () => import("@/views/Orders.vue"),
    name: "indents"
  },
  {
    path: "/category/:type",
    meta: {
      title: "分类"
    },
    component: () => import("@/views/Category.vue"),
    name: "category"
  },
  {
    path: "/success/pay",
    meta: {
      title: "支付成功"
    },
    component: () => import("@/segments/PaySuccess.vue"),
    name: "paySuccess"
  },
  {
    path: "/collection",
    meta: {
      title: "书籍收藏"
    },
    component: () => import("@/views/Collection.vue"),
    name: "collection"
  },
  {
    path: "/press/:pressId",
    meta: {
      title: "出版社"
    },
    component: () => import("@/views/Publishers.vue"),
    name: "press"
  },
  {
    path: "/search/:name",
    meta: {
      title: "搜索书籍"
    },
    component: () => import("@/views/Search.vue"),
    name: "search"
  },
  {
    path: "/space/:id",
    meta: {
      title: "个人空间"
    },
    component: () => import("@/views/Space.vue"),
    name: "space"
  }
];

const router = createRouter({
  routes,
  history: createWebHashHistory(),
  scrollBehavior(to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition;
    } else {
      return { top: 0 };
    }
  }
});

router.afterEach((to, from) => {
  if (to.meta.title) {
    document.title = "Buchstadt - " + to.meta.title;
  }
});

export default router;
