/**
 * 购物车书籍项
 */
declare interface CartItemVo {
  id: number;
  num?: number;
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
 * 地址数据
 */
declare type AddressVo = {
  zone: string[];
  phone: string;
  holder: string;
  detail: string;
};
