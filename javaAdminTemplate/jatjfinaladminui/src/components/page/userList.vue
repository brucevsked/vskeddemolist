<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-people"></i> 用户
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-input v-model="query.name" placeholder="昵称" class="handle-input mr10"></el-input>
                <el-input v-model="query.accountName" placeholder="账号" class="handle-input mr10"></el-input>
                <el-input v-model="query.phone" placeholder="手机号" class="handle-input mr10"></el-input>
                <el-button type="primary" icon="el-icon-search" @click="handleSearch">搜索</el-button>
                <el-button type="primary" icon="el-icon-lx-add" @click="handleAdd">添加</el-button>
            </div>
            <el-table :data="tableData" border class="table" ref="multipleTable" header-cell-class-name="table-header"
                @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="id" label="ID" width="55" align="center"></el-table-column>
                <el-table-column prop="name" label="昵称"></el-table-column>
                <el-table-column prop="accountname" label="账号"></el-table-column>
                <el-table-column label="手机号">
                    <template slot-scope="scope">{{scope.row.phone}}</template>
                </el-table-column>
                <el-table-column prop="rolename" label="角色"></el-table-column>

                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <el-button type="text" icon="el-icon-lx-cascades"
                            @click="handlePwd(scope.$index, scope.row)">重置密码
                        </el-button>
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
                <el-form-item label="账号" prop="accountName" ref="addAccountName">
                    <el-input v-model="form.accountName"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="accountPass">
                    <el-input v-model="form.accountPass"></el-input>
                </el-form-item>
                <el-form-item label="昵称" prop="name">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="手机" prop="phone">
                    <el-input v-model="form.phone"></el-input>
                </el-form-item>
                <el-form-item label="角色" prop="roleIds">
                    <el-checkbox v-for="(item,index) in roleList" :key="item.id" :label="item.id"
                        v-model="form.roleIds">{{item.name}}</el-checkbox>
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
                <el-form-item label="昵称" prop="name">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
                <el-form-item label="手机" prop="phone">
                    <el-input v-model="form.phone"></el-input>
                </el-form-item>
                <el-form-item label="角色" prop="roleIds">
                    <el-checkbox :ref="'rck'+item.id" v-for="(item,index) in roleList" :key="item.id" :label="item.id"
                        v-model="form.roleIds">{{item.name}}</el-checkbox>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>

        <!-- 重置密码弹出框 -->
        <el-dialog title="重置密码" :visible.sync="resetPwdVisible" width="30%">
            <el-form ref="resetPwdForm" :model="form" label-width="70px">
                <!-- 隐藏域id -->
                <el-input v-model="form.id" v-show="false"></el-input>
                <el-form-item label="新密码" prop="accountPass">
                    <el-input v-model="form.accountPass"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="resetPwdVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveResetPwd">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
    import { User } from '../../api/user';
    import { Role } from '../../api/role';
    export default {
        name: 'userList',
        data() {
            return {
                user: new User(),
                role: new Role(),
                query: {
                    name: '',
                    accountName: '',
                    phone: '',
                    pageIndex: 1,
                    pageSize: 10
                },
                tableData: [],
                multipleSelection: [],
                delList: [],
                roleList: [], //所有角色
                editVisible: false,
                addVisible: false,
                resetPwdVisible: false,
                pageTotal: 0,
                form: {
                    roleIds: [] //角色编号
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
                this.user.fetchData(this.query).then((res) => {
                    //console.log(res);
                    if (res.code == 0) {
                        this.tableData = res.data.list;
                        this.pageTotal = res.data.pageTotal || 50;
                    } else {
                        this.$message.error(res.msg);
                    }

                });
            },
            getRoleList() {
                this.role.findAllRole().then((res) => {
                    if (res.code == 0) {
                        this.roleList = res.data;
                    } else {
                        this.$message.error(res.msg);
                    }

                });
            },
            getUserRoleList(form) {
                setTimeout(() => {
                    this.user.findUserRole(form).then((res) => {
                        if (res.code == 0) {
                            var tmpArray = new Array();
                            for (var i = 0; i < res.data.length; i++) {
                                tmpArray.push(res.data[i].id);
                            }
                            this.$set(this.form, 'roleIds', tmpArray);
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
                        this.user.del(this.form).then((res) => {
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
            // 多选操作
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            delAllSelection() {
                const length = this.multipleSelection.length;
                let str = '';
                this.delList = this.delList.concat(this.multipleSelection);
                for (let i = 0; i < length; i++) {
                    str += this.multipleSelection[i].name + ' ';
                }
                this.$message.error(`删除了${str}`);
                this.multipleSelection = [];
            },
            //添加操作
            handleAdd() {
                this.addVisible = true;
                this.$set(this.form, 'id', null);
                this.$set(this.form, 'accountName', null);
                this.$set(this.form, 'accountPass', null);
                this.$set(this.form, 'name', null);
                this.$set(this.form, 'phone', null);
                this.$set(this.form, 'roleIds', new Array());

                this.getRoleList();
                this.$nextTick(() => {
                    this.$refs.addAccountName.focus(); //取焦点
                });

            },
            // 编辑操作
            handleEdit(index, row) {
                this.editVisible = true;

                this.user.findById(row).then((res) => {
                    if (res.code == 0) {
                        this.$set(this.form, 'id', res.data.id);
                        this.$set(this.form, 'name', res.data.name);
                        this.$set(this.form, 'phone', res.data.phone);
                    } else {
                        this.$message.error(res.msg);
                    }

                });

                this.getRoleList();
                this.getUserRoleList(this.form);
            },
            //重置用户密码
            handlePwd(index, row) {
                this.resetPwdVisible = true;
                this.$set(this.form, 'id', row.id);
            },
            // 保存添加
            saveAdd() {
                this.addVisible = false;
                // console.log(this.form);

                this.user.add(this.form).then((res) => {
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
                this.user.edit(this.form).then((res) => {
                    //console.log(res);
                    if (res.code == 0) {
                        this.$message.success('修改成功');
                        this.getData();
                    } else {
                        this.$message.error(res.msg);
                    }

                });

            },
            // 保存编辑
            saveResetPwd() {
                this.resetPwdVisible = false;
                this.user.resetUserPwd(this.form).then((res) => {
                    //console.log(res);
                    if (res.code == 0) {
                        this.$message.success('重置密码成功');
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