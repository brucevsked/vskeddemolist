import request from '../utils/request'

export class Role {

    //获取角色菜单
    getRoleMenu() {
        return request({
            url: '/manager/role/roleMenu',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            }
        });
    }
    
    //查询所有
    findAllRole() {
        return request({
            url: '/manager/role/findAllRole',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            }
        });
    }
    
    //根据id查询
    findById(form) {
        return request({
            url: '/manager/role/findById',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            },
            params: form
        });
    }

    //获取选中角色资源
    getRoleResource(form) {
        return request({
            url: '/manager/role/getRoleResource',
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
            url: '/manager/role/list',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            },
            params: query
        });
    }


    //添加
    add(form) {
        form = this.roleForm(form); //处理不填写字段值时默认值
        return request({
            url: '/manager/role/add',
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
            url: '/manager/role/del',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            },
            data: form
        });
    }

    //修改
    edit(form) {
        form = this.roleForm(form); //处理不填写字段值时默认值
        return request({
            url: '/manager/role/edit',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            },
            data: form
        });
    }

    //处理不填写字段值时默认值
    roleForm(form) {
        if (form.name == undefined) {
            form.name = "";
        }

        if (form.descript == undefined) {
            form.descript = "";
        }
        
        if (form.menuIds == undefined) {
            form.menuIds = [];
        }

        return form;
    }

}