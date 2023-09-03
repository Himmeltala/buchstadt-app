<script setup lang="ts">
import { query, del as delCart, pay as payOrder } from "@root/api/api-carts";
import { submitForm } from "@root/common/el-form-validation";
import { receiveFormData, receiveFormRules } from "@client/common/el-form";

const trolleyData = ref();
trolleyData.value = await query();

const calcTotal = computed(() => {
  let total = 0;
  trolleyData.value.forEach((ele: any) => {
    total += ele.buch.price * ele.buch.discount * ele.num;
  });
  return parseFloat(total.toFixed(2));
});

async function delTableRow(index: number, row: any) {
  await delCart(row.id);
  trolleyData.value.splice(index, 1);
}

const router = useRouter();
const formRef = ref();

function getItems() {
  return trolleyData.value.map((ele: any) => ({
    buchId: ele.buch.id,
    num: ele.num
  }));
}

async function payment() {
  await payOrder({
    total: calcTotal.value,
    holderName: receiveFormData.receiveName,
    holderPhone: receiveFormData.receivePhone,
    location: receiveFormData.receiveLocation,
    items: getItems()
  });
  trolleyData.value.splice(0, trolleyData.value.length);
  router.push("/success/pay");
}
</script>

<template>
  <div class="page-content">
    <el-table class="mt-10" :data="trolleyData" style="width: 100%" stripe>
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
      <div class="mr-10">条数：{{ trolleyData.length }}</div>
      <div>总价：¥{{ calcTotal }}</div>
    </div>
    <div class="mb-10 w-100">
      <el-form label-position="left" :model="receiveFormData" :rules="receiveFormRules" ref="formRef">
        <el-form-item label="收货人：" prop="receiveName">
          <el-input v-model="receiveFormData.receiveName" placeholder="请输入收货人姓名"></el-input>
        </el-form-item>
        <el-form-item label="手机号：" prop="receivePhone">
          <el-input v-model="receiveFormData.receivePhone" placeholder="请输入收货人手机号"></el-input>
        </el-form-item>
        <el-form-item label="收货地址：" prop="receiveLocation">
          <el-input v-model="receiveFormData.receiveLocation" placeholder="请输入收货地址"></el-input>
        </el-form-item>
      </el-form>
      <el-button @click="submitForm(formRef, payment)" type="primary">支付</el-button>
    </div>
  </div>
</template>
