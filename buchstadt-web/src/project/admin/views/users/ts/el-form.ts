import type { FormRules } from "element-plus";

export const sexOps = reactive([
  {
    value: "男",
    label: "男"
  },
  {
    value: "女",
    label: "女"
  },
  {
    value: "未知",
    label: "未知"
  }
]);

export const formRules = reactive<FormRules>({
  username: [
    { required: true, message: "请输入用户名称", trigger: "change" },
    { min: 2, max: 50, message: "长度在 2 ~ 50", trigger: "change" }
  ],
  profilePhoto: [{ required: true, message: "请输入头像 URL", trigger: "blur" }],
  password: [{ required: true, message: "请输入密码", trigger: "blur" }]
});
