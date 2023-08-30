<script setup lang="ts">
import { CommentApi } from "@/apis/api-comment";

const commList = shallowRef();
const operOps = ref([
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
const typeOps = ref([
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
const formData = ref({
  buchId: 0,
  buchType: "all",
  digg: 0,
  bury: 0,
  diggOp: "not",
  buryOp: "not"
});

async function queryCommList() {
  commList.value = await CommentApi.query(formData.value);
}

function deleComm(id: number, index: number) {
  CommentApi.delComm({ id }).then(() => {
    commList.value = commList.value.toSpliced(index, 1);
  });
}
</script>

<template>
  <el-form :model="formData" ref="formEl" label-width="120px" label-position="left">
    <div mb-5><span font-bold mr-2>基本筛选条件</span><span class="size-13px text-gray-5">通过书籍ID或评论类型筛选</span></div>
    <div f-c-s>
      <el-form-item label="评论类型" prop="buchType">
        <el-select v-model="formData.buchType" placeholder="选择一个评论类型">
          <el-option v-for="item in typeOps" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item v-show="formData.buchType != 'all'" mr-10 label="书籍ID" prop="buchId">
        <el-input v-model="formData.buchId" placeholder="输入查询评论的书籍ID" />
      </el-form-item>
    </div>
    <div mb-5><span font-bold mr-2>通过点赞数筛选</span><span class="size-13px text-gray-5">通过点赞数量筛选</span></div>
    <div f-c-s>
      <el-form-item label="操作符" prop="diggOp">
        <el-select v-model="formData.diggOp" placeholder="选择一个评论类型">
          <el-option v-for="item in operOps" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item v-show="formData.diggOp != 'not'" mr-10 label="点赞数" prop="digg">
        <el-input v-model="formData.digg" placeholder="输入查询评论的书籍ID" />
      </el-form-item>
    </div>
    <div mb-5><span font-bold mr-2>通过反对数筛选</span><span class="size-13px text-gray-5">通过点赞数量筛选</span></div>
    <div f-c-s>
      <el-form-item label="操作符" prop="buryOp">
        <el-select v-model="formData.buryOp" placeholder="选择一个评论类型">
          <el-option v-for="item in operOps" :label="item.label" :value="item.value" />
        </el-select>
      </el-form-item>
      <el-form-item v-show="formData.buryOp != 'not'" mr-10 label="反对数" prop="bury">
        <el-input v-model="formData.bury" placeholder="输入查询评论的书籍ID" />
      </el-form-item>
    </div>
  </el-form>
  <div f-c-e>
    <el-button plain type="primary" @click="queryCommList">点击查询</el-button>
  </div>
  <div mt-10>
    <el-table :data="commList">
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
        <el-popconfirm title="确定要删除这条评论？" @confirm="deleComm(scope.row.id, scope.$index)">
          <template #reference>
            <el-button size="small" type="danger">删除</el-button>
          </template>
        </el-popconfirm>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped lang="scss"></style>
