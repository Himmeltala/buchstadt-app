import type { FormRules } from "element-plus";

export const formRules = reactive<FormRules>({
  username: [{ required: true, message: "请输入用户名", trigger: "change" }],
  password: [{ required: true, message: "请输入密码", trigger: "blur" }],
  phone: [{ required: true, message: "请输入手机号", trigger: "blur" }],
  profilePhoto: [{ required: true, message: "请输入头像 URL", trigger: "blur" }],
  authority: [
    {
      required: true,
      message: "请选择一个权限",
      trigger: "change"
    }
  ]
});

export const authorityOps = [
  {
    value: "超级管理员",
    label: "超级管理员"
  },
  {
    value: "普通管理员",
    label: "普通管理员"
  }
];
