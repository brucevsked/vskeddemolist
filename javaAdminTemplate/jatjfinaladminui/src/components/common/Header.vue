<template>
    <div class="header">
        <!-- 折叠按钮 -->
        <div class="collapse-btn" @click="collapseChage">
            <i v-if="!collapse" class="el-icon-s-fold"></i>
            <i v-else class="el-icon-s-unfold"></i>
        </div>
        <div class="logo">后台管理系统</div>
        <div class="header-right">
            <div class="header-user-con">
                <!-- 全屏显示 -->
                <div class="btn-fullscreen" @click="handleFullScreen">
                    <el-tooltip effect="dark" :content="fullscreen?`取消全屏`:`全屏`" placement="bottom">
                        <i class="el-icon-rank"></i>
                    </el-tooltip>
                </div>
                <!-- 消息中心 
                <div class="btn-bell">
                    <el-tooltip effect="dark" :content="message?`有${message}条未读消息`:`消息中心`" placement="bottom">
                        <router-link to="/tabs">
                            <i class="el-icon-bell"></i>
                        </router-link>
                    </el-tooltip>
                    <span class="btn-bell-badge" v-if="message"></span>
                </div>
                -->
                <!-- 用户头像 
                <div class="user-avator">
                    <img src="../../assets/img/img.jpg" />
                </div>
                -->


                <!-- 用户名下拉菜单 -->
                <el-dropdown class="user-name" trigger="click" @command="handleCommand">
                    <span class="el-dropdown-link">
                        {{name}}
                        <i class="el-icon-caret-bottom"></i>
                    </span>
                    <el-dropdown-menu slot="dropdown">
                        <el-dropdown-item divided command="changepwd">修改密码</el-dropdown-item>
                        <el-dropdown-item divided command="loginout">
                            <i class="el-icon-lx-exit"></i>
                            注销
                        </el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>
            </div>
        </div>

        <!-- 编辑弹出框 -->
        <el-dialog title="修改密码" :visible.sync="editVisible" width="30%">
            <el-form ref="passwdForm" :model="passwd" :rules="rules" size="default">
                <el-form-item prop="oldVal" label="旧密码">
                    <el-input v-model.trim="passwd.oldVal" ref="oldVal" type="password" show-password
                        placeholder="请输入旧密码">
                    </el-input>
                </el-form-item>
                <el-form-item prop="newVal" label="新密码">
                    <el-input v-model.trim="passwd.newVal" type="password" show-password
                        placeholder="请输入包含英文字母大小写、数字和特殊符号的 8-16 位组合"></el-input>
                </el-form-item>
                <el-form-item prop="repeatNewVal" label="重复密码">
                    <el-input v-model.trim="passwd.repeatNewVal" type="password" show-password placeholder="请重复密码">
                    </el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="$refs['passwdForm'].resetFields()">清空</el-button>
                <el-button type="primary" @click="savePwd">确 定</el-button>
            </span>
        </el-dialog>

    </div>
</template>
<script>
    import bus from '../common/bus'; //导入变量
    import { User } from '../../api/user'; //导入方法
    export default {

        data() {

            //新密码与重复密码不一致，一定写在data里但不是return里
            let repeatValidate = (rule, value, callback) => {
                if (value !== this.passwd.newVal) {
                    callback(new Error('两次输入密码不一致!'))
                } else {
                    callback()
                }
            }
            //正则校验主要是这部分：/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[._~!@#$^&*])[A-Za-z0-9._~!@#$^&*]{8,16}$
            //其中特殊字符包括：._~!@#$^&*  （比较常见）
            let newValValidate = (rule, value, callback) => {
                if (value === this.passwd.oldVal) {
                    callback(new Error('新密码不能与旧密码一致'))
                } else if (/^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[._~!@#$^&*])[A-Za-z0-9._~!@#$^&*]{8,16}$/g.test(
                        value)) {
                    callback()
                } else {
                    callback(new Error('请输入包含英文字母大小写、数字和特殊符号的 8-16 位组合'))
                }
            }

            return {
                user:new User(),
                collapse: false,
                fullscreen: false,
                name: 'test',
                form: {},
                passwd: {
                    oldVal: '',
                    newVal: '',
                    repeatNewVal: ''
                },
                showPasswdChange: false,
                rules: {
                    oldVal: [{
                        required: true,
                        message: '请输入旧密码',
                        trigger: 'blur'
                    }],
                    newVal: [{
                            required: true,
                            message: '新密码不能为空',
                            trigger: 'blur'
                        },
                        {
                            min: 8,
                            max: 16,
                            message: '长度应在 8 到 16 个字符',
                            trigger: 'blur'
                        },
                        {
                            validator: newValValidate,
                            trigger: 'blur'
                        }
                    ],
                    repeatNewVal: [{
                            required: true,
                            message: '请再输入一遍新密码',
                            trigger: 'blur'
                        },
                        {
                            validator: repeatValidate,
                            trigger: 'blur'
                        }
                    ]
                },
                editVisible: false,
                message: 2
            };
        },
        computed: {

        },
        watch: {
            'name': {
                handler(nv) {
                    // let token = localStorage.getItem("token");
                    // info(token).then(res => {
                    //     if (res.code == 0) {
                    //         this.name = res.data.name;
                    //     }
                    // });
                },
                immediate: true

            }
        },
        methods: {
            // 用户名下拉菜单选择事件
            handleCommand(command) {
                if (command == 'loginout') {
                    this.user.logout().then(res => {
                        if (res.code == 0) {
                            localStorage.removeItem('token');
                            this.$router.push('/login');
                        }
                    });
                }

                if (command == 'changepwd') {
                    this.editVisible = true;
                    this.$refs['passwdForm'].resetFields();
                }
            },
            // 侧边栏折叠
            collapseChage() {
                this.collapse = !this.collapse;
                bus.$emit('collapse', this.collapse);
            },
            // 全屏事件
            handleFullScreen() {
                let element = document.documentElement;
                if (this.fullscreen) {
                    if (document.exitFullscreen) {
                        document.exitFullscreen();
                    } else if (document.webkitCancelFullScreen) {
                        document.webkitCancelFullScreen();
                    } else if (document.mozCancelFullScreen) {
                        document.mozCancelFullScreen();
                    } else if (document.msExitFullscreen) {
                        document.msExitFullscreen();
                    }
                } else {
                    if (element.requestFullscreen) {
                        element.requestFullscreen();
                    } else if (element.webkitRequestFullScreen) {
                        element.webkitRequestFullScreen();
                    } else if (element.mozRequestFullScreen) {
                        element.mozRequestFullScreen();
                    } else if (element.msRequestFullscreen) {
                        // IE11
                        element.msRequestFullscreen();
                    }
                }
                this.fullscreen = !this.fullscreen;
            },
            // 保存修改密码
            savePwd() {
                this.$refs.passwdForm.validate(valid => {
                    if (!valid) {
                        this.$message.error('输入的密码规则验证失败!');
                        console.log('error validate password !!');
                        return false;
                    }

                    this.user.changepwd(this.passwd).then(res => {
                        //console.log(res);
                        if (res.code != 0) {
                            this.$message.error(res.msg);
                        } else {
                            this.$message.success(`修改密码成功`);
                        }

                    });
                    this.editVisible = false;
                });

            },
        },
        mounted() {
            if (document.body.clientWidth < 1500) {
                this.collapseChage();
            }

            let token = localStorage.getItem("token");
            this.user.info(token).then(res => {
                if (res.code == 0) {
                    this.name = res.data.name;
                }
            });
        }
    };
</script>
<style scoped>
    .header {
        position: relative;
        box-sizing: border-box;
        width: 100%;
        height: 70px;
        font-size: 22px;
        color: #fff;
    }

    .collapse-btn {
        float: left;
        padding: 0 21px;
        cursor: pointer;
        line-height: 70px;
    }

    .header .logo {
        float: left;
        width: 250px;
        line-height: 70px;
    }

    .header-right {
        float: right;
        padding-right: 50px;
    }

    .header-user-con {
        display: flex;
        height: 70px;
        align-items: center;
    }

    .btn-fullscreen {
        transform: rotate(45deg);
        margin-right: 5px;
        font-size: 24px;
    }

    .btn-bell,
    .btn-fullscreen {
        position: relative;
        width: 30px;
        height: 30px;
        text-align: center;
        border-radius: 15px;
        cursor: pointer;
    }

    .btn-bell-badge {
        position: absolute;
        right: 0;
        top: -2px;
        width: 8px;
        height: 8px;
        border-radius: 4px;
        background: #f56c6c;
        color: #fff;
    }

    .btn-bell .el-icon-bell {
        color: #fff;
    }

    .user-name {
        margin-left: 10px;
    }

    .user-avator {
        margin-left: 20px;
    }

    .user-avator img {
        display: block;
        width: 40px;
        height: 40px;
        border-radius: 50%;
    }

    .el-dropdown-link {
        color: #fff;
        cursor: pointer;
    }

    .el-dropdown-menu__item {
        text-align: center;
    }
</style>
