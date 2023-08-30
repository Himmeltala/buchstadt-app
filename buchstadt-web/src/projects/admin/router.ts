import { createRouter, createWebHashHistory } from "vue-router";

const router = createRouter({
  routes: [
    {
      path: "/",
      meta: { title: "首页" },
      name: "index",
      redirect: "/buchs/base",
      component: () => import("@/views/index.vue"),
      children: [
        {
          path: "buchs",
          meta: { title: "书籍管理" },
          name: "indexBuch",
          redirect: "/buchs/base",
          component: () => import("@/views/buchs/indexBuch.vue"),
          children: [
            {
              path: "base",
              meta: { title: "书籍基本管理" },
              name: "baseBuch",
              component: () => import("@/views/buchs/baseBuch.vue")
            },
            {
              path: "add",
              meta: { title: "添加书籍" },
              name: "addBuch",
              component: () => import("@/views/buchs/addBuch.vue")
            },
            {
              path: "update/:id",
              meta: { title: "更新书籍" },
              name: "updateBuch",
              component: () => import("@/views/buchs/updateBuch.vue")
            },
            {
              path: "attach/add/:id",
              meta: { title: "增加书籍附表数据" },
              name: "addBuchAttach",
              component: () => import("@/views/buchs/attach/addBuchAttach.vue")
            },
            {
              path: "attach/delete/:id",
              meta: { title: "删除书籍附表数据" },
              name: "deleteBuchAttach",
              component: () => import("@/views/buchs/attach/deleteBuchAttach.vue")
            },
            {
              path: "comm/base",
              meta: { title: "查询书籍评论" },
              name: "baseCommList",
              component: () => import("@/views/buchs/comments/baseCommList.vue")
            }
          ]
        },
        {
          path: "users",
          meta: { title: "用户管理" },
          name: "indexUser",
          redirect: "/users/base",
          component: () => import("@/views/users/indexUser.vue"),
          children: [
            {
              path: "base",
              meta: { title: "用户基本管理" },
              name: "baseUser",
              component: () => import("@/views/users/baseUser.vue")
            },
            {
              path: "add",
              meta: { title: "添加用户" },
              name: "addUser",
              component: () => import("@/views/users/addUser.vue")
            }
          ]
        },
        {
          path: "orders",
          meta: { title: "订单管理" },
          name: "indexOrder",
          redirect: "/orders/base",
          component: () => import("@/views/orders/indexOrder.vue"),
          children: [
            {
              path: "base",
              meta: { title: "订单基本管理" },
              name: "baseOrder",
              component: () => import("@/views/orders/baseOrder.vue")
            }
          ]
        },
        {
          path: "admins",
          meta: { title: "管理员管理" },
          name: "indexAdmin",
          redirect: "/admins/base",
          component: () => import("@/views/admins/indexAdmin.vue"),
          children: [
            {
              path: "base",
              meta: { title: "管理员基本管理" },
              name: "baseAdmin",
              component: () => import("@/views/admins/baseAdmin.vue")
            },
            {
              path: "add",
              meta: { title: "添加管理员" },
              name: "addAdmin",
              component: () => import("@/views/admins/addAdmin.vue")
            }
          ]
        },
        {
          path: "publishers",
          meta: { title: "出版社管理" },
          name: "indexPublisher",
          redirect: "/publishers/base",
          component: () => import("@/views/publishers/indexPublisher.vue"),
          children: [
            {
              path: "base",
              meta: { title: "出版社基本管理" },
              name: "basePublisher",
              component: () => import("@/views/publishers/basePublisher.vue")
            },
            {
              path: "add",
              meta: { title: "添加出版社" },
              name: "addPublisher",
              component: () => import("@/views/publishers/addPublisher.vue")
            },
            {
              path: "detail/:id",
              meta: { title: "出版社详细" },
              name: "detailPublisher",
              component: () => import("@/views/publishers/detailPublisher.vue")
            }
          ]
        }
      ]
    },
    {
      path: "/signin",
      name: "signin",
      component: () => import("@/views/signin.vue")
    },
    {
      path: "/signup",
      name: "signup",
      component: () => import("@/views/signup.vue")
    }
  ],
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
  const isAuthenticated = !!localStorage.getItem("userId");
  if (!isAuthenticated && to.name !== "signin") {
    return next({ name: "signin" });
  } else {
    return next();
  }
});

router.afterEach(to => {
  if (to.meta.title) {
    document.title = "Buchstadt - " + to.meta.title;
  }
});

export default router;
