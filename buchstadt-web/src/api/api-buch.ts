/**
 * 关于书籍的 API
 */

/**
 * 收藏书籍
 */
export async function collect(id: number) {
  const { data } = await axiosInstance.post<HttpResponse>(
    "/buch/collection/insert",
    {},
    {
      params: {
        id
      }
    }
  );
  return data;
}

/**
 * 查询收藏的书籍
 */
export async function queryCollections() {
  const { data } = await axiosInstance.get<HttpResponse>("/buch/collection/query");
  return data.data;
}

/**
 * 查询书籍
 */
export async function query(id: number) {
  const { data } = await axiosInstance.get<HttpResponse>(`/buch/query`, {
    params: {
      id
    }
  });

  return data.data;
}

export async function queryAll(vo: BuchVo) {
  const { data } = await axiosInstance.post<HttpResponse>(`/buch/query/all`, vo);
  return data.data;
}

export async function update(params: BuchModel) {
  await axiosInstance.post<HttpResponse>(`/buch/update`, params);
}

export async function insert(params: BuchModel) {
  await axiosInstance.post<HttpResponse>(`/buch/insert`, params);
}

export async function insertAttach(params: BuchAttachData) {
  await axiosInstance.post<HttpResponse>(`/buch/insert/attach`, params);
}

export async function delTag(params: BuchTagData) {
  await axiosInstance.post<HttpResponse>(`/buch/delete/tag`, params);
}

export async function delAuthor(params: BuchAuthorData) {
  await axiosInstance.post<HttpResponse>(`/buch/delete/author`, params);
}

export async function delPreview(params: BuchPreviewData) {
  await axiosInstance.post<HttpResponse>(`/buch/delete/preview`, params);
}

export async function delBuch(params: BuchModel) {
  await axiosInstance.post<HttpResponse>(`/buch/delete`, params);
}
