layui.use(['table', 'form', 'element', 'jquery'], function () {
    var form = layui.form, table = layui.table, element = layui.element;
    var $ = layui.jquery;
    const titleDom = document.querySelector(".layui-tab-title");
    const optionDom = document.querySelector(".layui-tab-content");
    $.ajax({
        url: "/question/queryAllQuestion",
        data: {},
        dataType: "JSON",
        type: "GET",
        //
        success: function (data) {
            sessionStorage.setItem("tabNum", 1);
            let titleStr = '';
            let optionStr = '';
            data = data.data;
            let titleNum = data.length;
            for (let i = 0; i < data.length; i++) {
                if (i == 0) {
                    titleStr = titleStr + `<li class="layui-this undo" id="${i + 1}" lay-id="${i + 1}">${i + 1}</li>`;
                    optionStr = optionStr + '<div class="layui-tab-item layui-show">';
                } else {
                    titleStr = titleStr + `<li class="undo" id="${i + 1}" lay-id="${i + 1}">${i + 1}</li>`;
                    optionStr = optionStr + '<div class="layui-tab-item">';
                }

                optionStr = optionStr + `
                        <div class="layui-form-item">
                            <div class="layui-input-block">
                                <p>${data[i].question}</p>
                                <input type='radio' data-id="${i + 1}" name="${data[i].questionId}" value='A' lay-filter="radioOpt" title='${data[i].optionA.replace(/\n/g, "<br>")}'><br>
                                <input type='radio' data-id="${i + 1}" name="${data[i].questionId}" value='B' lay-filter="radioOpt" title='${data[i].optionB.replace(/\n/g, "<br>")}'><br>
                                <input type='radio' data-id="${i + 1}" name="${data[i].questionId}" value='C' lay-filter="radioOpt" title='${data[i].optionC.replace(/\n/g, "<br>")}'><br>
                                <input type='radio' data-id="${i + 1}" name="${data[i].questionId}" value='D' lay-filter="radioOpt" title='${data[i].optionD.replace(/\n/g, "<br>")}'><br>
                            </div>
                        </div>
                        </div>
                    `;
            }

            titleDom.innerHTML = titleStr;
            optionDom.innerHTML = optionStr;
            form.render();
            element.render();

            let map = new Map();
            //
            form.on('radio(radioOpt)', function (data) {
                let liId = data.elem.getAttribute("data-id");

                // 将当前题目标号和用户选择的结果存入map数组中
                map.set(data.elem.name, data.value);
                console.log("data.elem.name：" + data.elem.name + ", data.value：" + data.value);

                let percent = (map.size / titleNum) * 100;
                element.progress('demo', percent.toFixed(2) + "%");
                $('#' + liId).removeClass("undo");
                nextTab();
                if (percent >= 100) {
                    $('#submitBtn').css("display", "block");
                }
            });

            //切换题目
            var active = {
                tabBack: function () {
                    backTab();
                },
                tabForward: function () {
                    nextTab();
                }
            };

            function backTab() {
                let tabNum = sessionStorage.getItem("tabNum");
                console.log("backTab()的tabNum:" + tabNum);
                if (tabNum > 1) {
                    tabNum = tabNum - 1;
                    sessionStorage.setItem("tabNum", tabNum);
                    element.tabChange('docDemoTabBrief', tabNum);
                }
            }

            function nextTab() {
                let tabNum = sessionStorage.getItem("tabNum");
                console.log("nextTab()的tabNum:" + tabNum);

                if (tabNum < titleNum) {
                    tabNum = Number(tabNum) + 1;
                    sessionStorage.setItem("tabNum", tabNum);
                    element.tabChange('docDemoTabBrief', tabNum);
                }
            }

            $('.site-demo-active').on('click', function () {
                var othis = $(this), type = othis.data('type');
                active[type] ? active[type].call(this, othis) : '';
            });

            $(".layui-tab-title li").click(function () {
                var tabNum = $(this).index() + 1;
                sessionStorage.setItem("tabNum", tabNum);
            });


            form.on('submit(submit)', function (data) {
                let subData = data.field;
                console.log(subData);

                $.ajax({
                    url: "/result/addResults",
                    // url: "/question/queryAllQuestion",
                    data: JSON.stringify(subData),
                    type: "post",
                    async: false,
                    contentType: 'application/json;charset=UTF-8',
                    success: function (ret) {
                    }
                });

                /*if (Object.keys(subData).length == titleNum){
                    $.ajax({
                        url: "/result/addResults",
                        data: JSON.stringify(subData),
                        type: "post",
                        async: false,
                        contentType: 'application/json;charset=UTF-8',
                        success: function (ret){
                            /!*let d = ret.data;

                            let superiority = d.character.superiority;
                            console.log("d.character.superiority:"+superiority);
                            superiority = superiority.replace(/\n/g, "<br>&emsp;&emsp;");
                            superiority = superiority.replace("浣滀负涓綋", "<span>浣滀负涓綋</span>");
                            superiority = superiority.replace("娌熼€氱壒鐐�", "<span>娌熼€氱壒鐐�</span>");
                            superiority = superiority.replace("浣滀负鏈嬪弸", "<span>浣滀负鏈嬪弸</span>");
                            superiority = superiority.replace("瀵瑰緟宸ヤ綔鍜屼簨涓�", "<span>瀵瑰緟宸ヤ綔鍜屼簨涓�</span>");

                            let over = d.character.over;
                            console.log("d.character.over:"+over);
                            over = over.replace(/\n/g, "<br>&emsp;&emsp;");
                            over = over.replace("浣滀负涓綋", "<span>浣滀负涓綋</span>");
                            over = over.replace("娌熼€氱壒鐐�", "<span>娌熼€氱壒鐐�</span>");
                            over = over.replace("浣滀负鏈嬪弸", "<span>浣滀负鏈嬪弸</span>");
                            over = over.replace("瀵瑰緟宸ヤ綔鍜屼簨涓�", "<span>瀵瑰緟宸ヤ綔鍜屼簨涓�</span>");

                            let hue = d.character.hue;
                            console.log("d.character.hue:"+hue);

                            let ch = '';
                            if (hue == "绾㈣壊"){
                                    ch = "red-hue";
                                }else if(hue == "榛勮壊"){
                                    ch = "yellow-hue";
                                }else if(hue == "钃濊壊"){
                                    ch = "blue-hue";
                                }else{
                                    ch = "green-hue";
                            }
                            // 示范一个公告层
                            layer.open({
                                type: 1
                                ,title: false //不显示标题栏
                                ,closeBtn: false
                                ,area: ['800px', '630px']
                                ,shade: 0.8
                                ,id: 'LAY_layuipro' //设定一个id，防止重复弹出
                                ,btn: ['鐭ユ檽']
                                ,btnAlign: 'c'
                                ,moveType: 1 //拖拽模式，0或者1
                                ,content: `
                                            <div>
                                                <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
                                                    <ul class="layui-tab-title">
                                                        <li class="layui-this result-li">鎬ф牸棰滆壊</li>
                                                        <li class="result-li">璇︾粏浠嬬粛</li>
                                                    </ul>
                                                    <div class="layui-tab-content">
                                                        <div class="layui-tab-item layui-show">
                                                            <div class="character-intro">
                                                                <p>鎮ㄧ殑鎬ф牸棰滆壊涓猴細<span class="${ch}">${d.character.hue}</span></p>
                                                                <p>${d.character.intro.replace(/\n/g, "<br>")}</p>
                                                            </div>
                                                        </div>
                                                        <div class="layui-tab-item">
                                                            <div class="character-detail">
                                                                <div>
                                                                    <p>鎬ф牸浼樺娍</p>
                                                                    <p>&emsp;&emsp;${superiority}</p>
                                                                </div>
                                                                <div>
                                                                    <p>鎬ф牸杩囧害</p>
                                                                    <p>&emsp;&emsp;${over}</p>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        `
                                ,success: function(layero){
                                    var btn = layero.find('.layui-layer-btn');
                                    btn.find('.layui-layer-btn0').attr({
                                        href: '/toIndex'
                                    });
                                }
                            });*!/
                        }
                    });
                }else{
                    layer.confirm('杩樻湁棰樼洰鏈仛瀹�', function (i) {
                        layer.close(i);
                    });
                }*/

                return false;
            });
        }
    });
});