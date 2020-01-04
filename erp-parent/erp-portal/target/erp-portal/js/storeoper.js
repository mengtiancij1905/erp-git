$(function(){
    $("#grid").datagrid({
        url:"/storeoper/search.action",
        columns:[[
            {field:'uuid', title:"编号",width:100},
            {field:'empuuid',title:"员工名称", width:100,formatter:function(value, row, index){
                    return ajax("/emp/get.action?uuid=", value, 'emp_'+index,"name");
                }},{field:'opertime',title:"操作时间", width:140,formatter:function(value){
                    return new Date(value).Format('yyyy-MM-dd hh:mm:ss');
                }},{field:'storeuuid',title:"仓库名称", width:100,formatter:function(value, row, index){
                    return ajax("/store/get.action?uuid=", value, 'store_'+index,"name");
                }},{field:'goodsuuid',title:"商品名称", width:100,formatter:function(value, row, index){
                    return ajax("/goods/get.action?uuid=", value, 'goods_'+index,"name");
                }},{field:'num',title:'数量', width:100},
            {field:'type', title:"类型", width:100, formatter:function(value){
                    return storetype(value);
                }}
        ]],
        singleSelect:true,
        pagination:true
    });
})

function storetype(value){
    if(value * 1 == 1){
        return "采购入库";
    }
    if(value * 1 == 2){
        return "销售出库";
    }
    if(value * 1 == 3){
        return "盘盈入库";
    }
    if(value * 1 == 4){
        return "盘亏出库";
    }
    if(value * 1 == 5){
        return "销售退货入库";
    }
    if(value * 1 == 6){
        return "采购退货出库";
    }
    $("#btnSearch").click(function(){
        var formdata = $("#searchForm").serializeJSON();
        $("#grid").datagrid("load", formdata);
    })
}