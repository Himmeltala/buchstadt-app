interface PayForData {
  id?: number;
  userId: number;
  date?: string;
  total: number;
  location: string;
  holderPhone: string;
  holderName: string;
  status?: string;
  payway?: string;
  items: OrderItems[];
}

interface OrderItem {
  orderId?: number;
  bookId: number;
  num: number;
}

interface BuchData {
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
  tags?: BuchTagData[];
  previews?: BuchPreviewData[];
  authors?: BuchAuthorData[];
}

interface BuchTagData {
  id?: number;
  buchId?: number;
  tag?: string;
}

interface BuchPreviewData {
  id?: number;
  buchId?: number;
  url?: string;
}

interface BuchAuthorData {
  id?: number;
  buchId?: number;
  author?: string;
}

interface BuchAttachData extends BuchData {
  tags: BuchTagData[];
  previews: BuchPreviewData[];
  authors: BuchAuthorData[];
}

interface UserData {
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

interface AdminData {
  id?: number;
  username: string;
  password: string;
  phone: string;
  authority: string;
  profilePhoto: string;
}
