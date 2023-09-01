<script setup lang="ts">
import { queryAll, update, delBuch } from "@root/api/api-buch";
import { RouterPaths } from "@admin/constants/router-path";
import { submitForm } from "@root/common/el-form-validation";
import { buchFormRules, buchTypeOps, buchPrimeOps, dateShortcuts, disabledDate } from "@admin/common/el-form";

const formEl = ref();
const buchList = shallowRef();
buchList.value = await queryAll({});

async function deleteBuch(row: BuchVo, index: number) {
  await delBuch(row);
  buchList.value = buchList.value.toSpliced(index, 1);
}
</script>

<template>
  <div>
    <el-table border :data="buchList" stripe style="width: 100%">
      <el-table-column type="expand" width="100" fixed label="操作" v-slot="{ row }">
        <div px-10 my-5>
          <el-form ref="formEl" :model="row" :rules="buchFormRules" label-position="left" label-width="100px">
            <div mb-5><span font-bold mr-2>主表数据</span><span class="size-13px text-gray-5">书籍的主要内容</span></div>
            <el-form-item label="书名" prop="name">
              <el-input v-model="row.name" clearable placeholder="请输入书籍名称" />
            </el-form-item>
            <el-form-item label="出版日期" prop="postDate">
              <el-date-picker
                value-format="YYYY-MM-DD"
                v-model="row.postDate"
                type="date"
                placeholder="选择出版日期"
                :disabled-date="disabledDate"
                :shortcuts="dateShortcuts" />
            </el-form-item>
            <el-form-item label="单价" prop="price">
              <el-input type="number" clearable placeholder="请输入书籍单价" v-model="row.price" />
            </el-form-item>
            <el-form-item label="折扣" prop="discount">
              <el-input type="number" clearable placeholder="请输入书籍折扣" v-model="row.discount" />
            </el-form-item>
            <el-form-item label="简介" prop="profile">
              <el-input type="textarea" v-model="row.profile" autosize placeholder="请输入书籍简介" />
            </el-form-item>
            <el-form-item label="类型" prop="type">
              <el-select v-model="row.type" placeholder="选择书籍类型">
                <el-option v-for="item in buchTypeOps" :key="item.value" :label="item.label" :value="item.value" />
              </el-select>
            </el-form-item>
            <el-form-item label="首推" prop="isPrime">
              <el-select v-model="row.isPrime" placeholder="是否首推到首页">
                <el-option v-for="item in buchPrimeOps" :key="item.value" :label="item.label" :value="item.value" />
              </el-select>
            </el-form-item>
            <el-form-item label="封面" prop="cover">
              <el-input v-model="row.cover" clearable placeholder="仅支持网络图片" />
            </el-form-item>
          </el-form>
          <div f-c-c mt-5>
            <el-button type="primary" @click="submitForm(formEl, async () => await update(row))">保存表单</el-button>
          </div>
        </div>
      </el-table-column>
      <el-table-column fixed prop="id" sortable label="ID" show-overflow-tooltip />
      <el-table-column fixed prop="name" label="书名" show-overflow-tooltip width="200" />
      <el-table-column prop="postDate" sortable show-overflow-tooltip label="出版日期" />
      <el-table-column prop="price" sortable label="单价" />
      <el-table-column prop="discount" sortable label="折扣" />
      <el-table-column prop="profile" label="简介" show-overflow-tooltip width="200" />
      <el-table-column prop="type" label="类型" />
      <el-table-column prop="isPrime" label="是否首推" sortable v-slot="{ row }">
        <span v-if="row.isPrime">是</span>
        <span v-else-if="!row.isPrime">否</span>
      </el-table-column>
      <el-table-column label="更多" width="150" v-slot="scope">
        <el-button size="small" type="success" plain @click="$router.push(RouterPaths.buchs.update + scope.row.id)">详细</el-button>
        <el-popconfirm title="你确定要删除该书籍？" @confirm="deleteBuch(scope.row, scope.$index)">
          <template #reference>
            <el-button size="small" type="danger" plain>删除</el-button>
          </template>
        </el-popconfirm>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped lang="scss"></style>
