<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-present"></i> 菜单
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">

            <div class="handle-box">
                <el-input v-model="query.name" placeholder="菜单名" class="handle-input mr10"></el-input>
                <el-input v-model="query.url" placeholder="链接" class="handle-input mr10"></el-input>
                <el-input v-model="query.parentName" placeholder="上级菜单名" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button type="primary" icon="el-icon-lx-add" @click="handleAdd">添加</el-button>
            </div>
            <el-table :data="tableData" border class="table" ref="multipleTable" header-cell-class-name="table-header">
                <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
                <el-table-column prop="name" label="菜单名"></el-table-column>
                <el-table-column label="菜单链接">
                    <template slot-scope="scope">{{scope.row.url}}</template>
                </el-table-column>
                <el-table-column label="图标">
                    <template slot-scope="scope">
                        <i :class="scope.row.icon"></i>
                    </template>
                </el-table-column>
                <el-table-column label="类型">
                    <template slot-scope="scope">
                        <span v-if="scope.row.type=='0'">目录</span>
                        <span v-else-if="scope.row.type=='1'">菜单</span>
                        <span v-else-if="scope.row.type=='2'">按钮</span>
                        <span v-else>无</span>
                    </template>

                </el-table-column>
                <el-table-column prop="sequence" label="排序"></el-table-column>
                <el-table-column prop="parentName" label="上级菜单名"></el-table-column>

                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button type="text" icon="el-icon-edit" @click="handleEdit(scope.$index, scope.row)">编辑
                        </el-button>
                        <el-button type="text" icon="el-icon-delete" class="red"
                            @click="handleDelete(scope.$index, scope.row)">删除</el-button>
                    </template>
                </el-table-column>

            </el-table>
            <div class="pagination">
                <el-pagination background layout="total, prev, pager, next" :current-page="query.pageIndex"
                    :page-size="query.pageSize" :total="pageTotal" @current-change="handlePageChange"></el-pagination>
            </div>
        </div>

        <!-- 添加弹出框 -->
        <el-dialog title="添加" :visible.sync="addVisible" width="30%">
            <el-form ref="addForm" :model="form" label-width="70px">
                <el-form-item label="上级菜单" prop="parentId">
                    <el-select v-model="form.parentId" placeholder="请选择">
                        <el-option key="-1" label="无" value="-1"></el-option>
                        <el-option v-for=" item in parentMenus" :key="item.id" :label="item.name" :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="名称" prop="name">
                    <el-input v-model="form.name" ref="addName"></el-input>
                </el-form-item>
                <el-form-item label="链接" prop="url">
                    <el-input v-model="form.url"></el-input>
                </el-form-item>
                <el-form-item label="图标" prop="icon">
                    <el-input v-model="form.icon"></el-input>
                </el-form-item>
                <el-form-item label="类型" prop="type">
                    <el-radio v-model="form.type" label="0">目录</el-radio>
                    <el-radio v-model="form.type" label="1">菜单</el-radio>
                    <el-radio v-model="form.type" label="2">按钮</el-radio>
                </el-form-item>
                <el-form-item label="排序" prop="sequence">
                    <el-input v-model="form.sequence" type="number"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="addVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveAdd">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 编辑弹出框 -->
        <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="editForm" :model="form" label-width="70px">
                <!-- 隐藏域id -->
                <el-input v-model="form.id" v-show="false"></el-input>

                <el-form-item label="上级菜单" prop="parentId">
                    <el-select v-model="form.parentId" placeholder="请选择" @change="changeParentId($event)">
                        <el-option key="-1" label="无" value="-1"></el-option>
                        <el-option v-for=" item in parentMenus" :key="item.id" :label="item.name" :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="名称" prop="name">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="链接" prop="url">
                    <el-input v-model="form.url"></el-input>
                </el-form-item>
                <el-form-item label="图标" prop="icon">
                    <el-input v-model="form.icon"></el-input>
                </el-form-item>
                <el-form-item label="类型" prop="type">
                    <el-radio v-model="form.type" label="0">目录</el-radio>
                    <el-radio v-model="form.type" label="1">菜单</el-radio>
                    <el-radio v-model="form.type" label="2">按钮</el-radio>
                </el-form-item>
                <el-form-item label="排序" prop="sequence">
                    <el-input v-model="form.sequence" type="number"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>

<script>
    import { Resource } from '../../api/resource';
    export default {
        name: 'resourceList',
        data() {
            return {
                resource: new Resource(),
                query: {
                    name: '',
                    url: '',
                    pageIndex: 1,
                    pageSize: 10
                },
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                addVisible: false,
                pageTotal: 0,
                form: {
                    type: '0' //单选默认值
                },
                parentMenus: [], //上级菜单列表
                idx: -1,
                id: -1
            };
        },
        created() {
            this.getData();
        },
        methods: {
            getData() {
                this.resource.fetchData(this.query).then((res) => {
                    //console.log(res);
                    if (res.code == 0) {
                        this.tableData = res.data.list;
                        this.pageTotal = res.data.pageTotal || 50;
                    } else {
                        this.$message.error(res.msg);
                    }

                });
            },
            parentMenuList() {
                this.resource.findAll().then((res) => {
                    if (res.code == 0) {
                        this.parentMenus = res.data;
                    } else {
                        this.$message.error(res.msg);
                    }

                });
            },
            //下拉变更事件
            changeParentId(id) {
                this.form.parentId = id;
            },
            // 触发搜索按钮
            handleSearch() {
                this.$set(this.query, 'pageIndex', 1);
                this.getData();
            },
            //添加操作
            handleAdd() {
                this.addVisible = true;
                this.$set(this.form, 'id', null);
                this.$set(this.form, 'parentId', '-1');
                this.$set(this.form, 'name', null);
                this.$set(this.form, 'url', null);
                this.$set(this.form, 'icon', null);
                this.$set(this.form, 'type', '0');
                this.$set(this.form, 'sequence', null);
                this.parentMenuList();
                if (this.$refs.addForm !== undefined) {
                    this.$refs.addForm.resetFields();
                }
                this.$nextTick(() => {
                    this.$refs.addName.focus(); //取焦点
                });

            },
            // 编辑操作
            handleEdit(index, row) {
                this.editVisible = true;
                this.parentMenuList();
                this.resource.findById(row).then((res) => {
                    if (res.code == 0) {
                        this.form = res.data;
                    } else {
                        this.$message.error(res.msg);
                    }

                });

            },
            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                this.$confirm('确定要删除吗？', '提示', {
                        type: 'warning'
                    })
                    .then(() => {
                        this.$set(this.form, 'id', row.id);
                        this.resource.del(this.form).then((res) => {
                            //console.log(res);
                            if (res.code == 0) {
                                this.$message.success('删除成功');
                                this.tableData.splice(index, 1);
                                this.getData();
                            } else {
                                this.$message.error(res.msg);
                            }

                        });

                    }).catch((e) => {
                        console.error(e);
                    });
            },
            // 保存添加
            saveAdd() {
                this.addVisible = false;

                this.resource.add(this.form).then((res) => {
                    //console.log(res);
                    if (res.code == 0) {
                        this.$message.success('添加成功');
                        this.getData();
                    } else {
                        this.$message.error(res.msg);
                    }

                });

            },
            // 保存编辑
            saveEdit() {
                this.editVisible = false;

                this.resource.edit(this.form).then((res) => {
                    //console.log(res);
                    if (res.code == 0) {
                        this.$message.success('修改成功');
                        this.getData();
                    } else {
                        this.$message.error(res.msg);
                    }

                });
            },
            // 分页导航
            handlePageChange(val) {
                this.$set(this.query, 'pageIndex', val);
                this.getData();
            }
        }
    };
</script>

<style scoped>
    @import '../../assets/css/list.css';
</style>