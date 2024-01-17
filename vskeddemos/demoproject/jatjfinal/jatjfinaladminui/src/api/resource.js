import request from '../utils/request'

export class Resource {

    //获取所有菜单
    getAllMenus() {
        return request({
            url: '/manager/resource/allMenus',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            }
        });
    }

    //分页列表
    fetchData(query) {
        return request({
            url: '/manager/resource/list',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            },
            params: query
        });
    }

    //查询所有
    findAll() {
        return request({
            url: '/manager/resource/findAll',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            }
        });
    }

    //根据id查询
    findById(form) {
        return request({
            url: '/manager/resource/findById',
            method: 'get',
            headers: {
                token: localStorage.getItem('token')
            },
            params: form
        });
    }

    //添加
    add(form) {
        form = this.resourceForm(form); //处理不填写字段值时默认值
        return request({
            url: '/manager/resource/add',
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
            url: '/manager/resource/del',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            },
            data: form
        });
    }

    //修改
    edit(form) {
        form = this.resourceForm(form); //处理不填写字段值时默认值
        return request({
            url: '/manager/resource/edit',
            method: 'post',
            headers: {
                token: localStorage.getItem('token')
            },
            data: form
        });
    }

    //处理不填写字段值时默认值
    resourceForm(form) {
        if (form.parentId == undefined) {
            form.parentId = "-1";
        }

        if (form.name == undefined) {
            form.name = "";
        }
        
        if (form.url == undefined) {
            form.url = "";
        }
        
        if (form.ico == undefined) {
            form.ico = "";
        }

        if (form.sequence == undefined) {
            form.sequence = "0";
        }
        
        return form;
    }

}