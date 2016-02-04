<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>列表</title>

<link type="text/css" rel="stylesheet" href="${base}/resources/dotnet/css/appInput.css" />

<link rel="stylesheet" type="text/css" href="${base}/resources/css/flexigrid/flexigrid.css">

<script type="text/javascript" src="${base}/resources/js/jquery.js"></script>

<script type="text/javascript" src="${base}/resources/js/flexigrid.pack.js"></script>


<style type="text/css">
        #bottomToolbar{
	        width:100%; height:40px; line-height:40px;
	        background:white url(../../img/common/topbar.gif); 
	        border-top:2px solid #708090;
	        position:fixed; bottom:0; left:0;
	        _position:absolute; 
        }
        #bottomToolbar a{ color:blue;}
        #maindiv{padding-bottom:50px;padding-top:20px;}
    </style>

<body>

	<div class="menubar">
        <div class="topnav">
            <span style="right:10px;display:inline;float:right;position:fixed;line-height:30px;top:0px;">
                <a class='linkbtn' href="javascript:" onclick="_appSaveAdd();" id="btnSaveAdd" name="btnSaveAdd">保存后新增</a>
				<em class="split">|</em>
                <a class='linkbtn' href="javascript:" onclick="_appSave();"  id="btnSave" name="btnSave">保存</a>
                <em class="split" style="">|</em>
                <a id="btnStartWF" href="javascript:__doPostBack(&#39;btnStartWF&#39;,&#39;&#39;)" style="display:;">发起流程</a>
				<em class="split">|</em>
                <a class='linkbtn' style="" href="javascript:" onclick="_appDirection();"  id="btnDirection" name="btnDirection">填报说明</a>
				<em class="split">|</em>
                <a class='linkbtn' href="javascript:" onclick="_appClose();" id="btnClose" name="btnClose">关闭</a>
            </span>
        </div>
    </div>

 <div id="maindiv">
 	${form}
 </div>	
</body>
</html>



    <script type="text/javascript">
        $("dl").KandyTabs({ trigger: "click" });
        jQuery(function(){
            $(".btn01").hover(function(){
                this.className="btn02";
            },function(){
                this.className="btn01";
            });
            if(!_isNew)
            {
                jQuery("#btnSaveAdd").prev().andSelf().hide();
            }
            /*
            $(window).resize(function(){
                $("#maindiv").height($(document.body).height()-75);
            });
            $("#maindiv").height($(document.body).height()-75);
            */
            $("#btnStartWF").click(_appStartWF);
		});


        //保存数据
        function _appSave()
        {   
            //平台保存函数
            var safe = false;
            try {safe = _sysSave();} catch (err) {alert("提交过程中出现异常：" + err.message + "\r\n请尝试重新提交，或者联系管理员。");}

            if(safe)
            { 
                $.noticeAdd({ text: '保存成功！',stayTime:500,onClose:function(){

                    if(!!frameElement){
                        if(!!frameElement.lhgDG){
                            frameElement.lhgDG.curWin.app_query("OA_QINGJIA");
                            frameElement.lhgDG.cancel();
                        }
                        else{
                	        try { window.opener.app_query("OA_QINGJIA"); } catch (e) {}
	                        window.close();
                        }
                    }
                    else{
                	    try { window.opener.app_query("OA_QINGJIA"); } catch (e) {}
	                    window.close();
                    }

                }});

            }
        }

        //刷新关联主表列表
        function app_query(tName){
            var listHtml = _curClass.GetListHtml("OA_QINGJIA",tName,_mainId,_sIndex).value;
            $("#"+tName).before(listHtml).remove();
        }

        //保存数据,发起流程
        function _appSubmit()
        {
            if(!confirm("您确认提交审批吗?")){
                return false;
            }

            var safe = false;
            try { safe = _sysSave(); } catch (err) {alert("提交过程中出现异常：" + err.message+"\r\n请尝试重新提交，或者联系管理员。");}

            if(safe)
            { 
                var url = "";
                
                if(''=='2'){
                    __doPostBack('btnStartWF','');
                }
                else{
                    if("" == ""){
                        url = "../Workflow/SelectWorkFlow.aspx?tblName=OA_QINGJIA&mainId=ef7a96fa-b71f-49d8-87e2-b9a4174b5a4f";
                        window.location.href=url;
                    }
                    else{
                        url = "../workflow/NewFlow.aspx?workflowCode=&mainId=ef7a96fa-b71f-49d8-87e2-b9a4174b5a4f";
                        window.location.href=url;
                    }
                }


            }
        }

        //保存数据,发起流程
        function _appStartWF()
        {
            if(!confirm("您确认提交审批吗?")){
                return false;
            }   
            //平台保存函数
            if(_sysSave())
            { 
                var url = "";
                if("" == ""){
                    if(''=='2'){
                        return true;
                    }
                    else{
                        url = "../Workflow/SelectWorkFlow.aspx?tblName=OA_QINGJIA&mainId=ef7a96fa-b71f-49d8-87e2-b9a4174b5a4f";
                        window.location.href=url;
                        return false;
                    }
                }
                else{
                    url = "../workflow/NewFlow.aspx?workflowCode=&mainId=ef7a96fa-b71f-49d8-87e2-b9a4174b5a4f";
                    window.location.href=url;
                }

            }
            else{
                return false;
            }
        }

        //查询填报说明
        function _appDirection() {
            var dlg = new $.dialog({ title: '[请假表] 填报说明', page: 'AppDirection.aspx?tblName=OA_QINGJIA'
                , btnBar: true, cover: true, lockScroll: true, width: 800, height: 600, bgcolor: 'gray', cancelBtnTxt: '关闭',
                onCancel: function () {
                }
            });
            dlg.ShowDialog();
        }

        //保存数据，新增
        function _appSaveAdd()
        {   
            //平台保存函数
            if(_sysSave())
            {
                try { window.opener.app_query();} catch (e) {}
                window.location.href = window.location.href;
            }
        }
        //返回列表
        function _appBack(){
            window.history.back();
        }
        //关闭窗口
        function _appClose(){
            if(!!frameElement){
                if(!!frameElement.lhgDG)
                    frameElement.lhgDG.cancel();
                else
                    window.close();
            }
            else{
                window.close();
            }
        }
        var _curClass =EIS.WebBase.SysFolder.AppFrame.AppInput;
        var _isNew = false;
        var _mainTblName = "${businessName}";
        var _mainId = "ef7a96fa-b71f-49d8-87e2-b9a4174b5a4f";
        var _sIndex = "";
        var _saveAction = "1";
        var _workflowCode ="";
        var _nodeCode ="";
        var _nodeId ="";
        
        var _sysModel = ${sysModel};

        var _xmlData =jQuery(jQuery.parseXML('<xml><root><Table TableName="OA_QINGJIA" Sindex=""><row id="" state="Unchanged"><_AutoID><![CDATA[ef7a96fa-b71f-49d8-87e2-b9a4174b5a4f]]></_AutoID><_UserName><![CDATA[b0a509bc-cbff-4599-9bdf-6772d87b64a3]]></_UserName><_OrgCode><![CDATA[00014]]></_OrgCode><_CreateTime><![CDATA[2016/1/8 10:58:25]]></_CreateTime><_UpdateTime><![CDATA[2016/1/8 10:58:25]]></_UpdateTime><_IsDel><![CDATA[0]]></_IsDel><_CompanyID><![CDATA[6A5DF65B-F037-4EF8-B4E2-9EF8B19C0339]]></_CompanyID><_WFState><![CDATA[终止]]></_WFState><_GDState><![CDATA[]]></_GDState><_WFCurNode /><_WFCurUser /><EMPLOYNAME><![CDATA[王志强]]></EMPLOYNAME><EMPLOYN0><![CDATA[04046]]></EMPLOYN0><DEPTID><![CDATA[303]]></DEPTID><DEPTNAME><![CDATA[党委院长办公室]]></DEPTNAME><STARTDATE><![CDATA[2016-01-08 10:59]]></STARTDATE><ENDDATE><![CDATA[2016-01-11 10:59]]></ENDDATE><QJTYPE><![CDATA[寒暑假]]></QJTYPE><USERDESC><![CDATA[1]]></USERDESC><APDESC><![CDATA[]]></APDESC><TASKID><![CDATA[]]></TASKID><PROCESSID><![CDATA[]]></PROCESSID><HEADTYPE><![CDATA[个人请（休）假]]></HEADTYPE><WCLOCATION><![CDATA[是]]></WCLOCATION><QHNO><![CDATA[QJ1601080002]]></QHNO><STATUS><![CDATA[1]]></STATUS><CREATEDATE><![CDATA[]]></CREATEDATE><WORKNAME><![CDATA[]]></WORKNAME><DATESUM><![CDATA[]]></DATESUM><YYEARDATE><![CDATA[15.0]]></YYEARDATE><SYEARDATE><![CDATA[12天5小时]]></SYEARDATE><DATELENGT><![CDATA[]]></DATELENGT><TXJTYPE><![CDATA[]]></TXJTYPE><QINGJIASUM><![CDATA[]]></QINGJIASUM><CALCULATESUM><![CDATA[1天1小时]]></CALCULATESUM><DO><![CDATA[]]></DO><MARK><![CDATA[]]></MARK><DEPUTY><![CDATA[]]></DEPUTY><CHOOSEDZBPLANID><![CDATA[]]></CHOOSEDZBPLANID><THISYEAR><![CDATA[2016]]></THISYEAR><LASTYEAR><![CDATA[2015]]></LASTYEAR><YYEARDATELY><![CDATA[0.0]]></YYEARDATELY><SYEARDATELY><![CDATA[0天]]></SYEARDATELY><NEXTYEAR><![CDATA[2017]]></NEXTYEAR><YYEARDATENY><![CDATA[0.0]]></YYEARDATENY><SYEARDATENY><![CDATA[0天]]></SYEARDATENY></row></Table></root></xml>'));
    </script>
    <script src="${base}/resources/dotnet/js/SysFunction.js?v=635790396545939010" type="text/javascript"></script>
        <script type="text/javascript">
${scriptlet}
</script>
