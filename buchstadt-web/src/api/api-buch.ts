export async function queryOne(vo: BuchVo) {
  const { data } = await axiosInstance.post<R<BuchPojo>>(`/buch/public/query/one`, vo);
  return data.data;
}

export async function queryAll(vo: BuchQueryVo) {
  const { data } = await axiosInstance.post<R<BuchPojo[]>>(`/buch/public/query/all`, vo);
  return data.data;
}

export async function updateOne(vo: BuchVo) {
  return await axiosInstance.post<R<void>>(`/buch/auth/update/one`, vo);
}

export async function insertOne(vo: BuchPojo) {
  return await axiosInstance.post<R<void>>(`/buch/auth/insert/one`, vo);
}

export async function insertOneAttach(vo: BuchAttachVo) {
  return await axiosInstance.post<R<void>>(`/buch/auth/insert/one-attach`, vo);
}

export async function deleteOneTag(vo: BuchTagVo) {
  return await axiosInstance.post<R<void>>(`/buch/auth/delete/one-tag`, vo);
}

export async function deleteOneAuthor(vo: BuchAuthorVo) {
  return await axiosInstance.post<R<void>>(`/buch/auth/delete/one-author`, vo);
}

export async function deleteOnePreview(vo: BuchPreviewVo) {
  return await axiosInstance.post<R<void>>(`/buch/auth/delete/one-preview`, vo);
}

export async function deleteOne(vo: BuchVo) {
  return await axiosInstance.post<R<void>>(`/buch/auth/delete/one`, vo);
}

export async function insertOneCollection(vo: BuchVo) {
  return await axiosInstance.post<R<void>>("/buch/auth/insert/one-collection", vo);
}

export async function queryAllCollection() {
  const { data } = await axiosInstance.get<R<CollectionPojo[]>>("/buch/auth/query/all-collection");
  return data.data;
}

export async function queryAllComment(vo: BuchCommentVo) {
  const { data } = await axiosInstance.post<R<CommentPojo[]>>("/buch/public/query/all-comment", vo);
  return data.data;
}

export function insertOneComment(body: { content: string; type: string; buchId: number; userId?: number }) {
  return axiosInstance.post<R<void>>("/buch/auth/insert/one-comment", body);
}

export async function deleteOneComment(params: { id: number }) {
  return await axiosInstance.post<R<void>>("/buch/auth/delete/one-comment", params);
}
