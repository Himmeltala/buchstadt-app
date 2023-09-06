import { createRouter, createWebHashHistory } from "vue-router";
import { isAuthed } from "@subapp-admin/utils/validation";

const router = createRouter({
  routes: [
    {
      path: "/",
      meta: { title: "首页" },
      name: "auth-Index",
      redirect: "/buchs/base",
      component: () => import("@subapp-admin/views/AdminIndex.vue"),
      children: [
        {
          path: "buchs",
          meta: { title: "书籍管理" },
          name: "auth-IndexBuch",
          redirect: "/buchs/base",
          component: () => import("@subapp-admin/views/buchs/IndexBuch.vue"),
          children: [
            {
              path: "base",
              meta: { title: "书籍基本管理" },
              name: "auth-BaseBuch",
              component: () => import("@subapp-admin/views/buchs/BaseBuch.vue")
            },
            {
              path: "add",
              meta: { title: "添加书籍" },
              name: "auth-AddBuch",
              component: () => import("@subapp-admin/views/buchs/AddBuch.vue")
            },
            {
              path: "update/:id",
              meta: { title: "更新书籍" },
              name: "auth-UpdateBuch",
              component: () => import("@subapp-admin/views/buchs/UpdateBuch.vue")
            },
            {
              path: "attach/add/:id",
              meta: { title: "增加书籍附表数据" },
              name: "auth-AddBuchAttach",
              component: () => import("@subapp-admin/views/buchs/attach/AddBuchAttach.vue")
            },
            {
              path: "attach/delete/:id",
              meta: { title: "删除书籍附表数据" },
              name: "auth-DeleteBuchAttach",
              component: () => import("@subapp-admin/views/buchs/attach/DeleteBuchAttach.vue")
            },
            {
              path: "manage/comment",
              meta: { title: "书籍评论管理" },
              name: "auth-ManageComment",
              component: () => import("@subapp-admin/views/buchs/ManageComment.vue")
            }
          ]
        },
        {
          path: "users",
          meta: { title: "用户管理" },
          name: "auth-IndexUser",
          redirect: "/users/base",
          component: () => import("@subapp-admin/views/users/IndexUser.vue"),
          children: [
            {
              path: "base",
              meta: { title: "用户基本管理" },
              name: "auth-BaseUser",
              component: () => import("@subapp-admin/views/users/BaseUser.vue")
            },
            {
              path: "add",
              meta: { title: "添加用户" },
              name: "auth-AddUser",
              component: () => import("@subapp-admin/views/users/AddUser.vue")
            },
            {
              path: "address",
              meta: { title: "收货地址管理" },
              name: "auth-AddressManager",
              component: () => import("@subapp-admin/views/users/AddressAdminManager.vue")
            },
            {
              path: "detail/:id",
              meta: { title: "用户详细管理" },
              name: "auth-ManageUserDetail",
              component: () => import("@subapp-admin/views/users/ManageUserDetail.vue")
            }
          ]
        },
        {
          path: "orders",
          meta: { title: "订单管理" },
          name: "auth-IndexOrder",
          redirect: "/orders/base",
          component: () => import("@subapp-admin/views/orders/IndexOrder.vue"),
          children: [
            {
              path: "base",
              meta: { title: "订单基本管理" },
              name: "auth-BaseOrder",
              component: () => import("@subapp-admin/views/orders/BaseOrder.vue")
            }
          ]
        },
        {
          path: "admins",
          meta: { title: "管理员管理" },
          name: "auth-IndexAdmin",
          redirect: "/admins/base",
          component: () => import("@subapp-admin/views/admins/IndexAdmin.vue"),
          children: [
            {
              path: "base",
              meta: { title: "管理员基本管理" },
              name: "auth-BaseAdmin",
              component: () => import("@subapp-admin/views/admins/BaseAdmin.vue")
            },
            {
              path: "add",
              meta: { title: "添加管理员" },
              name: "auth-AddAdmin",
              component: () => import("@subapp-admin/views/admins/AddAdmin.vue")
            }
          ]
        },
        {
          path: "pub",
          meta: { title: "出版社管理" },
          name: "auth-IndexPub",
          redirect: "/pub/base",
          component: () => import("@subapp-admin/views/pub/IndexPub.vue"),
          children: [
            {
              path: "base",
              meta: { title: "出版社基本管理" },
              name: "auth-BasePub",
              component: () => import("@subapp-admin/views/pub/BasePub.vue")
            },
            {
              path: "add",
              meta: { title: "添加出版社" },
              name: "auth-AddPub",
              component: () => import("@subapp-admin/views/pub/AddPub.vue")
            },
            {
              path: "detail/:id",
              meta: { title: "出版社详细" },
              name: "auth-DetailPub",
              component: () => import("@subapp-admin/views/pub/DetailPub.vue")
            }
          ]
        }
      ]
    },
    {
      path: "/signin",
      name: "entry-SignIn",
      meta: { title: "登录" },
      component: () => import("@subapp-admin/views/AdminSignIn.vue")
    },
    {
      path: "/signup",
      name: "entry-SignUp",
      meta: { title: "注册" },
      component: () => import("@subapp-admin/views/AdminSignUp.vue")
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
  if (to.meta.title) {
    document.title = "Buchstadt - 管理端 - " + to.meta.title;
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
