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
