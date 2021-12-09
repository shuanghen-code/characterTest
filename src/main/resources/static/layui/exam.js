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
                console.log("data: "+data)
                let subData = data.field;
                console.log(subData);

                $.ajax({
                    url: "/result/addResults",
                    data: JSON.stringify(subData),
                    // data: {subData:subData},
                    type: "post",
                    async: false,
                    contentType: 'application/json;charset=UTF-8',
                    success: function (ret) {
                        if (ret.code == 0) {
                            // 操作成功，也是returnbean里的msg
                            window.location.href = '/test/toFinish';
                            //layer.msg(ret.msg(JSON.stringify(data.field)));
                        } else {
                            window.alert("???未知错误")
                        }
                    }
                });

                return false;
            });
        }
    });
});