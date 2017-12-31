/**
 * Created by Jquery on 2017/12/30.
 */
/**
 * 使用daTagrid中loadData方法加载数据
 */
$(function () {
    var total=0;
    var dataJson={};
    var resultData={};
    var pageNumber=1;
    var pageSize=5;
    var param = {
        pageindex : pageNumber,
        pageSize : pageSize,
    };
    //将请求参数转换成json字符串
    var queryParams=JSON.stringify(param);
    //初始化datagrid
    initTable();
    var webName=getRootPath();
    var url="/"+webName+"/GetAllData";
    function getData(param,callback) {
        //获取url地址根目录  当前taomcat下路径
        $.ajax({
            url: url,
            type: "post",
            contentType: "application/json",//发送到服务器的数据编码类型
            data: param,
            success: function (data) {
                callback && callback(data);
            }
        });
    }
    //获取数据
    getData(queryParams,function(data){
        resultData=data;
        /*
         * 加载数据
         * loadData方法加载的数据格式：
         * loadData是加载本地的json格式字符串，具体使用请看如下：
         *var jsoin = { "total": 28, "rows": [
         *{ "productid": "FI-SW-01", "unitcost": 10.00, "status": "P", "listprice": 36.50, "attr1": "Large", "itemid": "EST-1" }]};
         *jQuery("#tt").datagrid("loadData",jsoin);----这里是加载json格式的字符串，
         */
        $("#dataToSync").datagrid("loadData",resultData);
        //获取分页对象并初始化
        var getPager=$("#dataToSync").datagrid("getPager");
        getPager.pagination({
            onSelectPage:onSelectPageFunc//分页改变时触发
        });

    });
    function onSelectPageFunc(pageNumber,pageSize){
        //分页改变时请求新的数据并加载
        //console.log(pageNumber+":"+pageSize);
        param.pageSize=pageSize;
        param.pageindex=pageNumber;
        var sendData=JSON.stringify(param);
        getData(sendData,function(data){
            resultData=data;
            //加载数据
            $("#dataToSync").datagrid("loadData",resultData);
        })
    }
    function initTable(){
        $("#dataToSync").datagrid({
            pagination:true,
            total:resultData.total,
            pageSize:pageSize,
            pageNumber:pageNumber,
            pageList:[5,10,20,30,40,50],
            columns: [[
                {
                    field : 'num',
                    title : '客户号',
                    align : 'center',
                    valign : 'middle',
                    sortable : true
                }, {
                    field : 'name',
                    title : '用户名',
                    align : 'center',
                    valign : 'middle',
                    sortable : true
                }, {
                    field : 'sex',
                    title : '性别',
                    align : 'center',
                    valign : 'middle'
                }, {
                    field : 'age',
                    title : '年龄',
                    align : 'center',
                    valign : 'middle',
                    sortable : true
                }, {
                    field : 'idcard',
                    title : '身份证号',
                    align : 'center',
                    valign : 'middle'
                }, {
                    field : 'phone',
                    title : '电话',
                    align : 'center',
                    valign : 'left'
                }, {
                    field : 'address',
                    title : '地址',
                    align : 'center',
                    valign : 'middle'
                },{
                    field : 'email',
                    title : '邮箱',
                    align : 'center',
                    valign : 'middle'
                }, {
                    field : 'time',
                    title : '采集时间',
                    align : 'center',
                    valign : 'middle'
                }
            ]]
        });
    }
});