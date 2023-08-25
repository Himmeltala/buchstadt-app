import type { FormRules } from "element-plus";

export const formRules = reactive<FormRules>({
  name: [{ required: true, message: "请输入出版社名称", trigger: "change" }],
  profilePhoto: [{ required: true, message: "请输入图标 URL", trigger: "blur" }],
  profile: [{ required: true, message: "请输入出版社的", trigger: "blur" }]
});
