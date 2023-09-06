import type { FormRules } from "element-plus";
import { usernameValidator, passwordValidator, phoneValidator, httpValidator } from "@common/elemplus/el-form-validation";

/**
 * 书籍表单规则
 */
export const buchFormRules = reactive<FormRules>({
  name: [
    { required: true, message: "请输入书籍名称", trigger: "change" },
    { min: 2, max: 50, message: "长度在 2 ~ 50", trigger: "change" }
  ],
  postDate: [
    {
      type: "date",
      required: true,
      message: "请选择一个日期",
      trigger: "blur"
    }
  ],
  profile: [
    { required: true, message: "请输入书籍的简介", trigger: "blur" },
    { min: 10, max: 1500, message: "长度在 10 ~ 1000", trigger: "change" }
  ],
  cover: [
    { required: true, message: "请输入书籍封面的 URL", trigger: "blur" },
    { validator: httpValidator(), trigger: "change" },
    { validator: httpValidator(), trigger: "blur" }
  ]
});

/**
 * 书籍表单数据
 */
export const buchFormData = reactive({
  name: "",
  postDate: "",
  profile: "",
  cover: "",
  price: 10,
  discount: 0.5,
  type: "literature",
  isPrime: 0,
  publisherId: 0,
  tags: [{ tag: "" }],
  previews: [{ url: "" }],
  authors: [{ author: "" }]
});

export const buchPrimeOps = reactive([
  {
    value: 1,
    label: "是"
  },
  {
    value: 0,
    label: "否"
  }
]);

export const buchTypeOps = reactive([
  {
    value: "literature",
    label: "文学"
  },
  {
    value: "living",
    label: "生活"
  },
  {
    value: "computer",
    label: "计算机"
  },
  {
    value: "language",
    label: "外语"
  },
  {
    value: "business",
    label: "经营"
  },
  {
    value: "motivation",
    label: "励志"
  },
  {
    value: "social",
    label: "社科"
  },
  {
    value: "academic",
    label: "学术"
  },
  {
    value: "children",
    label: "少儿"
  },
  {
    value: "origin",
    label: "原版"
  },
  {
    value: "technology",
    label: "科技"
  },
  {
    value: "examine",
    label: "考试"
  },
  {
    value: "art",
    label: "艺术"
  },
  {
    value: "encyclopedia",
    label: "生活百科"
  }
]);

export const dateShortcuts = [
  {
    text: "今天",
    value: new Date()
  },
  {
    text: "昨天",
    value: () => {
      const date = new Date();
      date.setTime(date.getTime() - 3600 * 1000 * 24);
      return date;
    }
  },
  {
    text: "一周前",
    value: () => {
      const date = new Date();
      date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
      return date;
    }
  },
  {
    text: "一月前",
    value: () => {
      const date = new Date();
      date.setTime(date.getTime() - 3600 * 1000 * 24 * 30);
      return date;
    }
  },
  {
    text: "一年前",
    value: () => {
      const date = new Date();
      date.setTime(date.getTime() - 3600 * 1000 * 24 * 365);
      return date;
    }
  }
];

export const disabledDate = (time: Date) => {
  return time.getTime() > Date.now();
};

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

/**
 * 用户表单规则
 */
export const userFormRules = reactive<FormRules>({
  username: [
    { required: true, message: "请输入用户名", trigger: "change" },
    { validator: usernameValidator(), trigger: "change" },
    { validator: usernameValidator(), trigger: "blur" }
  ],
  password: [
    { required: true, message: "请输入密码", trigger: "blur" },
    { validator: passwordValidator(), trigger: "change" },
    { validator: passwordValidator(), trigger: "blur" }
  ],
  phone: [
    { required: true, message: "请输入手机号", trigger: "blur" },
    { validator: phoneValidator(), trigger: "change" },
    { validator: phoneValidator(), trigger: "blur" }
  ],
  profilePhoto: [
    { required: true, message: "请输入头像 URL", trigger: "blur" },
    { validator: httpValidator(), trigger: "change" },
    { validator: httpValidator(), trigger: "blur" }
  ]
});

/**
 * 管理员表单规则
 */
export const AdminFormRules = reactive<FormRules>({
  username: [
    { required: true, message: "请输入用户名", trigger: "change" },
    { validator: usernameValidator(), trigger: "change" },
    { validator: usernameValidator(), trigger: "blur" }
  ],
  password: [
    { required: true, message: "请输入密码", trigger: "blur" },
    { validator: passwordValidator(), trigger: "change" },
    { validator: passwordValidator(), trigger: "blur" }
  ],
  phone: [
    { required: true, message: "请输入手机号", trigger: "blur" },
    { validator: phoneValidator(), trigger: "change" },
    { validator: phoneValidator(), trigger: "blur" }
  ],
  profilePhoto: [
    { required: true, message: "请输入头像 URL", trigger: "blur" },
    { validator: httpValidator(), trigger: "change" },
    { validator: httpValidator(), trigger: "blur" }
  ],
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

/**
 * 出版社表单规则
 */
export const pubFormRules = reactive({
  name: [{ required: true, message: "请输入出版社名称！", trigger: "blur" }],
  profile: [{ required: true, message: "请输入出版社简介！", trigger: "blur" }],
  profilePhoto: [
    { required: true, message: "请输入 URL 图片地址！", trigger: "blur" },
    { validator: httpValidator(), trigger: "change" },
    { validator: httpValidator(), trigger: "blur" }
  ]
});
