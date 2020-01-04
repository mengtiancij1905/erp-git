$(function() {
    $("#grid").datagrid({
        url: url,
        columns: columns,
        singleSelect: true,
        onLoadSuccess:function(data){
            if(chartType=="pie") {
                //显示饼状图
                $('#container').highcharts({
                    chart: {
                        type: 'pie',
                        options3d: {
                            enabled: true,
                            alpha: 45,
                            beta: 0
                        }
                    },
                    title: {
                        text: '商品类型销售额'
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            depth: 35,
                            dataLabels: {
                                enabled: true,
                                format: '{point.name}'
                            }
                        }
                    },
                    series: [{
                        type: 'pie',
                        name: 'Browser share',
                        data: data.rows
                    }]
                });
            }else if(chartType=="line"){
                var year = $("#year").combobox("getValue");
                if(year==null || year==""){
                    year=new Date().Format("yyyy");
                }

                var datas = $("#grid").datagrid("getRows");
                var arr=[];
                for(var i=0; i<datas.length; i++){
                    arr.push(datas[i].money)
                }

                $('#container').highcharts({
                    title: {
                        text: year+'年销售额分析',
                        x: -20 //center
                    },
                    xAxis: {
                        categories: ['一月份', '二月份', '三月份', '四月份', '五月份', '六月份',
                            '七月份', '八月份', '九月份', '十月份', '十一月份', '十二月份']
                    },
                    yAxis: {
                        title: {
                            text: '各月份销售额 (元)'
                        },
                        plotLines: [{
                            value: 0,
                            width: 1,
                            color: '#808080'
                        }]
                    },
                    tooltip: {
                        valueSuffix: '万元'
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'middle',
                        borderWidth: 0
                    },
                    series: [{
                        name: year+"年份",
                        data: arr
                    }]
                });
            }
        }
    })

    $("#btnSearch").click(function(){
        var formData = $("#searchForm").serializeJSON();
        $("#grid").datagrid("load",formData );
    })
})