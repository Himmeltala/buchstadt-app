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

declare interface BuchVo {
  isPrime?: number;
  name?: string;
  type?: string;
}
