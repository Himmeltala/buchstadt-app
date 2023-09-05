<script setup lang="ts">
import { query, del as delCart, pay as payOrder } from "@root/api/api-carts";
import { AddressApi } from "@root/api/api-user";

const data = ref(await query());
const address = ref(await AddressApi.queryOne({ isDefault: 1 }));

const calcTotal = computed(() => {
  let total = 0;
  data.value.forEach((ele: any) => {
    total += ele.buch.price * ele.buch.discount * ele.num;
  });
  return parseFloat(total.toFixed(2));
});

async function delTableRow(index: number, row: any) {
  await delCart(row.id);
  data.value.splice(index, 1);
}

const router = useRouter();

function getItems() {
  return data.value.map((ele: any) => ({
    buchId: ele.buch.id,
    num: ele.num
  }));
}

async function payment() {
  const location = address.value.province + address.value.city + address.value.area + (address.value.street || "") + address.value.detail;

  await payOrder({
    total: calcTotal.value,
    holderName: address.value.holder,
    holderPhone: address.value.phone,
    location,
    items: getItems()
  });

  data.value.splice(0, data.value.length);
  router.push("/success/pay");
}
</script>

<template>
  <div class="page-content">
    <el-table class="mt-10" :data="data" style="width: 100%" stripe>
      <el-table-column type="index" label="序号" width="55"></el-table-column>
      <el-table-column label="所属店铺">
        <template v-slot="{ row: { publisher } }"> {{ publisher.name }} </template>
      </el-table-column>
      <el-table-column label="商品名称">
        <template v-slot="{ row: { buch } }"> {{ buch.name }} </template>
      </el-table-column>
      <el-table-column sortable label="单价">
        <template v-slot="{ row: { buch } }"> {{ buch.price }} </template>
      </el-table-column>
      <el-table-column sortable label="单个折扣">
        <template v-slot="{ row: { buch } }"> {{ buch.price * buch.discount }} </template>
      </el-table-column>
      <el-table-column prop="num" label="数量"></el-table-column>
      <el-table-column label="小计">
        <template v-slot="{ row }"> {{ row.buch.price * row.buch.discount * row.num }} </template>
      </el-table-column>
      <el-table-column label="操作">
        <template v-slot="scope">
          <el-button @click="delTableRow(scope.$index, scope.row)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div class="my-10 f-c-e text-0.8rem">
      <div class="mr-10">条数：{{ data.length }}</div>
      <div>总价：¥{{ calcTotal }}</div>
    </div>
    <div class="mb-10">
      <div class="mb-2">收货人：{{ address.holder }}</div>
      <div class="mb-2">手机号：{{ address.phone }}</div>
      <div class="mb-2">
        <span> 收货地址：</span>
        <span class="mr-2">
          {{ address.province }}
        </span>
        <span class="mr-2">{{ address.city }}</span>
        <span class="mr-2">{{ address.area }}</span>
        <span class="mr-2" v-if="address.street">{{ address.street }}</span>
        <span>
          {{ address.detail }}
        </span>
      </div>
    </div>
    <div class="f-c-c">
      <el-button @click="payment" type="primary">支付订单</el-button>
    </div>
  </div>
</template>
