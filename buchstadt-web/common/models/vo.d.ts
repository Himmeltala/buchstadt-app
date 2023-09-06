/**
 * 支付订单数据
 */
declare interface PayVo {
  id?: number;
  date?: string;
  total: number;
  location: string;
  phone: string;
  holder: string;
  status?: string;
  method?: string;
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
