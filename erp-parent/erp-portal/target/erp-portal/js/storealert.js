$(function(){
    $('#grid').datagrid({
        url:url,
        columns:columns,
        singleSelect:true,
        rownumbers:true,
        toolbar: [{
            text:'发送预警邮件',
            iconCls: 'icon-add',
            handler: function(){
                //触发发送邮件
                $.ajax({
                    url:'/storedetail/sendAlertMail.action',
                    type:'post',
                    dataType:'json',
                    success:function(rtn){
                        $.messager.alert('提示',rtn.message,'info');
                    }
                });
            }
        }]
    });
});
