<template>
  <div class="page-content">
    <el-table mb-10 :data="trolleyData" style="width: 100%" stripe>
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
    <div mb-10 f-c-e class="size-14px">
      <div mr-10>条数：{{ trolleyData.length }}</div>
      <div>总价：¥{{ calcTotal }}</div>
    </div>
    <div class="mb-10 w-100">
      <el-form label-position="left" :model="formData" :rules="formRules" ref="formRef">
        <el-form-item label="收货人：" prop="receiveName">
          <el-input v-model="formData.receiveName"></el-input>
        </el-form-item>
        <el-form-item label="手机号：" prop="receivePhone">
          <el-input v-model="formData.receivePhone"></el-input>
        </el-form-item>
        <el-form-item label="收货地址：" prop="receiveLocation">
          <el-input v-model="formData.receiveLocation"></el-input>
        </el-form-item>
      </el-form>
      <el-button @click="submitForm(formRef, payFor)" type="primary">支付</el-button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { TrolleyApi } from "@/apis/api-carts";
import { submitForm } from "@/common/el-form";

const formData = ref({
  receiveName: "",
  receivePhone: "",
  receiveLocation: ""
});
const formRules = ref({
  receiveName: [
    {
      required: true,
      message: "请输入收货人姓名",
      trigger: "blur"
    },
    {
      min: 2,
      max: 15,
      message: "长度在 2 到 15 个字符",
      trigger: "blur"
    }
  ],
  receivePhone: [
    {
      required: true,
      message: "请输入收货人手机号",
      trigger: "blur"
    },
    {
      min: 11,
      max: 11,
      message: "非法的手机号",
      trigger: "blur"
    }
  ],
  receiveLocation: [
    {
      required: true,
      message: "请输入收货地址",
      trigger: "blur"
    },
    {
      min: 8,
      max: 30,
      message: "长度在 8 到 30 个字符",
      trigger: "blur"
    }
  ]
});

const trolleyData = ref();

trolleyData.value = await TrolleyApi.query({
  userId: Number(localStorage.getItem("userId"))
});

const calcTotal = computed(() => {
  let total = 0;
  trolleyData.value.forEach((ele: any) => {
    total += ele.buch.price * ele.buch.discount * ele.num;
  });
  return parseFloat(total.toFixed(2));
});

async function delTableRow(index: number, row: any) {
  await TrolleyApi.del({ id: row.id });
  trolleyData.value.splice(index, 1);
}

const router = useRouter();
const formRef = ref();

async function payFor() {
  await TrolleyApi.pay({
    total: calcTotal.value,
    userId: Number(localStorage.getItem("userId")),
    holderName: formData.value.receiveName,
    holderPhone: formData.value.receivePhone,
    location: formData.value.receiveLocation,
    items: trolleyData.value.map((ele: any) => ({
      buchId: ele.buch.id,
      num: ele.num
    }))
  }).then(() => {
    trolleyData.value.splice(0, trolleyData.value.length);
    router.push("/success/pay");
  });
}
</script>
