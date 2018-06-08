var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "areaId",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};
var ztree;

var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: null,
        area:{
            parentName:null,
            parentId:0,
            orderNum:0
        }
    },
    methods: {
        getArea: function(){
            //加载部门树
            $.get(baseURL + "sys/area/select", function(r){
                ztree = $.fn.zTree.init($("#areaTree"), setting, r.areaList);
                var node = ztree.getNodeByParam("areaId", vm.area.parentId);
                ztree.selectNode(node);

                vm.area.parentName = node.name;
            })
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.area = {parentName:null,parentId:0,orderNum:0};
            vm.getArea();
        },
        update: function () {
            var areaId = getAreaId();
            if(areaId == null){
                return ;
            }

            $.get(baseURL + "sys/area/info/"+areaId, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.area = r.area;

                vm.getArea();
            });
        },
        del: function () {
            var areaId = getAreaId();
            if(areaId == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/area/delete",
                    data: "areaId=" + areaId,
                    success: function(r){
                        if(r.code === 0){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
            var url = vm.area.areaId == null ? "sys/area/save" : "sys/area/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.area),
                success: function(r){
                    if(r.code === 0){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        areaTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择行政区划",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#areaLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    vm.area.parentId = node[0].areaId;
                    vm.area.parentName = node[0].name;

                    layer.close(index);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            Area.table.refresh();
        }
    }
});

var Area = {
    id: "areaTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Area.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '行政区划ID', field: 'areaId', visible: false, align: 'center', valign: 'middle', width: '80px'},
        {title: '行政区划名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '上级行政区划', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {title: '排序号', field: 'orderNum', align: 'center', valign: 'middle', sortable: true, width: '100px'}]
    return columns;
};


function getAreaId () {
    var selected = $('#areaTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}


$(function () {
    $.get(baseURL + "sys/area/info", function(r){
        var colunms = Area.initColumn();
        var table = new TreeTable(Area.id, baseURL + "sys/area/list", colunms);
        table.setRootCodeValue(r.areaId);
        table.setExpandColumn(2);
        table.setIdField("areaId");
        table.setCodeField("areaId");
        table.setParentCodeField("parentId");
        table.setExpandAll(false);
        table.init();
        Area.table = table;
    });
});
