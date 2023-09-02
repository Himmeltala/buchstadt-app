/**
 * 关于书籍的 API
 */

export async function collect(vo: BuchVo) {
  await axiosInstance.post<R>("/buch-collection/auth/insert", vo);
}

export async function queryCollections() {
  const { data } = await axiosInstance.get<R>("/buch-collection/auth/query");
  return data.data;
}

export async function query(vo: BuchVo) {
  const { data } = await axiosInstance.post<R>(`/buch/public/query`, vo);
  return data.data;
}

export async function queryAll(vo: BuchQueryVo) {
  const { data } = await axiosInstance.post<R>(`/buch/public/query/all`, vo);
  return data.data;
}

export async function update(vo: BuchVo) {
  await axiosInstance.post<R>(`/buch/auth/update`, vo);
}

export async function insert(vo: BuchVo) {
  await axiosInstance.post<R>(`/buch/auth/insert`, vo);
}

export async function insertAttach(vo: BuchAttachVo) {
  await axiosInstance.post<R>(`/buch/auth/insert/attach`, vo);
}

export async function delTag(vo: BuchTagVo) {
  await axiosInstance.post<R>(`/buch/auth/delete/tag`, vo);
}

export async function delAuthor(vo: BuchAuthorVo) {
  await axiosInstance.post<R>(`/buch/auth/delete/author`, vo);
}

export async function delPreview(vo: BuchPreviewVo) {
  await axiosInstance.post<R>(`/buch/auth/delete/preview`, vo);
}

export async function delBuch(vo: BuchVo) {
  await axiosInstance.post<R>(`/buch/auth/delete`, vo);
}
