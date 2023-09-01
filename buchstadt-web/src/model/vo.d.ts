declare interface CartItemVo {
  id: number;
  count?: number;
}

declare interface BuchCommentVo {
  id?: number;
  type?: string;
  diggOp?: string;
  buryOp?: string;
  digg?: number;
  bury?: number;
}

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
