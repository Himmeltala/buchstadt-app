import type { FormRules } from "element-plus";

export const formRules = reactive<FormRules>({
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
  cover: [{ required: true, message: "请输入书籍封面的 URL", trigger: "blur" }]
});

export const primeOps = ref([
  {
    value: 1,
    label: "是"
  },
  {
    value: 0,
    label: "否"
  }
]);

export const typeOps = ref([
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
