<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-group"></i> 角色
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-input v-model="query.name" placeholder="角色名" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button type="primary" icon="el-icon-lx-add" @click="handleAdd">添加</el-button>
            </div>
            <el-table :data="tableData" border class="table" ref="multipleTable" header-cell-class-name="table-header">
                <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
                <el-table-column prop="name" label="角色名"></el-table-column>
                <el-table-column label="角色描述">
                    <template slot-scope="scope">{{scope.row.descript}}</template>
                </el-table-column>

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
                <el-form-item label="名称" prop="name">
                    <el-input v-model="form.name" ref="addName"></el-input>
                </el-form-item>
                <el-form-item label="描述" prop="descript">
                    <el-input v-model="form.descript"></el-input>
                </el-form-item>
                <el-form-item label="菜单" prop="menuIds">
                    <!-- :data 为要绑定的数据 :props为属性映射 node-key节点唯一标识 show-checkbox显示复选框 check-strictly取消父子关联 @check-change选中状态被改变后事件   -->
                    <el-tree ref="addTree" :data="parentMenus" :props="menuProps" node-key="id" v-model="form.menuIds"
                        show-checkbox check-strictly @check-change="addTreeChecked"></el-tree>
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
                <el-form-item label="名称" prop="name">
                    <el-input v-model="form.name" ref="editName"></el-input>
                </el-form-item>
                <el-form-item label="描述" prop="descript">
                    <el-input v-model="form.descript"></el-input>
                </el-form-item>
                <el-form-item label="菜单" prop="menuIds">
                    <!-- :data 为要绑定的数据 :props为属性映射 node-key节点唯一标识 show-checkbox显示复选框 check-strictly取消父子关联 @check-change选中状态被改变后事件   -->
                    <el-tree ref="editTree" :data="parentMenus" :props="menuProps" node-key="id" v-model="form.menuIds"
                        show-checkbox check-strictly></el-tree>
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
    import { Role } from '../../api/role';
    import { Resource } from '../../api/resource.js';
    export default {
        name: 'roleList',
        data() {
            return {
                role: new Role(),
                resource: new Resource(),
                query: {
                    name: '',
                    pageIndex: 1,
                    pageSize: 10
                },
                tableData: [],
                multipleSelection: [],
                delList: [],
                editVisible: false,
                addVisible: false,
                pageTotal: 0,
                form: {},
                parentMenus: [], //菜单列表
                menuProps: { //菜单默认属性
                    label: 'title', //菜单标题
                    children: 'subs' //子菜单标识
                },
                idx: -1,
                id: -1
            };
        },
        created() {
            this.getData();
        },
        methods: {
            getData() {
                this.role.fetchData(this.query).then((res) => {
                    //console.log(res);
                    if (res.code == 0) {
                        this.tableData = res.data.list;
                        this.pageTotal = res.data.pageTotal || 50;
                    } else {
                        this.$message.error(res.msg);
                    }

                });
            },
            // 这个方法仅调试使用
            addTreeChecked() {
                //显示选中的id
                //console.log('selected node',this.$refs.addTree.getCheckedKeys());
            },
            parentMenuList() {
                this.resource.getAllMenus().then((res) => {
                    if (res.code == 0) {
                        this.parentMenus = res.data;
                    } else {
                        this.$message.error(res.msg);
                    }

                });
            },
            fillEditTree(form) {
                setTimeout(() => {
                    this.role.getRoleResource(form).then((res) => {
                        // console.log(res);
                        if (res.code == 0) {
                            for (var i = 0; i < res.data.length; i++) {
                                this.$refs.editTree.setChecked(res.data[i].id, true);
                            }
                        } else {
                            this.$message.error(res.msg);
                        }

                    });
                }, 200);

            },
            // 触发搜索按钮
            handleSearch() {
                this.$set(this.query, 'pageIndex', 1);
                this.getData();
            },
            // 删除操作
            handleDelete(index, row) {
                // 二次确认删除
                this.$confirm('确定要删除吗？', '提示', {
                        type: 'warning'
                    })
                    .then(() => {
                        this.$set(this.form, 'id', row.id);
                        this.role.del(this.form).then((res) => {
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
            //添加操作
            handleAdd() {
                this.addVisible = true;
                this.$set(this.form, 'id', null);
                this.$set(this.form, 'name', null);
                this.$set(this.form, 'descript', null);
                this.parentMenuList();

                this.$nextTick(() => {
                    this.$refs.addName.focus(); //取焦点
                });

            },
            // 编辑操作
            handleEdit(index, row) {
                this.idx = index;
                this.role.findById(row).then((res) => {
                    if (res.code == 0) {
                        this.$set(this.form, 'id', res.data.id);
                        this.$set(this.form, 'name', res.data.name);
                        this.$set(this.form, 'descript', res.data.descript);
                    } else {
                        this.$message.error(res.msg);
                    }

                });
                this.editVisible = true;
                this.parentMenuList();
                this.fillEditTree(this.form);

            },
            // 保存添加
            saveAdd() {
                this.addVisible = false;
                //console.log(this.form)
                //重新绑定下要传的选项
                this.$set(this.form, 'menuIds', this.$refs.editTree.getCheckedKeys());
                this.role.add(this.form).then((res) => {
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
                //重新绑定下要传的选项
                this.$set(this.form, 'menuIds', this.$refs.editTree.getCheckedKeys());
                this.role.edit(this.form).then((res) => {
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