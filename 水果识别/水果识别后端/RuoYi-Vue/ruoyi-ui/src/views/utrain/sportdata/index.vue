<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="球馆id" prop="qid">
        <el-input
          v-model="queryParams.qid"
          placeholder="请输入球馆id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="种类 " prop="qkind">
        <el-input
          v-model="queryParams.qkind"
          placeholder="请输入种类 "
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="球馆名称" prop="qname">
        <el-input
          v-model="queryParams.qname"
          placeholder="请输入球馆名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="省" prop="province">
        <el-input
          v-model="queryParams.province"
          placeholder="请输入省"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市" prop="city">
        <el-input
          v-model="queryParams.city"
          placeholder="请输入市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="区 " prop="district">
        <el-input
          v-model="queryParams.district"
          placeholder="请输入区 "
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="路" prop="street">
        <el-input
          v-model="queryParams.street"
          placeholder="请输入路"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="环境 " prop="environ">
        <el-input
          v-model="queryParams.environ"
          placeholder="请输入环境 "
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="实时人数 " prop="pnumber">
        <el-input
          v-model="queryParams.pnumber"
          placeholder="请输入实时人数 "
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预约人数" prop="appointment">
        <el-input
          v-model="queryParams.appointment"
          placeholder="请输入预约人数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="场地数量" prop="qnumber">
        <el-input
          v-model="queryParams.qnumber"
          placeholder="请输入场地数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['utrain:sportdata:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['utrain:sportdata:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['utrain:sportdata:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['utrain:sportdata:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="sportdataList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="球馆id" align="center" prop="qid" />
      <el-table-column label="种类 " align="center" prop="qkind" />
      <el-table-column label="球馆名称" align="center" prop="qname" />
      <el-table-column label="省" align="center" prop="province" />
      <el-table-column label="市" align="center" prop="city" />
      <el-table-column label="区 " align="center" prop="district" />
      <el-table-column label="路" align="center" prop="street" />
      <el-table-column label="环境 " align="center" prop="environ" />
      <el-table-column label="实时人数 " align="center" prop="pnumber" />
      <el-table-column label="球馆图片 " align="center" prop="qimage" width="100">
        <template slot-scope="scope">
          <image-preview :src="scope.row.qimage" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="预约人数" align="center" prop="appointment" />
      <el-table-column label="场地数量" align="center" prop="qnumber" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['utrain:sportdata:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['utrain:sportdata:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改sportdata对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="种类 " prop="qkind">
          <el-input v-model="form.qkind" placeholder="请输入种类 " />
        </el-form-item>
        <el-form-item label="球馆名称" prop="qname">
          <el-input v-model="form.qname" placeholder="请输入球馆名称" />
        </el-form-item>
        <el-form-item label="省" prop="province">
          <el-input v-model="form.province" placeholder="请输入省" />
        </el-form-item>
        <el-form-item label="市" prop="city">
          <el-input v-model="form.city" placeholder="请输入市" />
        </el-form-item>
        <el-form-item label="区 " prop="district">
          <el-input v-model="form.district" placeholder="请输入区 " />
        </el-form-item>
        <el-form-item label="路" prop="street">
          <el-input v-model="form.street" placeholder="请输入路" />
        </el-form-item>
        <el-form-item label="环境 " prop="environ">
          <el-input v-model="form.environ" placeholder="请输入环境 " />
        </el-form-item>
        <el-form-item label="实时人数 " prop="pnumber">
          <el-input v-model="form.pnumber" placeholder="请输入实时人数 " />
        </el-form-item>
        <el-form-item label="球馆图片 ">
          <image-upload v-model="form.qimage"/>
        </el-form-item>
        <el-form-item label="预约人数" prop="appointment">
          <el-input v-model="form.appointment" placeholder="请输入预约人数" />
        </el-form-item>
        <el-form-item label="场地数量" prop="qnumber">
          <el-input v-model="form.qnumber" placeholder="请输入场地数量" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listSportdata, getSportdata, delSportdata, addSportdata, updateSportdata } from "@/api/utrain/sportdata";

export default {
  name: "Sportdata",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // sportdata表格数据
      sportdataList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        qid: null,
        qkind: null,
        qname: null,
        province: null,
        city: null,
        district: null,
        street: null,
        environ: null,
        pnumber: null,
        qimage: null,
        appointment: null,
        qnumber: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        qkind: [
          { required: true, message: "种类 不能为空", trigger: "blur" }
        ],
        qname: [
          { required: true, message: "球馆名称不能为空", trigger: "blur" }
        ],
        province: [
          { required: true, message: "省不能为空", trigger: "blur" }
        ],
        city: [
          { required: true, message: "市不能为空", trigger: "blur" }
        ],
        district: [
          { required: true, message: "区 不能为空", trigger: "blur" }
        ],
        qnumber: [
          { required: true, message: "场地数量不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询sportdata列表 */
    getList() {
      this.loading = true;
      listSportdata(this.queryParams).then(response => {
        this.sportdataList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        qid: null,
        qkind: null,
        qname: null,
        province: null,
        city: null,
        district: null,
        street: null,
        environ: null,
        pnumber: null,
        qimage: null,
        appointment: null,
        qnumber: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.qid)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加sportdata";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const qid = row.qid || this.ids
      getSportdata(qid).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改sportdata";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.qid != null) {
            updateSportdata(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addSportdata(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const qids = row.qid || this.ids;
      this.$modal.confirm('是否确认删除sportdata编号为"' + qids + '"的数据项？').then(function() {
        return delSportdata(qids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('utrain/sportdata/export', {
        ...this.queryParams
      }, `sportdata_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
