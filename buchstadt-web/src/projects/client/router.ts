import { createRouter, createWebHashHistory } from "vue-router";

const routes = [
  {
    path: "/",
    component: () => import("@client/views/Index.vue"),
    name: "index"
  },
  {
    path: "/signin",
    meta: {
      title: "登录"
    },
    component: () => import("@client/views/SignIn.vue"),
    name: "signin"
  },
  {
    path: "/signup",
    meta: {
      title: "注册"
    },
    component: () => import("@client/views/SignUp.vue"),
    name: "signup"
  },
  {
    path: "/verbose/:id",
    meta: {
      title: "书籍详细"
    },
    component: () => import("@client/views/Detail.vue"),
    name: "verbose"
  },
  {
    path: "/trolley",
    meta: {
      title: "购物车"
    },
    component: () => import("@client/views/Carts.vue"),
    name: "trolley"
  },
  {
    path: "/orders",
    meta: {
      title: "订单"
    },
    component: () => import("@client/views/Orders.vue"),
    name: "indents"
  },
  {
    path: "/category/:type",
    meta: {
      title: "分类"
    },
    component: () => import("@client/views/Category.vue"),
    name: "category"
  },
  {
    path: "/success/pay",
    meta: {
      title: "支付成功"
    },
    component: () => import("@client/fragments/PaySuccess.vue"),
    name: "paySuccess"
  },
  {
    path: "/collection",
    meta: {
      title: "书籍收藏"
    },
    component: () => import("@client/views/Collection.vue"),
    name: "collection"
  },
  {
    path: "/publisher/:pressId",
    meta: {
      title: "出版社"
    },
    component: () => import("@client/views/Publishers.vue"),
    name: "press"
  },
  {
    path: "/search/:name",
    meta: {
      title: "搜索书籍"
    },
    component: () => import("@client/views/Search.vue"),
    name: "search"
  },
  {
    path: "/space/:id",
    meta: {
      title: "个人空间"
    },
    component: () => import("@client/views/Space.vue"),
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
