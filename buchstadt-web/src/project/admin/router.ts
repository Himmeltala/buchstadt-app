import { createRouter, createWebHashHistory } from "vue-router";

const router = createRouter({
  routes: [
    {
      path: "/",
      meta: { title: "首页" },
      name: "auth-Index",
      redirect: "/buchs/base",
      component: () => import("@admin/views/Index.vue"),
      children: [
        {
          path: "buchs",
          meta: { title: "书籍管理" },
          name: "auth-IndexBuch",
          redirect: "/buchs/base",
          component: () => import("@admin/views/buchs/IndexBuch.vue"),
          children: [
            {
              path: "base",
              meta: { title: "书籍基本管理" },
              name: "auth-BaseBuch",
              component: () => import("@admin/views/buchs/BaseBuch.vue")
            },
            {
              path: "add",
              meta: { title: "添加书籍" },
              name: "auth-AddBuch",
              component: () => import("@admin/views/buchs/AddBuch.vue")
            },
            {
              path: "update/:id",
              meta: { title: "更新书籍" },
              name: "auth-UpdateBuch",
              component: () => import("@admin/views/buchs/UpdateBuch.vue")
            },
            {
              path: "attach/add/:id",
              meta: { title: "增加书籍附表数据" },
              name: "auth-AddBuchAttach",
              component: () => import("@admin/views/buchs/attach/AddBuchAttach.vue")
            },
            {
              path: "attach/delete/:id",
              meta: { title: "删除书籍附表数据" },
              name: "auth-DeleteBuchAttach",
              component: () => import("@admin/views/buchs/attach/DeleteBuchAttach.vue")
            },
            {
              path: "manage/comment",
              meta: { title: "书籍评论管理" },
              name: "auth-ManageComment",
              component: () => import("@admin/views/buchs/ManageComment.vue")
            }
          ]
        },
        {
          path: "users",
          meta: { title: "用户管理" },
          name: "auth-IndexUser",
          redirect: "/users/base",
          component: () => import("@admin/views/users/indexUser.vue"),
          children: [
            {
              path: "base",
              meta: { title: "用户基本管理" },
              name: "auth-BaseUser",
              component: () => import("@admin/views/users/baseUser.vue")
            },
            {
              path: "add",
              meta: { title: "添加用户" },
              name: "auth-AddUser",
              component: () => import("@admin/views/users/addUser.vue")
            }
          ]
        },
        {
          path: "orders",
          meta: { title: "订单管理" },
          name: "auth-IndexOrder",
          redirect: "/orders/base",
          component: () => import("@admin/views/orders/indexOrder.vue"),
          children: [
            {
              path: "base",
              meta: { title: "订单基本管理" },
              name: "auth-BaseOrder",
              component: () => import("@admin/views/orders/baseOrder.vue")
            }
          ]
        },
        {
          path: "admins",
          meta: { title: "管理员管理" },
          name: "auth-IndexAdmin",
          redirect: "/admins/base",
          component: () => import("@admin/views/admins/indexAdmin.vue"),
          children: [
            {
              path: "base",
              meta: { title: "管理员基本管理" },
              name: "auth-BaseAdmin",
              component: () => import("@admin/views/admins/baseAdmin.vue")
            },
            {
              path: "add",
              meta: { title: "添加管理员" },
              name: "auth-AddAdmin",
              component: () => import("@admin/views/admins/addAdmin.vue")
            }
          ]
        },
        {
          path: "publishers",
          meta: { title: "出版社管理" },
          name: "auth-IndexPublisher",
          redirect: "/publishers/base",
          component: () => import("@admin/views/publishers/indexPublisher.vue"),
          children: [
            {
              path: "base",
              meta: { title: "出版社基本管理" },
              name: "auth-BasePublisher",
              component: () => import("@admin/views/publishers/basePublisher.vue")
            },
            {
              path: "add",
              meta: { title: "添加出版社" },
              name: "auth-AddPublisher",
              component: () => import("@admin/views/publishers/addPublisher.vue")
            },
            {
              path: "detail/:id",
              meta: { title: "出版社详细" },
              name: "auth-DetailPublisher",
              component: () => import("@admin/views/publishers/detailPublisher.vue")
            }
          ]
        }
      ]
    },
    {
      path: "/signin",
      name: "entry-SignIn",
      meta: { title: "登录" },
      component: () => import("@admin/views/SignIn.vue")
    },
    {
      path: "/signup",
      name: "entry-SignUp",
      meta: { title: "注册" },
      component: () => import("@admin/views/SignUp.vue")
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

function isAuthed() {
  return !!localStorage.getUser();
}

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
