<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title></title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/AdminLTE.min.css">
  <!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
  <link rel="stylesheet" href="css/all-skins.min.css">
  <link rel="stylesheet" href="css/main.css">
  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box" id="rrapp" v-cloak>
  <div class="login-logo">
    <b>工程安全规划院<br>快速开发平台</b>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
      <p class="login-box-msg">管理员登录</p>
      <div v-if="error" class="alert alert-danger alert-dismissible">
        <h4 style="margin-bottom: 0px;"><i class="fa fa-exclamation-triangle"></i> {{errorMsg}}</h4>
      </div>
      <div class="form-group has-feedback">
        <input type="text" class="form-control" v-model="username" placeholder="账号">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" class="form-control" v-model="password" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <input type="text" class="form-control" v-model="captcha" @keyup.enter="login" placeholder="验证码">
          <span class="glyphicon glyphicon-warning-sign form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
          <img alt="如果看不清楚，请单击图片刷新！" class="pointer" :src="src" @click="refreshCode">
          &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:;" @click="refreshCode">点击刷新</a>
      </div>

      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" class="btn btn-primary btn-block btn-flat" @click="login">登录</button>
        </div>
        <!-- /.col -->
      </div>
    <!-- /.social-auth-links -->

  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<script src="libs/jquery.min.js"></script>
<script src="plugins/jqgrid/jquery.jqGrid.min.js"></script>
<script src="libs/vue.min.js"></script>
<script src="libs/bootstrap.min.js"></script>
<script src="libs/app.js"></script>
<script src="js/common.js"></script>
<script type="text/javascript">
var vm = new Vue({
	el:'#rrapp',
	data:{
		username: '',
		password: '',
        captcha: '',
		error: false,
		errorMsg: '',
        src: 'captcha.jpg'
	},
	beforeCreate: function(){
		if(self != top){
			top.location.href = self.location.href;
		}
	},
	methods: {
        refreshCode: function(){
            this.src = "captcha.jpg?t=" + $.now();
        },
		login: function () {
            var data = "username="+vm.username+"&password="+vm.password+"&captcha="+vm.captcha;
			$.ajax({
				type: "GET",
			    url: baseURL + "sys/login",
			    data: data,
			    dataType: "json",
			    success: function(r){
					if(r.code == 0){//登录成功
                        localStorage.setItem("token", r.token);
                        parent.location.href ='index.html';
					}else{
						vm.error = true;
						vm.errorMsg = r.msg;
					}
				}
			});
		}
	}
});
</script>
</body>
</html>
