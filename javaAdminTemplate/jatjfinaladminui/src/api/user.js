import request from '../utils/request'

export class User {

    // 登录
    login(userName, password) {
        const data = {
            userName,
            password
        };
        return request({
            url: '/manager/user/login',
            method: 'post',
            data: data
        });
    }

    // 注销
    logout() {
        return request({
            url: '/manager/user/logout',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            }
        });
    }

    //用户信息
    info(token) {
        return request({
            url: '/manager/user/info',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            }
        });
    }
    
    //根据id查询
    findById(form) {
        return request({
            url: '/manager/user/findById',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            },
            params: form
        });
    }

    //查询用户角色
    findUserRole(form) {
        return request({
            url: '/manager/user/findUserRole',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            },
            params: form
        });
    }

    //列表
    fetchData(query) {
        return request({
            url: '/manager/user/list',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            },
            params: query
        });
    }

    //添加
    add(form) {
        form = this.userForm(form); //处理不填写字段值时默认值
        return request({
            url: '/manager/user/add',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            },
            data: form
        });
    }

    //删除
    del(form) {
        return request({
            url: '/manager/user/del',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            },
            data: form
        });
    }

    //编辑
    edit(form) {
        form = this.userForm(form); //处理不填写字段值时默认值
        return request({
            url: '/manager/user/edit',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            },
            data: form
        });
    }

    //重置密码
    resetUserPwd(form) {
        form = this.userForm(form); //处理不填写字段值时默认值
        return request({
            url: '/manager/user/resetUserPwd',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            },
            data: form
        });
    }

    //修改密码
    changepwd(form) {
        return request({
            url: '/manager/user/changepwd',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            },
            data: form
        });
    }

    //处理不填写字段值时默认值
    userForm(form) {
        if (form.name == undefined) {
            form.name = "";
        }

        if (form.accountName == undefined) {
            form.accountName = "";
        }
        if (form.accountPass == undefined) {
            form.accountPass = "";
        }

        return form;
    }

}