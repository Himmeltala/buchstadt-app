export namespace AdminApi {
  export async function queryAll() {
    const { data } = await axiosInstance.post(`/admin/query/all`);
    return data;
  }

  export async function del(params: AdminVo) {
    const { data } = await axiosInstance.post(`/admin/delete`, params);
    if (data == 1) {
      ElMessage.success("删除成功");
    } else {
      ElMessage.error("删除失败");
    }
  }

  export async function update(params: AdminVo) {
    const { data } = await axiosInstance.post(`/admin/update`, params);
    if (data == 1) {
      ElMessage.success("更新成功");
    } else {
      ElMessage.error("更新失败");
    }
  }

  export async function insert(params: AdminVo) {
    const { data } = await axiosInstance.post(`/admin/insert`, params);
    if (data == 1) {
      ElMessage.success("添加成功");
    } else {
      ElMessage.error("添加失败");
    }
  }
}
