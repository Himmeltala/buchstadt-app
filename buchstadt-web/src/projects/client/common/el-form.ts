import type { FormRules } from "element-plus";
import { usernameValidator, passwordValidator, rePasswdValidator, phoneValidator } from "@root/common/el-form-validation";

/**
 * 注册表单数据
 */
export const registerFormData = reactive({
  username: "",
  password: "",
  rePasswd: "",
  profile: "",
  phone: ""
});

/**
 * 注册表单规则
 */
export const registerFormRules = reactive<FormRules>({
  username: [
    { required: true, message: "请输入您的用户名！", trigger: "blur" },
    { validator: usernameValidator(), trigger: "change" },
    { validator: usernameValidator(), trigger: "blur" }
  ],
  password: [
    {
      required: true,
      message: "请输入您的密码！",
      trigger: "blur"
    },
    { validator: passwordValidator(), trigger: "change" },
    { validator: passwordValidator(), trigger: "blur" }
  ],
  rePasswd: [
    {
      required: true,
      message: "请输入您的密码！",
      trigger: "blur"
    },
    { validator: rePasswdValidator(registerFormData), trigger: "change" },
    { validator: rePasswdValidator(registerFormData), trigger: "blur" }
  ],
  profile: [
    {
      required: true,
      message: "请输入您的简介！",
      trigger: "blur"
    }
  ],
  phone: [
    {
      required: true,
      message: "请输入您的手机号！",
      trigger: "blur"
    },
    { validator: phoneValidator(), trigger: "change" },
    { validator: phoneValidator(), trigger: "blur" }
  ]
});

/**
 * 登录表单数据
 */
export const loginFormData = reactive({
  username: "",
  password: ""
});

/**
 * 登录表单规则
 */
export const loginFormRules = reactive<FormRules>({
  username: [
    { required: true, message: "请输入用户名", trigger: "blur" },
    { validator: usernameValidator(), trigger: "change" },
    { validator: usernameValidator(), trigger: "blur" }
  ],
  password: [
    {
      required: true,
      message: "请输入您的密码！",
      trigger: "blur"
    },
    {
      min: 6,
      max: 20,
      message: "长度在 6 到 20 之间",
      trigger: "blur"
    }
  ]
});
