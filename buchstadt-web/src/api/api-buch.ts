/**
 * 关于书籍的 API
 */

export async function collect(vo: BuchVo) {
  await axiosInstance.post<HttpResponse>("/buch/collection/insert", vo);
}

export async function queryCollections() {
  const { data } = await axiosInstance.get<HttpResponse>("/buch/collection/query");
  return data.data;
}

export async function query(vo: BuchVo) {
  const { data } = await axiosInstance.post<HttpResponse>(`/buch/query`, vo);
  return data.data;
}

export async function queryAll(vo: BuchQueryVo) {
  const { data } = await axiosInstance.post<HttpResponse>(`/buch/query/all`, vo);
  return data.data;
}

export async function update(vo: BuchVo) {
  await axiosInstance.post<HttpResponse>(`/buch/update`, vo);
}

export async function insert(vo: BuchVo) {
  await axiosInstance.post<HttpResponse>(`/buch/insert`, vo);
}

export async function insertAttach(vo: BuchAttachVo) {
  await axiosInstance.post<HttpResponse>(`/buch/insert/attach`, vo);
}

export async function delTag(vo: BuchTagVo) {
  await axiosInstance.post<HttpResponse>(`/buch/delete/tag`, vo);
}

export async function delAuthor(vo: BuchAuthorVo) {
  await axiosInstance.post<HttpResponse>(`/buch/delete/author`, vo);
}

export async function delPreview(vo: BuchPreviewVo) {
  await axiosInstance.post<HttpResponse>(`/buch/delete/preview`, vo);
}

export async function delBuch(vo: BuchVo) {
  await axiosInstance.post<HttpResponse>(`/buch/delete`, vo);
}
