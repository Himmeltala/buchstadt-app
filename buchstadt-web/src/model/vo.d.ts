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

/**
 * 评论查询数据
 */
declare interface BuchQueryVo {
  isPrime?: number;
  name?: string;
  type?: string;
}

/**
 * 书籍数据
 */
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
  publisherId?: number;
  tags?: BuchTagVo[];
  previews?: BuchPreviewVo[];
  authors?: BuchAuthorVo[];
}

/**
 * 书籍标签数据
 */
declare interface BuchTagVo {
  id?: number;
  buchId?: number;
  tag?: string;
}

/**
 * 书籍预览图数据
 */
declare interface BuchPreviewVo {
  id?: number;
  buchId?: number;
  url?: string;
}

/**
 * 数据作者数据
 */
declare interface BuchAuthorVo {
  id?: number;
  buchId?: number;
  author?: string;
}

/**
 * 书籍附表数据
 */
declare interface BuchAttachVo {
  tags: BuchTagVo[];
  previews: BuchPreviewVo[];
  authors: BuchAuthorVo[];
}

/**
 * 用户数据
 */
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

/**
 * 管理员数据
 */
declare interface AdminVo {
  id?: number;
  username: string;
  password: string;
  phone: string;
  authority: string;
  profilePhoto: string;
}
