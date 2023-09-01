/**
 * 购物车书籍项
 */
declare interface CartItemVo {
  id: number;
  count?: number;
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
  items: { buchId: number; count: number }[];
}

declare interface BuchQueryVo {
  isPrime?: number;
  name?: string;
  type?: string;
}

interface OrderItemVo {
  orderId?: number;
  bookId: number;
  num: number;
}

interface BuchVo {
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

interface BuchTagVo {
  id?: number;
  buchId?: number;
  tag?: string;
}

interface BuchPreviewVo {
  id?: number;
  buchId?: number;
  url?: string;
}

interface BuchAuthorVo {
  id?: number;
  buchId?: number;
  author?: string;
}

interface BuchAttachVo {
  tags: BuchTagVo[];
  previews: BuchPreviewVo[];
  authors: BuchAuthorVo[];
}

interface UserVo {
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

interface AdminVo {
  id?: number;
  username: string;
  password: string;
  phone: string;
  authority: string;
  profilePhoto: string;
}
