<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>列表</title>
<link rel="stylesheet" type="text/css" href="${base}/resources/css/flexigrid/flexigrid.css">

<script type="text/javascript" src="${base}/resources/js/jquery.js"></script>

<script type="text/javascript" src="${base}/resources/js/flexigrid.pack.js"></script>

<script type="text/javascript">
$().ready(showgrid);



function showgrid(){

	$("#flex1").flexigrid
	({
	    url: '${base}/flexi3.xml',
        initCond:"",
	    params:[{name:"queryid",value:"OA_QINGJIA"}
			    ,{name:"cryptcond",value:""}
			    ,{name:"sindex",value:""}
			    ,{name:"condition",value:""}
                ,{name:"defaultvalue",value:""}
			    ],
	    colModel : ${properties},
	    
	    
	    //colModel : [{display: '序号', name : 'rowindex', width : 30, sortable : false, align: 'center',renderer:colIndex},{display: '申请单号', name : 'QHNO', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'a4f5ce4b-09e8-4cdc-afc4-9e8fd10b0657'},{display: '类型', name : 'HEADTYPE', width : 100, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'94c98cc7-f7a2-41a4-aead-ffd94329720c'},{display: '姓名', name : 'EMPLOYNAME', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'cbd0dbc0-250c-451d-b85c-4168fa90f29d'},{display: '开始时间', name : 'STARTDATE', width : 120, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'ee67807c-0aee-442a-96f3-8ebe1bf71907'},{display: '结束时间', name : 'ENDDATE', width : 120, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'3b749965-2354-4af9-9fc0-41a08239b3ae'},{display: '请假类型', name : 'QJTYPE', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'20b576aa-bbdb-4f89-91b0-8e6ca1127d3a'},{display: '请假时长', name : 'CALCULATESUM', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'34bc35f1-5361-408b-853c-2475c35fe253'},{display: '操作', name : 'DO', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'dbcd1d47-cfd8-49a8-8743-3d829bced30d'},{display: '创建时间', name : 'CREATEDATE', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'ccde9894-3119-4317-813a-f8d8b78341b0'},{display: '当前年份', name : 'THISYEAR', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'9f0f0591-b388-4f4a-9a61-ed6c836e2cf8'},{display: '上一年份', name : 'LASTYEAR', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'9705716d-9cc0-4b36-a268-eeef9279d246'},{display: '上一年寒暑假总天数', name : 'YYEARDATELY', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'33ad0a24-12ea-434b-a35b-9e3c11fd470a'},{display: '上一年剩余寒暑假', name : 'SYEARDATELY', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'2f738b98-14b5-43ce-a02a-489cafc37686'},{display: '下一年份', name : 'NEXTYEAR', width : 80, sortable :true, align: 'left',hide:false,renderer:false,fieldid:'21abf83e-108f-49a9-95a2-a80ebb6de471'},{display: '下一年寒暑假总天数', name : 'YYEARDATENY', width : 80, sortable :true, align: 'right',hide:false,renderer:false,fieldid:'9749155e-bc88-4903-9478-27c160e26e41'},{display: '下一年剩余寒暑假', name : 'SYEARDATENY', width : 80, sortable :true, align: 'right',hide:false,renderer:false,fieldid:'f141f2d7-e685-4822-899f-935f0a0e1f3a'},{display: '流程状态', name : '_wfstate', width : 90, sortable :true, align: 'left',hide:false,renderer:wfStateRender,fieldid:''}],
	    
	    buttons : [
		    {name: '添加', bclass: 'add', onpress : app_add , hidden : 0},
		    {name: '编辑', bclass: 'edit', onpress : app_edit , hidden : 0},
		    {name: '复制', bclass: 'copy', onpress : app_copy , hidden : 0},
		    {name: '删除', bclass: 'delete', onpress : app_delete , hidden : 0},
		    {separator: true},
		    {name: '查询', bclass: 'view', onpress : app_query},
		    {name: '清空', bclass: 'clear', onpress : app_reset},
		    {name: '查询定制', bclass: 'setting', onpress : app_setquery, hidden : 0},
		    {name: '保存布局', bclass: 'layout', onpress : app_layout, hidden : 0},
            {separator: true},
            {name: '导出', bclass: 'excel', title:'', onpress : app_export , hidden: 0},
            {name: '导入', bclass: 'excel', title:'从EXCEL文件导入数据', onpress : app_import , hidden: 0},
            {name: '归档', bclass: 'folder', onpress : app_archive , hidden: 1}
		    ],
		    
		    
		    searchitems : [
				{display: 'ISO', name : 'iso'},
				{display: 'Name', name : 'name', isdefault: true}
				],
		    
		    /*
	    searchitems :[
		    {display: '开始时间', name : 'STARTDATE', type: 4, defvalue:'',match:''},
		    {display: '结束时间', name : 'ENDDATE', type: 4, defvalue:'',match:''},
		    {display: '请假类型', name : 'QJTYPE', type: 1, edit:'select',data:'病假|病假,事假|事假,婚假|婚假,丧假|丧假,产假|产假,探亲假|探亲假,寒暑假|寒暑假,出国|出国,调休假|调休假',defvalue:''},
		    {display: '类型', name : 'HEADTYPE', type: 1,defvalue:'',match:''},
		    {display: '申请单号', name : 'QHNO', type: 1,defvalue:'',match:''}
		    ],
		    */
	    sortname: "QHNO",
	    sortorder: "desc",
	    usepager: true,
	    singleSelect:true,
	    useRp: true,
	    rp: 15,
	    multisel:false,
	    showTableToggleBtn: false,
	    resizable:false,
	    height: 'auto',
	    onError:showError,
	    preProcess:processData,
	    onColResize:fnColResize
	    }
	);
}


function colIndex(fldval,row)
    {
        var autoid=$(row).attr("id");
        return "<a href=\"AppDetail.aspx?tblName=OA_QINGJIA&sindex=&mainid="+autoid+"\" target='_blank'>"+fldval+"</a>";
    }
    function app_view()
    {
                
    }
    function app_wfinfo(mainId)
    {
        var url = "AppWorkFlowInfo.aspx?tblName=OA_QINGJIA&mainId=" + mainId;
		openCenter(url,"_blank",1000,700);
    }

	function app_setquery()
	{
		openCenter("AppConditionDef.aspx?tblname=OA_QINGJIA&sindex=","_blank",400,500);
	}

	function app_query()
	{
		$("#flex1").flexReload();
	}
    function clearSelection() {
        if(document.selection && document.selection.empty) {document.selection.empty();}else if(window.getSelection) {window.getSelection().removeAllRanges();}
    }
	function openCenter(url,name,width,height)
    {
	    var str = "height=" + height + ",innerHeight=" + height + ",width=" + width + ",innerWidth=" + width;
	    if (window.screen)
	    {
		    var ah = screen.availHeight - 30;
		    var aw = screen.availWidth - 10;
		    var xc = (aw - width) / 2;
		    var yc = (ah - height) / 2;
            if (yc < 0)
		        yc = 0;
		    str += ",left=" + xc + ",screenX=" + xc + ",top=" + yc + ",screenY=" + yc;
		    str += ",resizable=yes,scrollbars=yes,directories=no,status=no,toolbar=no,menubar=no,location=no";
	    }
	    return window.open(url, name, str);
    }
    var _sIndex="";
    var _funId="";
    function app_add(cmd, grid) {
    if (_sIndex == 2) {
        openCenter("../workflow/NewFlow.aspx?workflowCode=HRP_QJ_YG&_rnd=" + Math.random(), "_blank", 1000, 700);
    }
    if (_sIndex == 4) {
        openCenter("../workflow/NewFlow.aspx?workflowCode=HRP_QJ_GR&_rnd=" + Math.random(), "_blank", 1000, 700);
    }
}
function fnSel(v, row) {
    var str = new Array();
    var autoid = $(row).attr("id"); //主键

    var status = $("STATUS", row).text(); //销假状态(1:未销假 0:已销假)
    var startDate = $("STARTDATE", row).text(); //销假状态(1:未销假 0:已销假)
    var flowState = $("_wfstate", row).text(); //流程表单提交状态


    if (flowState.indexOf("处理中") >= 0) {
        //str.push("<a href=\"javascript:app_wfinfo('" + autoid + "')\">查看</a>");
    }
    else {
        if (flowState.indexOf("完成") >= 0) {
            if (status == "1") {
                //str.push("<a href=\"javascript:app_wfinfo('" + autoid + "')\">查看</a>");
                str.push("<a href=\"javascript:qj_xiaojia('" + autoid + "','" + flowState + "','" + startDate + "')\">销假</a>");
            }
            else {
                //str.push("<a href=\"javascript:app_wfinfo('" + autoid + "')\">查看</a>");
                str.push("<span style='color:blue;'>已销假</span>");
            }
        }
        else {
            //str.push("<a href=\"javascript:app_wfinfo('" + autoid + "')\">查看</a>");
            if (flowState.indexOf("终止") >= 0 && status == "0") {
                str.push("<span style='color:blue;'>已销假</span>");
            }
            str.push("<a href=\"javascript:del('" + autoid + "','" + flowState + "');\">删除</a>");

        }
    }
    return str.join("|");
}

function qj_xiaojia(id, flowState, startDate) {
    if (!!confirm('确定销假吗?')) {
        if (flowState.indexOf("完成") >= 0) {
            var date = new Date();
            //var date1 = date.getFullYear() + '-' + (date.getMonth()+1) + '-' + date.getDate() + ' ' + date.getHours() + ':' + date.getMinutes();
            //var guoqi = compareDate(date1, startDate);
          	var guoqi = compareDate(date, startDate);
            if (guoqi) {
                alert("日期已过，不能销假！！");
            } else {
                var keys = [];
                keys.push("@autoid=" + id);
                _curClass.ExecSQL("qj_xiaojia", keys.join("|"));
                alert("销假成功！！");
                app_query();
            }
        }

    }
}

function del(id, flowState) {
    if (flowState.indexOf("处理中") >= 0) {
        alert("删除出错：本条记录已经提交，无法删除！");
        return;
    }
    if (!!confirm('确定删除这条记录吗?')) {
        var ret = _curClass.DelRecord("oa_qingjia", id);
        if (ret.error) {
            alert("删除出错：" + ret.error.Message);
        }
        else {
            $.noticeAdd({ text: '删除成功！' });
            $("#flex1").flexReload();
        }
    }
}

function compareDate(DateOne, DateTwo) {
    var str = "-";
      
    var OneMonth = DateOne.getMonth()+1;
    var OneDay = DateOne.getDate();
    var OneYear = DateOne.getFullYear();
    var OneHours = DateOne.getHours();
    var OneMinutes = DateOne.getMinutes();
  
    var sOneMonth = OneMonth.toString();
    var sOneDay = OneDay.toString();
    var sOneYear = OneYear.toString();
    var sOneHours = OneHours.toString();
    var sOneMinutes = OneMinutes.toString();
    if (OneMonth<10)
    {
      sOneMonth="0"+sOneMonth;
    }
  	if (OneDay<10)
    {
      sOneDay="0"+sOneDay;
    }
  	if (OneHours<10)
    {
      sOneHours="0"+sOneHours;
    }
  	if (OneMinutes<10)
    {
      sOneMinutes="0"+sOneMinutes;
    }

    var TwoMonth = DateTwo.substring(5, DateTwo.lastIndexOf(str));
    var TwoDay = DateTwo.substring(DateTwo.lastIndexOf(str) + 1, 10);
    var TwoYear = DateTwo.substring(0, DateTwo.indexOf(str));
    var TwoHours = parseInt(DateTwo.substring(11, 13));
    var TwoMinutes = parseInt(DateTwo.substring(14, 16));
  	
  	if (Date.parse(sOneMonth + "/" + sOneDay + "/" + sOneYear ) >
        Date.parse(TwoMonth + "/" + TwoDay + "/" + TwoYear)) {
        return true;
    }
    else if (Date.parse(sOneMonth + "/" + sOneDay + "/" + sOneYear ) ==
        Date.parse(TwoMonth + "/" + TwoDay + "/" + TwoYear)) {
        if (OneHours>TwoHours){
          	return true;
        }
        else if (OneHours==TwoHours){
            if (OneMinutes>TwoMinutes){
            	return true;
            }
            else{
            	return false;
            }
        }
        else{
          	return false;
        }
        
        
    }
    else {
        return false;
    }

}
function app_wfinfo(autoid) {
    var url = "AppWorkFlowInfo.aspx?tblName=OA_QINGJIA&mainId=" + autoid;
    openCenter(url, "_blank", 1000, 700);
}

function wfStateRender(){}

function app_edit(){}

function app_copy(){}

function app_delete(){}

function app_query(){}


function app_reset(){}

function app_setquery(){}



function app_layout(){}

function app_export(){}

function app_import(){}

function app_archive(){}

function showError(){}

function processData(data)
	{
		return xmlData=jQuery(data);
	}

function fnColResize(){}
</script>
</head>
<body>
	
	
	<form method="post" action="AppDefault.aspx?tblname=OA_QINGJIA&amp;t=1&amp;admin=1&amp;rnd=0.678883081140315" id="form1">
		<div class="aspNetHidden">
			<input type="hidden" name="__VIEWSTATE" id="__VIEWSTATE" value="64YlMk+WNBY8dGggsd+5N4zb5XyqbuMhCL2eEtarMOq9ld7GT7lkWN2itkfQtOam/Go75lQY4kT0j3bJegcCXOUbRUaHrovSiXAsg8oKKPlMcLjkmuPXkjmMrBU=" />
		</div>



	    <div id="griddiv" >
	        <table id="flex1" style="display:none"></table>    
	    </div>
    </form>
	
</body>
</html>