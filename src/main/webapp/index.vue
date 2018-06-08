<template>
    <div>
        <el-dialog :open="openDialog" width="400px" height="330px" title="修改密码" :dialogBtns="editBtn" @onClose="openDialog=false;">
            <el-box>
                <el-form-query style="margin-top:20px">
                    <el-input class="col-xs-12" :isLook='true' split="4:8" width="200px" target="form" v-model="editData.username" title="登录名："></el-input>
                    <el-input class="col-xs-12" back-tag="*" split="4:8" width="200px" target="form" v-model="editData.oldPassword" title="旧密码："></el-input>
                    <el-input class="col-xs-12" back-tag="*" split="4:8" width="200px" target="form" v-model="editData.newPassword" title="新密码："></el-input>
                    <el-input class="col-xs-12" back-tag="*" split="4:8" width="200px" target="form" v-model="editData.newPassword2" title="确认新密码："></el-input>
                </el-form-query>
            </el-box>
        </el-dialog>
        <div class="navbar">
            <div class="navbar-inner">
                <div class="navbar-container">
                    <div class="navbar-header pull-left">
                        <a href="javascript: return 0" class="navbar-brand">
                            <img style="width: 210px;margin-top: 5px;" src="../../static/img/favicon2.png" alt="" />
                        </a>
                    </div>
 
                    <div style="left: 240px;" class="sidebar-collapse" id="sidebar-collapse">
                        <i class="collapse-icon fa fa-bars" @click="collapse = !collapse"></i>
                    </div>
 
                    <div class='user_info' style="position: absolute; sidebar-collapse;left: 280px;color: #FFFFFF; margin-top: 19px; ">
                        <span>欢迎您,</span>
                        <a href="#" @click="onPassword" title="修改密码" style="color: #FFFFFF;">{{name}}！</a>
                    </div>
 
                    <div class="navbar-header pull-right">
                        <div class="navbar-account">
                            <ul class="account-area">
                                <li title="河长一张图" :class="isGis?'active':''">
                                    <a style="cursor: pointer;" @click="goGis">
                                        <div align="center" style="margin-top: 4px; padding-right: 10px;padding-left:10px; color: #FFFFFF;">
                                            <i class="glyphicon glyphicon-map-marker"></i>
                                            <div>河长一张图</div>
                                        </div>
                                    </a>
                                </li>
                                <template v-for="menu in menus2">
                                    <li　@click="SelectMenulevel1=menu;" :class="(currentMenu&&currentMenu.level1.name)==menu.name?'active':''">
                                        <a style="cursor: pointer;">
                                            <div align="center" style="margin-top: 4px; padding-right: 10px;padding-left:10px; color: #FFFFFF;">
                                                <div :class="menu.icon"></div>
                                                <div>{{menu.name}}</div>
                                            </div>
                                        </a>
                                        </li>
                                </template>
 
                                <li>
                                    <a title="退出" href="#" @click="onSignOut">
                                        <img src="static/img/退出.png" style="width:23px;height:23px;margin-top:13px;margin-right: 12px;margin-left:10px;" />
                                    </a>
                                </li>
                            </ul>
 
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <div class="main-container container-fluid">
                <div class="page-container">
                    <div class="page-sidebar" :class="{hide: showNav, 'menu-compact': collapse}" id="sidebar" v-show="!isGis">
                        <ul class="nav sidebar-menu" v-if="currentMenu">
                            <template v-for="menu in currentMenu.level1.list">
                                <li :class="menu.open==true?'open':''">
                                    <a class="menu-dropdown" style="cursor: pointer;" @click="openCurrentMenu(menu);">
                                        <i :class="'menu-icon '+menu.icon"></i>
                                        <span class="menu-text">{{menu.name}}</span>
                                        <i class="menu-expand"></i>
                                        <i v-if="menu.list instanceof Array" class="menu-expand"></i>
                                    </a>
                                    <ul :style="{display:(menu.open?'block':'none')}+' !important;'" class="submenu" v-if="menu.list instanceof Array">
                                        <template v-for="child in menu.list">
                                            <li :style="'display:'+(child.hidden==true?'none;':'block;'+' !important;')" :class="(currentMenu.level3.name==child.name)?'active':''">
                                                <a v-if="child.onClick" @click="child.onClick();">
                                                    <span class="menu-text"> {{child.name}}</span>
                                                </a>
                                                <a v-else :href="'#'+child.url">
                                                    <span class="menu-text"> {{child.name}}</span>
                                                </a>
                                            </li>
                                        </template>
                                    </ul>
                                </li>
                            </template>
                        </ul>
                    </div>
 
                    <div class="page-content">
                        <div class="page-header position-relative" v-show="!isGis">
                            <div class="">
                                <div class="page-breadcrumbs">
                                    <ul class="breadcrumb">
                                        <li>
                                            <i class="fa fa-home"></i>
                                            <a href="/#/homePage/homePage">首页</a>
                                        </li>
                                        <li class="active" v-if="currentMenu&&currentMenu.level3">{{currentMenu.level3.name}}</li>
                                    </ul>
                                </div>
                            </div>
                            <div class="header-buttons">
                                <a @click="showNav = !showNav" class="sidebar-toggler">
                                    <i class="fa fa-arrows-h"></i>
                                </a>
                                <a @click="fullScreen" class="fullscreen" id="fullscreen-toggler">
                                    <i class="glyphicon glyphicon-fullscreen"></i>
                                </a>
                            </div>
                        </div>
                        <div class="page-body">
                            <router-view></router-view>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--GIS弹窗-->
        <el-dialog :open="$currentClickInfo!=null&&$currentClickInfo.clickInfo!=null" :maxmin="false" :width="($currentClickInfo&&$currentClickInfo.clickInfo&&$currentClickInfo.clickInfo.width)?$currentClickInfo.clickInfo.width:'800px'" :height="($currentClickInfo&&$currentClickInfo.clickInfo&&$currentClickInfo.clickInfo.height)?$currentClickInfo.clickInfo.height:'600px'" title="" @onClose="store.commit('update_currentClickInfo',null);">
            <div :is="($currentClickInfo&&$currentClickInfo.clickInfo&&$currentClickInfo.clickInfo.page)?$currentClickInfo.clickInfo.page:null"></div>
        </el-dialog>
    </div>
</template>
 
<script>
    import { delCookie } from "@/js/tool";
    import { getCookie } from "@/js/tool";
    import { loginURL, urlWthite } from "@/js/const";
    import store from "@/vuex/store.js"
    export default {
        data() {
            return {
                store: store,
                openDialog: false,
                editData: {
                    username: null,
                    oldPassword: null,
                    newPassword: null,
                    newPassword2: null
                },
                collapse: false,
                editBtn: [{
                        text: "取消",
                        onClick: () => {
                            this.editData = {
                                oldPassword: null,
                                newPassword: null,
                                newPassword2: null
                            };
                            this.openDialog = false;
                        }
                    },
                    {
                        text: "保存",
                        onClick: () => {
                            this.makeSure();
                        }
                    }
                ],
                showNav: false,
                menus2: [],
                name: '',
                SelectMenulevel1: null,
                lastCurrentMenu: null, //保存最后一次的页面
            }
        },
        computed: {
            isGis: function() {
                return this.$route.path == "/gis";
            },
            isHovePage: function() {
                return this.$route.path == "/homePage/homePage"
            },
            currentMenu: function() { //激活一级菜单
                if(this.isGis) return;
                if(this.isHovePage) return this.lastCurrentMenu;
                if(this.menus2 && this.menus2 instanceof Array)
                    for(var menuLevel1 of this.menus2) {
                        if(menuLevel1.list && menuLevel1.list instanceof Array)
                            for(var menuLevel2 of menuLevel1.list) {
                                if(menuLevel2.list && menuLevel2.list instanceof Array)
                                    for(var menuLevel3 of menuLevel2.list) {
                                        if(this.$route.path == menuLevel3.url) {
                                            if(this.SelectMenulevel1) {
                                                menuLevel1 = this.SelectMenulevel1;
                                            }
                                            menuLevel2.open = true;
                                            this.lastCurrentMenu = {
                                                level1: menuLevel1,
                                                level2: menuLevel2,
                                                level3: menuLevel3
                                            };
                                            return this.lastCurrentMenu;
                                        }
                                    }
                            }
                    }
                return null;
            }
        },
        watch: {
            SelectMenulevel1: function(val) {
                //选择每一大项的第一个子菜单
                //console.log(val);
                if(val.list && val.list.length > 0 && val.list[0].list && val.list[0].list.length > 0 && val.list[0].list[0].url) {
                    this.$router.push(val.list[0].list[0].url);
                }
            }
        },
        mounted() {
            this.$rhttp.get('sys/menu/nav').then(res => {
                //全部菜单关闭
                if(res.data.menuList.length > 0)
                    for(let i = 0; i < res.data.menuList.length; i++) {
                        res.data.menuList[i].open = false;
                        var menuLevel1 = res.data.menuList[i];
                        if(menuLevel1 && menuLevel1.list && menuLevel1.list.length > 0)
                            for(let j = 0; j < menuLevel1.list.length; j++) {
                                res.data.menuList[i].list[j].open = false;
                                var menuLevel2 = res.data.menuList[i].list[j];
                                if(menuLevel2 && menuLevel2.list && menuLevel2.list.length > 0)
                                    for(let h = 0; h < menuLevel2.list.length; h++) {
                                        res.data.menuList[i].list[j].list[h].open = false;
                                    }
                            }
                    }
                store.commit('update_permissions', res.data.permissions);
                this.menus2 = res.data.menuList;
            })
 
            //获取登录者的姓名
            this.$rhttp.get('sys/user/info').then(res => {
                this.name = res.data.user.name;
                this.editData.username = res.data.user.username;
            })
 
        },
        methods: {
            makeSure() {
                if(this.editData.oldPassword == null && this.editData.oldPassword == '') {
                    tip.info("旧密码不能为空", "error");
                    return;
                }
                if(this.editData.newPassword == null && this.editData.newPassword == '') {
                    tip.info("新密码不能为空", "error");
                    return;
                }
                if(this.editData.newPassword2 == null && this.editData.newPassword2 == '') {
                    tip.info("确认新密码不能为空", "error");
                    return;
                }
                if(this.editData.newPassword != this.editData.newPassword2) {
                    tip.info("密码与确认密码不同", "error");
                    return;
                }
 
                this.$rhttp.put('sys/user/password?password=' + this.editData.oldPassword + '&newPassword=' + this.editData.newPassword).then(res => {
                    if(res.data.code == 0) {
                        tip.info("密码修改成功");
                        this.openDialog = false;
                    } else {
                        tip.info(res.data.msg, "error");
                        return;
                    }
                })
            },
            onPassword() { //修改密码
                //获取登录着的姓名
                this.$rhttp.get('sys/user/info').then(res => {
                    this.name = res.data.user.name;
                    this.editData = {
                        username: res.data.user.username,
                        oldPassword: null,
                        newPassword: null,
                        newPassword2: null
                    }
                    this.openDialog = true;
                })
            },
            goGis() {
                this.SelectMenulevel1 = "gis";
                this.$router.push("/gis");
            },
            onSignOut() { //退出
                delCookie("token");
                //回到登陆页面
                this.$router.push("/")
            },
            openCurrentMenu: function(menu) {
                if(menu.path) {
                    this.$router.push(menu.path);
                    return;
                }
                if(!menu.list instanceof Array) return;
                if(menu.open == true) {
                    menu.open = false;
                    return;
                }
                for(var i = 0; i < this.menus2.length; i++) {
                    for(var j = 0; j < this.menus2[i].list.length; j++) {
                        this.menus2[i].list[j].open = false;
                    }
                }
                menu.open = true;
            },
            fullScreen() {
                var docElm = document.documentElement;
                if(docElm.requestFullscreen) {
                    docElm.requestFullscreen();
                }
                //FireFox 
                else if(docElm.mozRequestFullScreen) {
                    docElm.mozRequestFullScreen();
                }
                //Chrome等 
                else if(docElm.webkitRequestFullScreen) {
                    docElm.webkitRequestFullScreen();
                }
                //IE11
                else if(elem.msRequestFullscreen) {
                    elem.msRequestFullscreen();
                }
                if(document.exitFullscreen) {
                    document.exitFullscreen();
                } else if(document.mozCancelFullScreen) {
                    document.mozCancelFullScreen();
                } else if(document.webkitCancelFullScreen) {
                    document.webkitCancelFullScreen();
                } else if(document.msExitFullscreen) {
                    document.msExitFullscreen();
                }
            }　
        }
    }
</script>
<style>
	.page-breadcrumbs {
		background: #fff;
	}
	
	.account-area li:hover {
		background: #59ADAF;
	}
	
	.account-area li.active {
		background: #3A8C95;
	}
	
	.navbar .navbar-inner .navbar-header .navbar-account .account-area {
		right: 0px;
	}
	
	.user_info {
		margin-top: 1px;
		margin-left: 10px;
		margin-right: 15px;
		width: 200px;
	}
	
	.user_info .user {
		text-align: center;
	}
	
	.user_info .role {
		text-align: center;
	}
	
	.user_info .user a {
		color: #fff;
		font-size: 18px;
	}
	
	.user_info .role a {
		color: #fff;
		font-size: 10px;
		position: relative;
		top: -4px;
	}
</style>