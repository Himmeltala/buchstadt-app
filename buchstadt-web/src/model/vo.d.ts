/**
 * 购物车书籍项
 */
declare interface CartItemVo {
  id: number;
  num?: number;
}

/**
 * 书籍评论
 */
declare interface BuchCommentVo {
  id?: number;
  type?: string;
  diggOp?: string;
  buryOp?: string;
  digg?: number;
  bury?: number;
}

/**
 * 支付订单数据
 */
declare interface PayVo {
  id?: number;
  date?: string;
  total: number;
  location: string;
  holderPhone: string;
  holderName: string;
  status?: string;
  payway?: string;
  items: { buchId: number; num: number }[];
}

declare interface BuchQueryVo {
  isPrime?: number;
  name?: string;
  type?: string;
}

declare interface OrderItemVo {
  orderId?: number;
  bookId: number;
  num: number;
}

declare interface BuchVo {
  id?: number;
  name?: string;
  profile?: string;
  price?: number;
  discount?: number;
  cover?: string;
  isPrime?: number;
  postDate?: string;
  type?: string;
  publisherId?: number | string;
  tags?: BuchTagVo[];
  previews?: BuchPreviewVo[];
  authors?: BuchAuthorVo[];
}

declare interface BuchTagVo {
  id?: number;
  buchId?: number;
  tag?: string;
}

declare interface BuchPreviewVo {
  id?: number;
  buchId?: number;
  url?: string;
}

declare interface BuchAuthorVo {
  id?: number;
  buchId?: number;
  author?: string;
}

declare interface BuchAttachVo {
  tags: BuchTagVo[];
  previews: BuchPreviewVo[];
  authors: BuchAuthorVo[];
}

declare interface UserVo {
  username: string;
  password: string;
  profilePhoto: string;
  level: number;
  email: string;
  phone: string;
  profile: string;
  sex: string;
  registerDate: string;
}

declare interface AdminVo {
  id?: number;
  username: string;
  password: string;
  phone: string;
  authority: string;
  profilePhoto: string;
}

declare interface PayedOrderVo {
  id?: number;
  date?: string;
  total: number;
  location: string;
  holderPhone: string;
  holderName: string;
  status?: string;
  payway?: string;
  items: { id: number; name: string; price: number; discount: number; cover: string; num: number }[];
}
