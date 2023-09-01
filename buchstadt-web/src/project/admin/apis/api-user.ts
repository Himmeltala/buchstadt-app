export namespace UserApi {
  export async function queryAll() {
    const { data } = await axiosInstance.post(`/user/query/all`);
    return data;
  }

  export async function insert(params: UserVo) {
    const { data } = await axiosInstance.post(`/user/insert`, params);
    if (data == 1) {
      ElMessage.success("提交表单成功");
    } else {
      ElMessage.error("提交表单失败");
    }
  }

  export async function update(params: UserVo) {
    const { data } = await axiosInstance.post(`/user/update`, params);
    if (data == 1) {
      ElMessage.success("提交表单成功");
    } else {
      ElMessage.error("提交表单失败");
    }
  }

  export async function del(params: UserVo) {
    const { data } = await axiosInstance.post(`/user/delete`, params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }
}
