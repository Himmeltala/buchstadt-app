import type { FormInstance, FormRules } from "element-plus";

/**
 * 用户名验证器
 */
export function usernameValidator() {
  return (rule: any, value: any, callback: any) => {
    const regex = /^(?![_-])[\u4e00-\u9fa5a-zA-Z][\u4e00-\u9fa5a-zA-Z0-9_-]{4,16}$/;

    if (!regex.test(value)) {
      callback(new Error("字母、中文、-、_，不能以数字开头、-、_开头，长度在4~16"));
    } else if (value === "") {
      callback(new Error("请输入用户名！"));
    } else {
      callback();
    }
  };
}

/**
 * 密码验证器
 */
export function passwordValidator() {
  return (rule: any, value: any, callback: any) => {
    const regex = /^[a-zA-Z0-9.]{8,16}$/;

    if (!regex.test(value)) {
      callback(new Error("英文、.、数字，长度在8~16"));
    } else if (value === "") {
      callback(new Error("请输入密码！"));
    } else {
      callback();
    }
  };
}

/**
 * 二次密码验证器
 */
export function rePasswdValidator(formData: any) {
  return (rule: any, value: any, callback: any) => {
    const regex = /^[a-zA-Z0-9.]{8,16}$/;

    if (!regex.test(value)) {
      callback(new Error("英文、.、数字，长度在8~16"));
    } else if (value === "") {
      callback(new Error("请输入密码！"));
    } else if (formData.rePasswd !== formData.password) {
      callback(new Error("两次密码输入不一致！"));
    } else {
      callback();
    }
  };
}

export function phoneValidator() {
  return (rule: any, value: any, callback: any) => {
    const regex = /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;

    if (!regex.test(value)) {
      callback(new Error("手机号码格式不正确！"));
    } else {
      callback();
    }
  };
}

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

export const submitForm = async (formEl: FormInstance | undefined, success: Function) => {
  if (!formEl) return;
  await formEl.validate((valid, fields) => {
    if (!valid) return false;
    success();
  });
};

export const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.resetFields();
};

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
