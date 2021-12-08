layui.use([ 'jquery'],function () {
    var redColor, blueColor, yellowColor, greenColor;
    var $ = layui.jquery;
    // 占比统计
    var pie_fanzui =echarts.init(document.getElementById("pie_fanzui"),'infographic');
    // 人数分布
    // var qufenbu_data =echarts.init(document.getElementById("qufenbu_data"),'infographic');
    var qufenbu_data =echarts.init(document.getElementById("qufenbu_data"),'infographic');
    // 时间段统计
    var line_time =echarts.init(document.getElementById("line_time"),'infographic');

    $.ajax({
        url: "/tester/selectAllCharacter",
        type: "post",
        dataType: "JSON",
        success: function (ret) {
            if (ret.code == 0) {
                console.log(ret);
                redColor = ret.data.redCount;
                blueColor = ret.data.blueCount;
                yellowColor = ret.data.yellowCount;
                greenColor = ret.data.greenCount;

                //性格颜色分析占比，带边框效果的饼图
                option = {
                    title : {
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: ['红色性格','蓝色性格','黄色性格','绿色性格'],
                        textStyle: {color: '#fff'}
                    },

                    label: {
                        normal: {
                            textStyle: {
                                color: 'red'  // 改变标示文字的颜色
                            }
                        }
                    },
                    series : [
                        {
                            name: '四种颜色性格占比',
                            type: 'pie',
                            radius : '40%',
                            data:[
                                {value:redColor, name:'红色性格'},
                                {value:blueColor, name:'蓝色性格'},
                                {value:yellowColor, name:'黄色性格'},
                                {value:greenColor, name:'绿色性格'},
                            ],

                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,

                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }

                        }
                    ]
                };
                pie_fanzui.setOption(option);
                //----------------------分析占比end---------------


                //=========性格数量分布开始=======================
                option = {
                    // color: ['#FADB71'],
                    // color: ['#c12e34','#e6b600','#0098d9','#2b821d'],
                    tooltip : {
                        trigger: 'axis',
                        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    grid: {
                        x:30,
                        y:10,
                        x2:15,
                        y2:20
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data: ['红色','蓝色','黄色','绿色'],
                            axisTick: {
                                alignWithLabel: true
                            },
                            axisLabel: {
                                color: "#FADB71" //刻度线标签颜色
                            }
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value',
                            axisLabel: {
                                color: "#FADB71" //刻度线标签颜色
                            }
                        }
                    ],
                    series : [
                        {
                            name:'颜色分布',
                            type:'bar',
                            barWidth: '60%',
                            data:[
                                {
                                    value: redColor,
                                    itemStyle: {
                                        color: '#C1232B'
                                    }
                                },
                                {
                                    value: blueColor,
                                    itemStyle: {
                                        color: '#27727B'
                                    }
                                },
                                {
                                    value: yellowColor,
                                    itemStyle: {
                                        color: '#FCCE10'
                                    }
                                },
                                {
                                    value: greenColor,
                                    itemStyle: {
                                        color: '#9BCA63'
                                    }
                                }
                                ],
                        }
                    ]
                };
                qufenbu_data.setOption(option);
                //=========颜色分布结束=======================
            } else {
                layer.msg(ret.msg, {icon: 5});
            }
        }
    });

    function fnW(str) {
        var num;
        str >= 10 ? num = str : num = "0" + str;
        return num;
    }

    //获取当前时间
    var timer = setInterval(function () {
        var date = new Date();
        var year = date.getFullYear(); //当前年份
        var month = date.getMonth(); //当前月份
        var data = date.getDate(); //天
        var hours = date.getHours(); //小时
        var minute = date.getMinutes(); //分
        var second = date.getSeconds(); //秒
        var day = date.getDay(); //获取当前星期几
        var ampm = hours < 12 ? 'am' : 'pm';
        $('#time').html(fnW(hours) + ":" + fnW(minute) + ":" + fnW(second));
        $('#date').html('<span>' + year + '/' + (month + 1) + '/' + data + '</span><span>' + ampm + '</span><span>周' + day + '</span>')

    }, 1000)

    $.ajax({
        url: "/tester/selectNumByMonth",
        type: "post",
        dataType: "JSON",
        success: function (ret) {
            //===================时间段统计=======================
            var xlabel = []; // 横坐标，月份
            var xvalue = []; // 每月有多少人测试
            var monthCounts = ret.data;
            // console.log(monthCounts+"=====================");
            if (monthCounts.length>0){
                for (monthCount in monthCounts) {
                    xlabel.push(monthCounts[monthCount].mydate);
                    // monthCount
                    xvalue.push(monthCounts[monthCount].num);
                }
                console.log("xlabel:"+xlabel);
                console.log("xvalue:"+xvalue);
            }

            var option = {
                    // 给echarts图设置背景色
                    color: ['#7FFF00'],
                    tooltip: {
                        trigger: 'axis'
                    },

                    grid:{
                                x:40,
                                y:30,
                                x2:5,
                                y2:20
                            },
                    calculable: true,

                    xAxis: [{
                         type: 'category',
                    data: xlabel,
                 axisLabel: {
                        color: "#7FFF00" //刻度线标签颜色
                        }
                    }],
                    yAxis: [{

                        type: 'value',
                        axisLabel: {
                        color: "#7FFF00" //刻度线标签颜色
                        }
                    }],
                    series: [{
                        name: '次',
                        type: 'line',
                        data: xvalue,
                    }]
                };
            line_time.setOption(option);
        }
    });


    //时间选择器
    var startV = '';
    var endV = '';
    laydate.skin('danlan');
    var startTime = {
        elem: '#startTime',
        format: 'YYYY-MM-DD',
        min: '1997-01-01', //设定最小日期为当前日期
        max: laydate.now(), //最大日期
        istime: true,
        istoday: true,
        fixed: false,
        choose: function (datas) {
            startV = datas;
            endTime.min = datas; //开始日选好后，重置结束日的最小日期
        }
    };
    var endTime = {
        elem: '#endTime',
        format: 'YYYY-MM-DD',
        min: laydate.now(),
        max: laydate.now(),
        istime: true,
        istoday: true,
        fixed: false,
        choose: function (datas) {
            //        startTime.max = datas; //结束日选好后，重置开始日的最大日期
            endV = datas;
        }
    };

    laydate(startTime);
    laydate(endTime);

    //时间选择器
    var startVs = '';
    var endVs = '';
    laydate.skin('danlan');
    var startTimes = {
        elem: '#startTimes',
        format: 'YYYY-MM-DD',
        min: '1997-01-01', //设定最小日期为当前日期
        max: '2099-06-16', //最大日期
        istime: true,
        istoday: true,
        fixed: false,
        choose: function (datas) {
            startVs = datas;
            endTimes.min = datas; //开始日选好后，重置结束日的最小日期
            setQgData($('#barTypes').parent().parent(), 1);
        }
    };
    var endTimes = {
        elem: '#endTimes',
        format: 'YYYY-MM-DD',
        min: laydate.now(),
        max: laydate.now(),
        istime: true,
        istoday: true,
        fixed: false,
        choose: function (datas) {
            //        startTime.max = datas; //结束日选好后，重置开始日的最大日期
            endVs = datas;
            setQgData($('#barTypes').parent().parent(), 1);
        }
    };

    laydate(startTimes);
    laydate(endTimes);




    //更改日期插件的样式
    function dateCss() {
        var arr = $('#laydate_box').attr('style').split(';');
        var cssStr =
            'position:absolute;right:0;';
        for (var i = 0; i < arr.length; i++) {
            if (arr[i].indexOf('top') != -1) {
                cssStr += arr[i];
            }
        }

        $('#laydate_box').attr('style', cssStr);
    }


    var workDate;
    var time = {
        elem: '#times',
        format: 'YYYY-MM-DD',
        min: laydate.now(),
        max: laydate.now() + 30,
        istime: true,
        istoday: true,
        fixed: false,
        choose: function (datas) {
            //        startTime.max = datas; //结束日选好后，重置开始日的最大日期
            workDate = datas;
        }
    };

    laydate(time);

});

