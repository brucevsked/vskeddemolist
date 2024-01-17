<template>
    <div class="sidebar">
        <el-menu
            class="sidebar-el-menu"
            :default-active="onRoutes"
            :collapse="collapse"
            background-color="#324157"
            text-color="#bfcbd9"
            active-text-color="#20a0ff"
            unique-opened
            router
        >
            <template v-for="item in items">
                <template v-if="item.subs">
                    <el-submenu :index="item.index" :key="item.index">
                        <template slot="title">
                            <i :class="item.icon"></i>
                            <span slot="title">{{ item.title }}</span>
                        </template>
                        <template v-for="subItem in item.subs">
                            <el-submenu
                                v-if="subItem.subs"
                                :index="subItem.index"
                                :key="subItem.index"
                            >
                                <template slot="title">
                            <i :class="subItem.icon"></i>
                            <span slot="title">{{ subItem.title }}</span>
                                </template>
                                <el-menu-item
                                    v-for="(threeItem,i) in subItem.subs"
                                    :key="i"
                                    :index="threeItem.index"
                                >
                            <i :class="threeItem.icon"></i>
                            <span slot="title">{{ threeItem.title }}</span>
                                </el-menu-item>
                            </el-submenu>
                            <el-menu-item
                                v-else
                                :index="subItem.index"
                                :key="subItem.index"
                            >
                            <i :class="subItem.icon"></i>
                            <span slot="title">{{ subItem.title }}</span>
                            </el-menu-item>
                        </template>
                    </el-submenu>
                </template>
                <template v-else>
                    <el-menu-item :index="item.index" :key="item.index">
                        <i :class="item.icon"></i>
                        <span slot="title">{{ item.title }}</span>
                    </el-menu-item>
                </template>
            </template>
        </el-menu>
    </div>
</template>

<script>
import bus from '../common/bus';
import { Role } from '../../api/role'
export default {
    data() {
        return {
            role:new Role(),
            collapse: false,
            items: [ ]
        };
    },
    computed: {
        onRoutes() {
            return this.$route.path.replace('/', '');
        }
    },
    mounted() {
        this.loadRoleMenus();        
    },
    methods: {
        loadRoleMenus(){
            let token=localStorage.getItem("token");
            this.role.getRoleMenu(token).then(res=>{
                if(res.code==0){                    
                    this.items=res.data;
                    //console.log(this.items)
                }
            });
        }
    },
    // watch:{
    //     'items':{
    //         handler(nv){
    //             //var that=this;
    //             let token=localStorage.getItem("token");
    //             getRoleMenu(token).then(res=>{
    //                 if(res.code==0){
    //                     console.log(res)
    //                     this.items=res.data;
    //                 }
    //             });
    //         },
    //         immediate:false,//在选项参数中指定 immediate: true, 将立即以表达式的当前值触发回调，也就是立即触发一次
    //         deep:true //在选项参数中指定 deep: true，可以监听对象中属性的变化，也就是深度监听。

    //     }
    // },
    created() {
        // 通过 Event Bus 进行组件间通信，来折叠侧边栏
        bus.$on('collapse', msg => {
            this.collapse = msg;
            bus.$emit('collapse-content', msg);
        });
    }
};
</script>

<style scoped>
.sidebar {
    display: block;
    position: absolute;
    left: 0;
    top: 70px;
    bottom: 0;
    overflow-y: scroll;
}
.sidebar::-webkit-scrollbar {
    width: 0;
}
.sidebar-el-menu:not(.el-menu--collapse) {
    width: 250px;
}
.sidebar > ul {
    height: 100%;
}
</style>
