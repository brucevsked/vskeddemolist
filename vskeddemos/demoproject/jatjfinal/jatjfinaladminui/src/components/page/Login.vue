<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">后台管理系统</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="userName">
                    <el-input v-model="param.userName" placeholder="userName" ref="userName">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input
                        type="password"
                        placeholder="password"
                        v-model="param.password"
                        @keyup.enter.native="submitForm()"
                    >
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm()">登录</el-button>
                </div>
                <p class="login-tips">Tips : 请填写正确的账号和密码。</p>
            </el-form>
        </div>
    </div>
</template>

<script>
import { User } from '../../api/user'
export default {
    data(){
        return {
            user:new User(),
            param: {
                userName: 'admin',
                password: '123456',
            },
            rules: {
                userName: [{ required: true, message: '请输入账号', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
            }            
        };
    },
    methods: {
        submitForm() {
            this.$refs.login.validate(valid => {
                if(valid){
                    this.user.login(this.param.userName,this.param.password).then((res)=>{
                        if(res.code!=0){
                            this.$message.error(res.msg);
                        }else{
                            this.$message.success('登录成功');
                            localStorage.setItem('token', res.data.token);
                            this.$router.push('/');
                        }
                    });
                }else{
                    this.$message.error('请输入账号和密码');
                    console.log('error submit!!');
                    return false;
                }
            });
        },
    },
    mounted() {
        this.$refs.userName.focus();//账号取焦点        
        
        var token=localStorage.getItem("token");
        if(token!=null){
            //this.$router.push('/');
        }
    }
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../../assets/img/login-bg.jpg);
    background-size: 100%;
}
.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #000;
    border-bottom: 1px solid #ddd;
}
.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}
.ms-content {
    padding: 30px 30px;
}
.login-btn {
    text-align: center;
}
.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}
.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #000;
}
</style>