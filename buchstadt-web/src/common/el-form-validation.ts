import type { FormInstance } from "element-plus";

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

/**
 * 手机号验证器
 */
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
 * http 验证器
 */
export function httpValidator() {
  return (rule: any, value: any, callback: any) => {
    const regex = /^(https?|ftp):\/\/[^\s/$.?#].[^\s]*$/;

    if (!regex.test(value)) {
      callback(new Error("Http 地址不正确！"));
    } else {
      callback();
    }
  };
}

/*
 * 电子邮箱验证器
 */
export function emailValidator() {
  return (rule: any, value: any, callback: any) => {
    const regex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (!regex.test(value)) {
      callback(new Error("Http 地址不正确！"));
    } else {
      callback();
    }
  };
}

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

export type { FormInstance };
