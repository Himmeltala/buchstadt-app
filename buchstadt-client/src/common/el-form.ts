import type { FormInstance } from "element-plus";

export const submitForm = async (formEl: FormInstance | undefined, success: Function) => {
  if (!formEl) return;
  await formEl.validate((valid, fields) => {
    if (valid) {
      success();
    } else {
      ElMessage.error("表单内容输入不完整！");
    }
  });
};

export const resetForm = (formEl: FormInstance | undefined) => {
  if (!formEl) return;
  formEl.resetFields();
};
