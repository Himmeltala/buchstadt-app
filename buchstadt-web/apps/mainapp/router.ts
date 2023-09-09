import { createRouter, createWebHashHistory } from "vue-router";
import { isAuthed } from "@common/utils/validation";

const routes = [
  {
    path: "/",
    name: "pub-Index",
    meta: {
      title: "首页"
    },
    component: () => import("@mainapp/views/ClientIndex.vue")
  },
  {
    path: "/signin",
    name: "entry-Signin",
    meta: {
      title: "登录"
    },
    component: () => import("@mainapp/views/ClientSignIn.vue")
  },
  {
    path: "/signup",
    name: "pub-Signup",
    meta: {
      title: "注册"
    },
    component: () => import("@mainapp/views/ClientSignUp.vue")
  },
  {
    path: "/detail/:id",
    name: "auth-Detail",
    meta: {
      title: "书籍详细"
    },
    component: () => import("@mainapp/views/Detail.vue")
  },
  {
    path: "/trolley",
    name: "auth-Trolley",
    meta: {
      title: "购物车"
    },
    component: () => import("@mainapp/views/Carts.vue")
  },
  {
    path: "/orders",
    name: "auth-Indents",
    meta: {
      title: "订单"
    },
    component: () => import("@mainapp/views/orders/Orders.vue")
  },
  {
    path: "/category/:type",
    name: "pub-Category",
    meta: {
      title: "分类"
    },
    component: () => import("@mainapp/views/Category.vue")
  },
  {
    path: "/success/pay",
    name: "auth-PaySuccess",
    meta: {
      title: "支付成功"
    },
    component: () => import("@mainapp/fragments/PaySuccess.vue")
  },
  {
    path: "/collection",
    name: "auth-Collection",
    meta: {
      title: "书籍收藏"
    },
    component: () => import("@mainapp/views/Collection.vue")
  },
  {
    path: "/pub/:id",
    name: "pub-Pub",
    meta: {
      title: "出版社"
    },
    component: () => import("@mainapp/views/Pub.vue")
  },
  {
    path: "/search/:name",
    name: "pub-Search",
    meta: {
      title: "搜索书籍"
    },
    component: () => import("@mainapp/views/Search.vue")
  },
  {
    path: "/space",
    name: "auth-Space",
    meta: {
      title: "个人空间"
    },
    component: () => import("@mainapp/views/space/Space.vue")
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

  if (to.name.toString().startsWith("auth-") && !isAuthed("main")) {
    ElMessage.warning("请先登录！");
    next("/signin");
  } else if (to.name.toString().startsWith("entry-") && isAuthed("main")) {
    next("/");
  } else if (to.name.toString().startsWith("pub-")) {
    next();
  } else {
    next();
  }
});

export default router;
