import type { FormRules } from "element-plus";
import {
  usernameValidator,
  passwordValidator,
  rePasswdValidator,
  phoneValidator,
  emailValidator,
  httpValidator
} from "@common/elemplus/el-form-validation";

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

/**
 * 用户表单规则
 */
export const userFormRules = reactive<FormRules>({
  username: [
    { required: true, message: "请输入用户名", trigger: "blur" },
    { validator: usernameValidator(), trigger: "change" },
    { validator: usernameValidator(), trigger: "blur" }
  ],
  password: [
    { required: true, message: "请输入您的密码！", trigger: "blur" },
    { validator: passwordValidator(), trigger: "change" },
    { validator: passwordValidator(), trigger: "blur" }
  ],
  phone: [
    { required: true, message: "请输入您的手机号！", trigger: "blur" },
    { validator: phoneValidator(), trigger: "change" },
    { validator: phoneValidator(), trigger: "blur" }
  ],
  email: [
    { required: true, message: "请输入您的电子邮箱！", trigger: "blur" },
    { validator: emailValidator(), trigger: "change" },
    { validator: emailValidator(), trigger: "blur" }
  ],
  profilePhoto: [
    { required: true, message: "请输入您的头像 URL 地址！", trigger: "blur" },
    { validator: httpValidator(), trigger: "change" },
    { validator: httpValidator(), trigger: "blur" }
  ]
});

export const updatePwdFormData = reactive({
  oldPasswd: "",
  newPasswd: ""
});

/**
 * 用户更新密码表单规则
 */
export const userUpdatePwdFormRules = reactive<FormRules>({
  oldPasswd: [
    { required: true, message: "请输入您的原始密码", trigger: "blur" },
    { validator: passwordValidator(), trigger: "change" },
    { validator: passwordValidator(), trigger: "blur" }
  ],
  newPasswd: [
    { required: true, message: "请输入您的新密码", trigger: "blur" },
    { validator: passwordValidator(), trigger: "change" },
    { validator: passwordValidator(), trigger: "blur" }
  ]
});

/**
 * 新增收货地址表单数据
 */
export const addressFormData = reactive<AddressPoJo & { zone: string[] }>({
  province: "",
  city: "",
  area: "",
  street: "",
  detail: "",
  phone: "",
  holder: "",
  zone: []
});

/**
 * 新增收货地址表单规则
 */
export const addressFormRules = reactive<FormRules>({
  zone: [
    {
      required: true,
      message: "请输入收货地区！",
      trigger: "blur"
    }
  ],
  detail: [
    {
      required: true,
      message: "请输入收货详细地址！",
      trigger: "blur"
    },
    {
      min: 4,
      max: 100,
      message: "长度在 4 到 100 个字符",
      trigger: "blur"
    }
  ],
  holder: [
    {
      required: true,
      message: "请输入收货人姓名！",
      trigger: "blur"
    },
    {
      min: 1,
      max: 25,
      message: "长度在 1 到 25 个字符",
      trigger: "blur"
    }
  ],
  phone: [
    { required: true, message: "请输入您的手机号！", trigger: "blur" },
    { validator: phoneValidator(), trigger: "change" },
    { validator: phoneValidator(), trigger: "blur" }
  ]
});