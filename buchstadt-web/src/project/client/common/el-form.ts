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
    { required: true, message: "请输入您的密码！", trigger: "blur" },
    { validator: passwordValidator(), trigger: "change" },
    { validator: passwordValidator(), trigger: "blur" }
  ]
});

export const receiveFormData = reactive({
  receiveName: "",
  receivePhone: "",
  receiveLocation: ""
});

export const receiveFormRules = reactive({
  receiveName: [
    {
      required: true,
      message: "请输入收货人姓名",
      trigger: "blur"
    },
    {
      min: 2,
      max: 15,
      message: "长度在 2 到 15 个字符",
      trigger: "blur"
    }
  ],
  receivePhone: [
    {
      required: true,
      message: "请输入收货人手机号",
      trigger: "blur"
    },
    { validator: phoneValidator(), trigger: "change" },
    { validator: phoneValidator(), trigger: "blur" }
  ],
  receiveLocation: [
    {
      required: true,
      message: "请输入收货地址",
      trigger: "blur"
    },
    {
      min: 8,
      max: 30,
      message: "长度在 8 到 30 个字符",
      trigger: "blur"
    }
  ]
});
