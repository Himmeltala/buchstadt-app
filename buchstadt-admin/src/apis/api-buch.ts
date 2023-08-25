export namespace BuchApi {
  export async function collect(params: { userId: number; buchId: number }) {
    const { data } = await axiosInstance.post("/buch/collection/insert", params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
    return data;
  }

  export async function queryCollections(params: { userId: number }) {
    const {
      data: { data }
    } = await axiosInstance.get("/buch/collection/query", { params });
    return data;
  }

  export async function query(params: { buchId: number }): Promise<BuchData> {
    const { data } = await axiosInstance.get(`/buch/query`, {
      params
    });
    return data;
  }

  export async function queryAll(params?: { isPrime?: number; buchName?: string; type?: string }) {
    const { data } = await axiosInstance.get(`/buch/query/all`, {
      params
    });
    return data;
  }

  export async function update(params: BuchData) {
    const { data } = await axiosInstance.post(`/buch/update`, params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }

  export async function insert(params: BuchData) {
    const { data } = await axiosInstance.post(`/buch/insert`, params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }

  export async function insertAttach(params: BuchAttachData) {
    const { data } = await axiosInstance.post(`/buch/insert/attach`, params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }

  export async function delTag(params: BuchTagData) {
    const { data } = await axiosInstance.post(`/buch/delete/tag`, params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }

  export async function delAuthor(params: BuchAuthorData) {
    const { data } = await axiosInstance.post(`/buch/delete/author`, params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }

  export async function delPreview(params: BuchPreviewData) {
    const { data } = await axiosInstance.post(`/buch/delete/preview`, params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }

  export async function delBuch(params: BuchData) {
    const { data } = await axiosInstance.post(`/buch/delete`, params);
    if (data.status == 200) {
      ElMessage.success(data.message);
    } else {
      ElMessage.error(data.message);
    }
  }
}
