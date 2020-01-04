var isEditingRowIndex=0;//当前可编辑的行索引
$(function() {
    $("#grid").datagrid({
        columns: [[
            {field: 'goodsuuid', title: "商品编号", width: 100, editor:{type:"numberbox", options:{disabled:true}}},
            {field: 'goodsname', title: "商品名称", width: 150,editor:{
                type:"combobox",options:{
                        url:'/goods/list.action',
                        valueField:'name',
                        textField:'name',
                        onSelect:function(row){
                            var priceEdit=$("#grid").datagrid("getEditor",{index:isEditingRowIndex,field:'price'});
                            (priceEdit.target).val(row.inprice);

                            var goodsuuidEdit=$("#grid").datagrid("getEditor",{index:isEditingRowIndex,field:'goodsuuid'});
                            (goodsuuidEdit.target).val(row.uuid);
                            cal();
                        }
                    }
                }},
            {field: 'price', title: "价格", width: 100, editor:{
                type:"numberbox",options:{precision:2}
                }
                },
            {field: 'num', title: "数量", width: 100,editor:"numberbox"},
            {field: 'money', title: '金额', width: 100,editor:{
                    type:"numberbox",options:{precision:2}
                }},
            {
                field: '-', title: '操作', width: 100, formatter: function (value, row, index) {
                    return "<a href='javascript:void(0)' onClick='deleteRow(" + index + ")'>删除</a>";
                }
            }
        ]],
        singleSelect: true,
        toolbar: [{
            iconCls: 'icon-add',
            text: '增加',
            handler: function () {
                //增加一行
                $("#grid").datagrid("appendRow",{"num":1, "money":0} );

                //关闭编辑状态
                $("#grid").datagrid("endEdit", isEditingRowIndex);
                isEditingRowIndex =  $("#grid").datagrid("getRows").length-1;
                //设置编辑状态
                $("#grid").datagrid("beginEdit",isEditingRowIndex );

                bindGridEvent();
            }
        }],
        onClickRow:function(rowIndex, rowData){//rowIndex：行号， rowData:当前行的数据
            $("#grid").datagrid("endEdit", isEditingRowIndex);//取消编辑
            isEditingRowIndex= rowIndex;
            $("#grid").datagrid("beginEdit",isEditingRowIndex );

            bindGridEvent();
        }
    })

    $("#supplier").combogrid({
        url:"supplier/list.action?type=1",
        idField:"uuid",
        textField:"name",
        columns:[[
            {field:'uuid', title:'ID',width:100},
            {field:'name', title:'名称',width:100},
            {field:'address', title:'地址',width:100},
            {field:'contact', title:'联系人',width:100},
            {field:'tele', title:'电话',width:100},
        ]],
        width:400,
        panelWidth:550
    })

    //提交采购申请
    $("#btnSave").click(function(){
        //取消编辑状态
        $("#grid").datagrid("endEdit", isEditingRowIndex);

        //1.获取表单数据
        var formData = $("#orderForm").serializeJSON();

        //2.获取datagrid中的数据
        var gridData = $("#grid").datagrid("getRows");

        formData["json"]=gridData;

        $.ajax({
            url:'orders/add.action',
            dataType:'json',
            type:'post',
            data:JSON.stringify(formData),
            contentType:"application/json",
            success:function(value){
                if(value.status=="ok"){
                    //清空合计数
                    $("#sum").html("0.00");
                    //清空表格
                    $("#grid").datagrid("loadData",{total:0,rows:[]})
                }

                $.messager.alert('提示', value.message);
            }
        })
    })
})

function deleteRow(index){

    $("#grid").datagrid("endEdit",isEditingRowIndex );
    $("#grid").datagrid("deleteRow", index);

    //获取表格数据
    var data = $("#grid").datagrid("getData");
    //向表格加载数据
    $("#grid").datagrid("loadData", data);
}


function cal(){
    //获取数量的编辑框
    var numEdit = $("#grid").datagrid("getEditor",{index:isEditingRowIndex,field:"num"});
    //得到数量编辑框里的值
    var num = $(numEdit.target).val();//value属性
    //获取价格的编辑框
    var priceEdit=$("#grid").datagrid("getEditor",{index:isEditingRowIndex,field:'price'});
    //得到价格编辑框里的值
    var price = $(priceEdit.target).val();

    //计算金额，保留两位小数
    var money = (num * price).toFixed(2);
    //获取金额的编辑框
    var moneyEdit=$("#grid").datagrid("getEditor",{index:isEditingRowIndex,field:'money'});
    //对金额编辑框赋值
    $(moneyEdit.target).val(money);

    $("#grid").datagrid("getRows")[isEditingRowIndex].money = money;//修改单元格的值

    sum();
}

function bindGridEvent(){
    var priceEdit=$("#grid").datagrid("getEditor",{index:isEditingRowIndex,field:'price'});

    //给“价格”添加键盘事件
    (priceEdit.target).bind("keyup", function(){
        cal();
    })

    //给“数量”添加键盘事件
    var numEdit = $("#grid").datagrid("getEditor",{index:isEditingRowIndex,field:"num"});
    (numEdit.target).bind("keyup",function(){
        cal();
    })


}

function sum(){
    //获取所有行
    var rows = $("#grid").datagrid("getRows");

    var money = 0;//合计数
    for(var i=0; i<rows.length; i++){
        money += parseFloat(rows[i].money);
    }
    $("#sum").html(money.toFixed(2))
}
