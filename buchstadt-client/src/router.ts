import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@/views/index.vue"),
    name: "index"
  },
  {
    path: "/signin",
    meta: {
      title: "登录"
    },
    component: () => import("@/views/signin.vue"),
    name: "signin"
  },
  {
    path: "/signup",
    meta: {
      title: "注册"
    },
    component: () => import("@/views/signup.vue"),
    name: "signup"
  },
  {
    path: "/verbose/:id",
    meta: {
      title: "书籍详细"
    },
    component: () => import("@/views/detail.vue"),
    name: "verbose"
  },
  {
    path: "/trolley",
    meta: {
      title: "购物车"
    },
    component: () => import("@/views/carts.vue"),
    name: "trolley"
  },
  {
    path: "/indents",
    meta: {
      title: "订单"
    },
    component: () => import("@/views/orders.vue"),
    name: "indents"
  },
  {
    path: "/category/:type",
    meta: {
      title: "分类"
    },
    component: () => import("@/views/category.vue"),
    name: "category"
  },
  {
    path: "/success/pay",
    meta: {
      title: "支付成功"
    },
    component: () => import("@/segments/pay-success.vue"),
    name: "paySuccess"
  },
  {
    path: "/collection",
    meta: {
      title: "书籍收藏"
    },
    component: () => import("@/views/collection.vue"),
    name: "collection"
  },
  {
    path: "/press/:pressId",
    meta: {
      title: "出版社"
    },
    component: () => import("@/views/publishers.vue"),
    name: "press"
  },
  {
    path: "/search/:name",
    meta: {
      title: "搜索书籍"
    },
    component: () => import("@/views/search.vue"),
    name: "search"
  },
  {
    path: "/space/:id",
    meta: {
      title: "个人空间"
    },
    component: () => import("@/views/space.vue"),
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
