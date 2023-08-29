<script setup lang="ts">
import { IntentApi } from "@/apis";

defineProps(["data"]);
const emits = defineEmits(["onDel"]);

async function delIndent(id: number, index: number) {
  await IntentApi.del({
    id,
    userId: Number(localStorage.getItem("userId"))
  }).then(() => {
    emits("onDel", index);
  });
}

async function updateIndent(item: any) {
  await IntentApi.update(
    {
      id: item.id,
      status: "买家确认收货"
    },
    { id: item.id }
  ).then(() => {
    item.status = "买家确认收货";
  });
}
</script>

<template>
  <div v-if="data?.length" class="mb-20" v-for="(item, index) in data" :key="index">
    <div mb-5 font-bold>订单：{{ index + 1 }}</div>
    <el-table class="mb-10" :data="item.items" stripe>
      <el-table-column prop="name" label="名称"> </el-table-column>
      <el-table-column prop="price" label="单价"> </el-table-column>
      <el-table-column prop="num" label="数量"> </el-table-column>
      <el-table-column label="小计">
        <template v-slot="{ row }">¥{{ (row.num * row.price * row.discount).toFixed(2) }}</template>
      </el-table-column>
    </el-table>
    <div class="size-14px">
      <el-descriptions title="订单信息" :column="2" border>
        <el-descriptions-item>
          <template #label>
            <div f-c-s>
              <i-ep-key mr-2 />
              <div>订单号</div>
            </div>
          </template>
          {{ item.id }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div f-c-s>
              <i-ep-timer mr-2 />
              <div>订单日期</div>
            </div>
          </template>
          {{ item.date }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div f-c-s>
              <i-ep-coin mr-2 />
              <div>最终付款</div>
            </div>
          </template>
          ¥{{ item.total }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div f-c-s>
              <i-ep-user mr-2 />
              <div>收货人</div>
            </div>
          </template>
          {{ item.holderName }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div f-c-s>
              <i-ep-iphone mr-2 />
              <div>手机号</div>
            </div>
          </template>
          {{ item.holderPhone }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div f-c-s>
              <i-ep-location mr-2 />
              <div>快递地址</div>
            </div>
          </template>
          {{ item.location }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div f-c-s>
              <i-ep-van mr-2 />
              <div>订单状态</div>
            </div>
          </template>
          {{ item.status }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template #label>
            <div f-c-s>
              <i-ep-wallet mr-2 />
              <div>结算方式</div>
            </div>
          </template>
          {{ item.payway }}
        </el-descriptions-item>
      </el-descriptions>
      <div class="f-c-e mt-10">
        <el-button type="danger" v-if="item.status == '买家确认收货'" @click="delIndent(item.id, index)">删除订单</el-button>
        <el-button type="primary" v-if="item.status != '买家确认收货'" @click="updateIndent(item)">确认收货</el-button>
      </div>
    </div>
  </div>
  <div my-20 v-else>
    <el-result icon="提示" title="无数据">
      <template #sub-title>
        <p>当前标签页没有数据哟！</p>
      </template>
      <template #extra>
        <el-button type="primary" @click="$router.push('/')">返回主页</el-button>
      </template>
    </el-result>
  </div>
</template>

<style scoped lang="scss"></style>
