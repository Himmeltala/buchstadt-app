<script setup lang="ts">
import { queryAll, updateOne } from "@root/api/api-orders";
import { disabledDate, dateShortcuts } from "@admin/common/el-form";

const orderList = shallowRef(await queryAll());
const statusOps = reactive([
  {
    value: "买家确认收货",
    label: "买家确认收货"
  },
  {
    value: "买家已付款",
    label: "买家已付款"
  },
  {
    value: "买家等待收货",
    label: "买家等待收货"
  }
]);

const paywayOps = reactive([
  {
    value: "钱包支付",
    label: "钱包支付"
  },
  {
    value: "银行卡支付",
    label: "银行卡支付"
  },
  {
    value: "微信支付",
    label: "微信支付"
  },
  {
    value: "支付宝支付",
    label: "支付宝支付"
  }
]);
</script>

<template>
  <el-table border :data="orderList" stripe style="width: 100%">
    <el-table-column type="expand" width="75" fixed label="操作" v-slot="{ row }">
      <div class="px-10 my-5">
        <el-form ref="formEl" :model="row" label-position="left" label-width="100px">
          <FormTitle title="主表数据" sub-title="订单的主要内容"></FormTitle>
          <el-form-item label="购买者" prop="holderName">
            <el-input v-model="row.holderName" clearable placeholder="请输入购买者姓名" />
          </el-form-item>
          <el-form-item label="手机号" prop="holderPhone">
            <el-input v-model="row.holderPhone" clearable placeholder="请输入购买者手机号" />
          </el-form-item>
          <el-form-item label="地址" prop="location">
            <el-input v-model="row.location" clearable placeholder="请输入邮寄地址" />
          </el-form-item>
          <el-form-item label="下单日期" prop="date">
            <el-date-picker
              disabled
              value-format="YYYY-MM-DD hh:mm:ss"
              v-model="row.date"
              type="datetime"
              placeholder="选择下单日期"
              :disabled-date="disabledDate"
              :shortcuts="dateShortcuts" />
          </el-form-item>
          <el-form-item label="订单总价" prop="total">
            <el-input disabled type="textarea" v-model="row.total" autosize placeholder="请输入订单总价" />
          </el-form-item>
          <el-form-item label="支付方式" prop="payway">
            <el-select v-model="row.payway" placeholder="请选择订单状态">
              <el-option v-for="item in paywayOps" :value="item.value" :label="item.label"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="订单状态" prop="status">
            <el-select v-model="row.status" placeholder="请选择订单状态">
              <el-option v-for="item in statusOps" :value="item.value" :label="item.label"></el-option>
            </el-select>
          </el-form-item>
        </el-form>
        <div f-c-c mt-5>
          <el-button type="primary" @click="async () => await updateOne(row, { id: row.id })">保存表单</el-button>
        </div>
        <FormTitle title="附表数据" sub-title="订单下的所有书籍"></FormTitle>
        <el-table :data="row.items">
          <el-table-column fixed prop="id" sortable label="ID" show-overflow-tooltip />
          <el-table-column prop="cover" sortable label="封面" show-overflow-tooltip />
          <el-table-column prop="name" sortable label="书籍名称" show-overflow-tooltip />
          <el-table-column prop="num" sortable label="数量" show-overflow-tooltip />
          <el-table-column prop="price" sortable label="单价" show-overflow-tooltip />
          <el-table-column prop="discount" sortable label="折扣" show-overflow-tooltip />
        </el-table>
      </div>
    </el-table-column>
    <el-table-column fixed prop="id" sortable label="ID" show-overflow-tooltip />
    <el-table-column fixed prop="holderName" label="购买者" show-overflow-tooltip width="150" />
    <el-table-column prop="holderPhone" sortable label="手机号" show-overflow-tooltip width="150" />
    <el-table-column prop="location" label="地址" show-overflow-tooltip width="200" />
    <el-table-column prop="date" sortable show-overflow-tooltip label="下单日期" width="200" />
    <el-table-column prop="total" label="订单总价" show-overflow-tooltip width="100" />
    <el-table-column prop="payway" label="支付方式" show-overflow-tooltip width="100" />
    <el-table-column prop="status" label="订单状态" show-overflow-tooltip width="200" />
  </el-table>
</template>

<style scoped lang="scss"></style>
