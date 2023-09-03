export async function queryOne(vo: BuchVo) {
  const { data } = await axiosInstance.post<R>(`/buch/public/query/one`, vo);
  return data.data;
}

export async function queryAll(vo: BuchQueryVo) {
  const { data } = await axiosInstance.post<R>(`/buch/public/query/all`, vo);
  return data.data;
}

export async function updateOne(vo: BuchVo) {
  await axiosInstance.post<R>(`/buch/auth/update/one`, vo);
}

export async function insertOne(vo: BuchVo) {
  await axiosInstance.post<R>(`/buch/auth/insert/one`, vo);
}

export async function insertOneAttach(vo: BuchAttachVo) {
  await axiosInstance.post<R>(`/buch/auth/insert/one-attach`, vo);
}

export async function deleteOneTag(vo: BuchTagVo) {
  await axiosInstance.post<R>(`/buch/auth/delete/one-tag`, vo);
}

export async function deleteOneAuthor(vo: BuchAuthorVo) {
  await axiosInstance.post<R>(`/buch/auth/delete/one-author`, vo);
}

export async function deleteOnePreview(vo: BuchPreviewVo) {
  await axiosInstance.post<R>(`/buch/auth/delete/one-preview`, vo);
}

export async function deleteOne(vo: BuchVo) {
  await axiosInstance.post<R>(`/buch/auth/delete/one`, vo);
}

export async function insertOneCollection(vo: BuchVo) {
  await axiosInstance.post<R>("/buch/auth/insert/one-collection", vo);
}

export async function queryAllCollection() {
  const { data } = await axiosInstance.get<R>("/buch/auth/query/all-collection");
  return data.data;
}

export async function queryAllComment(vo: BuchCommentVo) {
  const { data } = await axiosInstance.post<R>("/buch/public/query/all-comment", vo);
  return data.data;
}

export function insertOneComment(body: { content: string; type: string; buchId: number; userId?: number }) {
  return axiosInstance.post<R>("/buch/auth/insert/one-comment", body);
}

export async function deleteOneComment(params: { id: number }) {
  const { data } = await axiosInstance.post<R>("/buch/auth/delete/one-comment", params);
  return data.data;
}
