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
      callback(new Error("请输入用户名"));
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
      callback(new Error("请输入密码"));
    } else {
      callback();
    }
  };
}

/**
 * 二次密码验证器
 */
export function rePasswdValidator(formData: { password: string; rePasswd: string }) {
  return (rule: any, value: any, callback: any) => {
    const regex = /^[a-zA-Z0-9.]{8,16}$/;

    if (!regex.test(value)) {
      callback(new Error("英文、.、数字，长度在8~16"));
    } else if (value === "") {
      callback(new Error("请输入密码"));
    } else if (formData.rePasswd !== formData.password) {
      callback(new Error("两次密码输入不一致"));
    } else {
      callback();
    }
  };
}

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

export const loginFormData = reactive({
  username: "",
  password: ""
});

export const submitForm = async (formEl: FormInstance | undefined, success: Function) => {
  if (!formEl) return;
  await formEl.validate((valid, fields) => {
    if (!valid) return false;
    success();
  });
};
