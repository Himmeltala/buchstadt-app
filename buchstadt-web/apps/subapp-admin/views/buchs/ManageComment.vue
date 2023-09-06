<script setup lang="ts">
import { queryAllComment, deleteOneComment } from "@subapp-admin/apis/api-buch";

const formData = reactive({
  id: 0,
  type: "all",
  digg: 0,
  bury: 0,
  diggOp: "not",
  buryOp: "not"
});
const data = shallowRef(await queryAllComment(formData));
const operOps = reactive([
  {
    value: "not",
    label: "不选"
  },
  {
    value: "gt",
    label: "大于"
  },
  {
    value: "gteq",
    label: "大于等于"
  },
  {
    value: "eq",
    label: "等于"
  },
  {
    value: "lt",
    label: "小于"
  },
  {
    value: "lteq",
    label: "小于等于"
  }
]);
const typeOps = reactive([
  {
    value: "all",
    label: "全部"
  },
  {
    value: "好评",
    label: "好评"
  },
  {
    value: "中评",
    label: "中评"
  },
  {
    value: "差评",
    label: "差评"
  }
]);

async function queryCommList() {
  data.value = await queryAllComment(formData);
}

async function deleteComment(id: number, index: number) {
  await deleteOneComment(id);
  data.value.splice(index, 1);
}
</script>

<template>
  <el-form :model="formData" ref="formEl" label-width="120px" label-position="left">
    <FormTitle title="基本筛选条件" sub-title="通过书籍ID或评论类型筛选"></FormTitle>
    <div class="f-c-s">
      <el-form-item label="评论类型" prop="buchType">
        <el-select v-model="formData.type" placeholder="选择一个评论类型">
          <el-option v-for="item in typeOps" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item class="ml-10" v-show="formData.type != 'all'" label="书籍ID" prop="buchId">
        <el-input v-model="formData.id" placeholder="输入查询评论的书籍ID" />
      </el-form-item>
    </div>
    <FormTitle title="点赞数筛选" sub-title="通过点赞数量筛选"></FormTitle>
    <div class="f-c-s">
      <el-form-item label="操作符" prop="diggOp">
        <el-select v-model="formData.diggOp" placeholder="选择一个评论类型">
          <el-option v-for="item in operOps" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item class="ml-10" v-show="formData.diggOp != 'not'" label="点赞数" prop="digg">
        <el-input v-model="formData.digg" placeholder="输入查询评论的书籍ID" />
      </el-form-item>
    </div>
    <FormTitle title="点赞数筛选" sub-title="通过点赞数量筛选"></FormTitle>
    <div class="f-c-s">
      <el-form-item label="操作符" prop="buryOp">
        <el-select v-model="formData.buryOp" placeholder="选择一个评论类型">
          <el-option v-for="item in operOps" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item class="ml-10" v-show="formData.buryOp != 'not'" label="反对数" prop="bury">
        <el-input v-model="formData.bury" placeholder="输入查询评论的书籍ID" />
      </el-form-item>
    </div>
  </el-form>
  <div class="f-c-e">
    <el-button plain type="primary" @click="queryCommList">点击查询</el-button>
  </div>
  <div class="mt-10">
    <FormTitle title="筛选结果" sub-title="通过以上条件查询过后的结果"></FormTitle>
    <el-table :data="data">
      <el-table-column label="头像" v-slot="{ row: { user } }">
        <img :src="user.profilePhoto" class="w-10 h-10 rd-50" />
      </el-table-column>
      <el-table-column v-slot="{ row: { user } }" label="评论用户">
        {{ user.username }}
      </el-table-column>
      <el-table-column prop="content" label="评论内容" show-overflow-tooltip></el-table-column>
      <el-table-column sortable v-slot="{ row }" label="反对数">
        <el-tag type="danger">
          {{ row.bury }}
        </el-tag>
      </el-table-column>
      <el-table-column sortable v-slot="{ row }" label="赞成数">
        <el-tag type="success">{{ row.digg }}</el-tag>
      </el-table-column>
      <el-table-column sortable prop="type" label="评论类型"></el-table-column>
      <el-table-column sortable prop="postDate" label="评论日期" width="200"></el-table-column>
      <el-table-column v-slot="scope" label="更多">
        <el-popconfirm title="确定要删除这条评论？" @confirm="deleteComment(scope.row.id, scope.$index)">
          <template #reference>
            <el-button size="small" type="danger">删除</el-button>
          </template>
        </el-popconfirm>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped lang="scss"></style>
