declare type CommentPoJo = Partial<{
  id: number;
  buchId: number;
  userId: number;
  content: string;
  digg: number;
  bury: number;
  type: string;
  postDate: string;
  user: Partial<{
    id: number;
    username: string;
    profilePhoto: string;
    level: number;
  }>;
}>;

declare type AdminPoJo = Partial<{
  id: number;
  authority: string;
  username: string;
  password: string;
  phone: string;
  profilePhoto: string;
}>;

declare type BuchPoJo = Partial<{
  id: number;
  name: string;
  profile: string;
  price: number;
  discount: number;
  cover: string;
  isPrime: number;
  postDate: string;
  publisherId: number;
  type: string;
  tags: Partial<{ id: number; buchId: number; tag: string }>[];
  previews: Partial<{ id: number; buchId: number; url: string }>[];
  authors: Partial<{ id: number; buchId: number; author: string }>[];
  publisher: Partial<{
    id: number;
    name: string;
    profilePhoto: string;
    profile: string;
    desc: number;
    serv: number;
    logistics: number;
  }>;
}>;

declare type CollectionPoJo = Partial<{
  id: number;
  userId: number;
  buchId: number;
  collectDate: string;
  buch: Partial<{
    id: number;
    name: string;
    profile: string;
    price: number;
    discount: number;
    cover: string;
  }>;
  authors: Partial<{
    author: string;
  }>[];
  publisher: Partial<{
    id: number;
    name: string;
  }>;
}>;

declare type CartPoJo = Partial<{
  id: number;
  num: number;
  buch: Partial<{
    id: number;
    price: number;
    discount: number;
    name: string;
  }>;
  publisher: Partial<{
    id: number;
    name: string;
  }>;
}>;

declare type OrderPoJo = Partial<{
  id: number;
  date: string;
  total: number;
  location: string;
  holder: string;
  phone: string;
  status: string;
  method: string;
  item: Partial<{
    id: number;
    name: string;
    price: number;
    discount: number;
    cover: string;
    num: number;
  }>[];
}>;

declare type PublisherPoJo = Partial<{
  id: number;
  name: number;
  profilePhoto: string;
  profile: string;
  buchs: Partial<{
    id: number;
    name: string;
    price: number;
    discount: number;
    cover: string;
    type: string;
    authors: Partial<{
      id: number;
      author: string;
    }>[];
  }>[];
}>;

declare type UserPoJo = Partial<{
  id: number;
  username: string;
  password: string;
  profilePhoto: string;
  level: number;
  email: string;
  phone: string;
  profile: string;
  sex: string;
  registerDate: string;
}>;

declare type AddressPoJo = {
  id?: number;
  province: string;
  city: string;
  area: string;
  street: string;
  phone: string;
  holder: string;
  detail: string;
  isDefault?: number;
};
