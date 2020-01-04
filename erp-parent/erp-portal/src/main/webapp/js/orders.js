var url ='/orders/search.action';
var itemRowIndex = 0;
$(function () {
    if (Request["operation"] == "check") {
        url = url + "?state=0";
        document.title = "采购审核";
    } else if (Request["operation"] == 'start') {
        url = url + "?state=1";
        document.title = "采购确认";
    } else if (Request["operation"] == 'instore') {
        url = url + "?state=2";
        document.title = "采购入库"
    }
    $("#grid").datagrid({
        url: url,
        columns: [[
            {field: 'uuid', title: '编号', width: 100},
            {
                field: 'createtime', title: "生成日期", width: 100, formatter: function (value) {
                    if (value != null) {
                        return new Date(value).Format('yyyy-MM-dd');
                    }
                }
            },
            {
                field: 'checktime', title: "检查日期", width: 100, formatter: function (value) {
                    if (value != null) {
                        return new Date(value).Format('yyyy-MM-dd');
                    }
                }
            },
            {
                field: 'starttime', title: "开始日期", width: 100, formatter: function (value) {
                    if (value != null) {
                        return new Date(value).Format('yyyy-MM-dd');
                    }
                }
            },
            {
                field: 'endtime', title: "结束日期", width: 100, formatter: function (value) {
                    if (value != null) {
                        return new Date(value).Format('yyyy-MM-dd');
                    }
                }
            },
            {
                field: 'creater', title: "下单员", width: 100, formatter: function (value, row, index) {
                    //<span id="create_1">张三</span>
                    return ajax('/emp/get.action?uuid=', value, 'creater_' + index, 'name');
                }
            },
            {
                field: 'checker', title: "审查员", width: 100, formatter: function (value, row, index) {
                    return ajax('/emp/get.action?uuid=', value, 'checker_' + index, 'name');
                }
            },
            {
                field: 'starter', title: "采购员", width: 100, formatter: function (value, row, index) {
                    return ajax('/emp/get.action?uuid=', value, 'starter_' + index, 'name');
                }
            },
            {
                field: 'ender', title: "库管员", width: 100, formatter: function (value, row, index) {
                    return ajax('/emp/get.action?uuid=', value, 'ender_' + index, 'name');
                }
            },
            {
                field: 'supplieruuid', title: "供应商", width: 100, formatter: function (value, row, index) {
                    return ajax('/supplier/get.action?uuid=', value, 'supplier_' + index, 'name');
                }
            },
            {field: 'totalmoney', title: "总金额", width: 100},
            {
                field: 'state', title: '订单状态', width: 100, formatter: function (value) {
                    return getState(value);
                }
            }
        ]],
        singleSelect: true,
        pagination: true,
        fitColumns: true,
        onDblClickRow: function (rowIndex, rowData) {
            $("#ordersWindow").window("open");
            $("#uuid").html(rowData.uuid);// 流水号

            //创建日期
            if (rowData.createtime != null) {
                $("#createtime").html(new Date(rowData.createtime).Format('yyyy-MM-dd'));
            }
            // 审核日期
            if (rowData.checktime != null) {
                $("#checktime").html(new Date(rowData.checktime).Format('yyyy-MM-dd'));
            }
            // 确认日期
            if (rowData.starttime != null) {
                $("#starttime").html(new Date(rowData.starttime).Format('yyyy-MM-dd'));
            }
            // 入库日期
            if (rowData.endtime != null) {
                $("#endtime").html(new Date(rowData.endtime).Format('yyyy-MM-dd'));
            }
            // 供应商
            $("#supplier").html($("#supplier_" + rowIndex).html());
            // 下单人
            $("#creater").html($("#creater_" + rowIndex).html());
            // 审核人
            $("#checker").html($("#checker_" + rowIndex).html());
            // 确认人
            $("#starter").html($("#starter_" + rowIndex).html());
            // 入库人
            $("#ender").html($("#ender_" + rowIndex).html());
            // 状态
            $("#state").html(getState(rowData.state));


            //$("#itemgrid").datagrid('loadData', rowData.details);
            //TODO：显示订单明细
            $("#itemgrid").datagrid({
                url: "/orders/orderdetail.action?uuid=" + rowData.uuid
            })

            //显示审核按钮
            if (Request["operation"] == "check") {
                $("#btnCheck").show();
            } else if (Request["operation"] == "start") {
                $("#btnStart").show();
            }
        }
    });

    $("#itemgrid").datagrid({
        title: "订单明细",
        height: 300,
        columns: [[
            {field: 'goodsuuid', title: '商品编号', width: 100},
            {field: 'goodsname', title: '商品名称', width: 200},
            {field: 'price', title: '价格', width: 100},
            {field: 'num', title: '数量', width: 100},
            {field: 'money', title: '金额', width: 100},
            {
                field: 'state', title: '状态', width: 80,
                formatter: function (value) {
                    return getDetailState(value);
                }
            }
        ]],
        fitColumns: true,
        rownumbers: true,
        onDblClickRow: function (rowIndex, rowData) {
            $("#itemWindow").window("open");//打开窗口
            $("#goodsuuid").html(rowData.goodsuuid);//商品ID
            $("#goodsname").html(rowData.goodsname);//商品名称
            $("#num").html(rowData.num);//数量
            $("#itemuuid").val(rowData.uuid);//ID

            if (rowData.state == 0 && Request["operation"] == 'instore') {
                $("#btnEnd").show();
            } else {
                $("#btnEnd").hide();
            }

            itemRowIndex = rowIndex;
        }

    })

    //审核订单
    //JBPM
    $("#btnCheck").click(function () {
        $.messager.confirm('提示', '确定要审核码？', function (val) {
            if (val) {
                $.ajax({
                    url: '/orders/doCheck.action?uuid=' + $("#uuid").html(),
                    dataType: 'json',
                    success: function (value) {
                        if (value.status == "ok") {
                            $("#ordersWindow").window("close");
                            $("#grid").datagrid("reload");
                        }
                        $.messager.alert("提示", value.message);
                    }
                })
            }
        })
    })

    // 确认订单
    $("#btnStart").bind("click", function () {
        $.messager.confirm('提示', '确认该订单吗？', function (val) {
            if (val) {
                $.ajax({
                    url: 'orders/doStart.action?uuid=' + $("#uuid").html(),
                    dataType: 'json',
                    success: function (value) {
                        if (value.status == "ok") {
                            $("#ordersWindow").window("close");
                            $("#grid").datagrid("reload");
                        }
                        $.messager.alert("提示", value.message);
                    }
                })
            }
        })
    })

    //采购入库
    $("#btnEnd").click(function () {
        //提取表单数据
        var formdata = $("#itemForm").serializeJSON();//{"id":"87","storeuuid":"5"}

        $.messager.confirm("提示", '确定要入库吗？', function (val) {
            if (val) {
                $.ajax({
                    url: "/orders/doInStore.action",
                    dataType: 'json',
                    data: formdata,
                    type: 'post',
                    success: function (value) {
                        if (value.status == "ok") {
                            //关闭窗口
                            $("#itemWindow").window("close");
                            //更改本地数据的状态
                            $("#itemgrid").datagrid("getRows")[itemRowIndex].state = "1";
                            //刷新数据
                            $("#itemgrid").datagrid("loadData", $("#itemgrid").datagrid('getData'));
                            //刷新主表
                            $("#grid").datagrid('reload');
                        }
                        $.messager.alert('提示', value.message);
                    }
                })
            }
        })
    })
})


//获取状态
function getState(value) {
    if (value == 0)
        return "未审核";
    if (value == 1)
        return "已审核";
    if (value == 2)
        return "已采购";
    if (value == 3)
        return "已入库";
}

//获取订单明细状态
function getDetailState(value) {
    if (value == '0')
        return "未入库";
    if (value == '1')
        return "已入库";
}
