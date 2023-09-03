import { createRouter, createWebHashHistory } from "vue-router";
import { isAuthed } from "@root/util/validation";

const routes = [
  {
    path: "/",
    name: "pub-Index",
    meta: {
      title: "首页"
    },
    component: () => import("@client/views/ClientIndex.vue")
  },
  {
    path: "/signin",
    name: "entry-Signin",
    meta: {
      title: "登录"
    },
    component: () => import("@client/views/ClientSignIn.vue")
  },
  {
    path: "/signup",
    name: "pub-Signup",
    meta: {
      title: "注册"
    },
    component: () => import("@client/views/ClientSignUp.vue")
  },
  {
    path: "/detail/:id",
    name: "auth-Detail",
    meta: {
      title: "书籍详细"
    },
    component: () => import("@client/views/Detail.vue")
  },
  {
    path: "/trolley",
    name: "auth-Trolley",
    meta: {
      title: "购物车"
    },
    component: () => import("@client/views/Carts.vue")
  },
  {
    path: "/orders",
    name: "auth-Indents",
    meta: {
      title: "订单"
    },
    component: () => import("@client/views/Orders.vue")
  },
  {
    path: "/category/:type",
    name: "pub-Category",
    meta: {
      title: "分类"
    },
    component: () => import("@client/views/Category.vue")
  },
  {
    path: "/success/pay",
    name: "auth-PaySuccess",
    meta: {
      title: "支付成功"
    },
    component: () => import("@client/fragments/PaySuccess.vue")
  },
  {
    path: "/collection",
    name: "auth-Collection",
    meta: {
      title: "书籍收藏"
    },
    component: () => import("@client/views/Collection.vue")
  },
  {
    path: "/publisher/:pressId",
    name: "pub-Press",
    meta: {
      title: "出版社"
    },
    component: () => import("@client/views/Publishers.vue")
  },
  {
    path: "/search/:name",
    name: "pub-Search",
    meta: {
      title: "搜索书籍"
    },
    component: () => import("@client/views/Search.vue")
  },
  {
    path: "/space/:id",
    name: "auth-Space",
    meta: {
      title: "个人空间"
    },
    component: () => import("@client/views/Space.vue")
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

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = "Buchstadt - " + to.meta.title;
  }

  if (to.name.toString().startsWith("auth-") && !isAuthed()) {
    ElMessage.warning("请先登录！");
    next("/signin");
  } else if (to.name.toString().startsWith("entry-") && isAuthed()) {
    next("/");
  } else if (to.name.toString().startsWith("pub-")) {
    next();
  } else {
    next();
  }
});

export default router;
