<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>党组织编辑</title>
<#include "admin/common/common-new.ftl">
<script type="text/javascript" src="${base}/resources/admin/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/input.js"></script>
<#include "admin/common/ueditor-common.ftl">
<script type="text/javascript">
$().ready(function() {
	var ue = UE.getEditor('editor');
	var $inputForm = $("#inputForm");
	<@flash_message />
	
	// 表单验证
	$inputForm.validate({
		rules: {
			orgName: "required",
			partyMemberNum: "digits",
			teamNum: "digits"
		}
	});
	
});
</script>
</head>
<body>
	<div class="path">
		<a href="${base}/admin/common/index.do">${message("admin.path.index")}</a> &raquo; 党组织编辑
	</div>
	<form id="inputForm" action="update.do" method="post">
		<input type="hidden" name="id" value="${partyOrg.id}" />
		<table class="input">
			<tr>
				<th>
					党支部名称:
				</th>
				<td>
					<input type="text" name="orgName" value="${partyOrg.orgName}" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					党员人数:
				</th>
				<td>
					<input type="text" name="partyMemberNum" value="${partyOrg.partyMemberNum}" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					党支部书记:
				</th>
				<td>
					<input type="text" name="secretary" value="${partyOrg.secretary}" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					党支部副书记:
				</th>
				<td colspan="4">
					<input type="text" name="deputySecretary" value="${partyOrg.deputySecretary}" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					党支部委员:
				</th>
				<td colspan="4">
					<input type="text" name="committeeMember" value="${partyOrg.committeeMember}" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					本届支部换届时间:
				</th>
				<td>
					<input class="Wdate text" type="text" value="${partyOrg.changeDate}" id="changeDate" name="changeDate" onFocus="WdatePicker()"/></li>
				</td>
			</tr>
			<tr>
				<th>
					党小组数:
				</th>
				<td colspan="4">
					<input type="text" name="teamNum" value="${partyOrg.teamNum}" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					附件:
				</th>
				<td colspan="4">
					<script id="editor" name="attachment" type="text/plain" class="editor edui-default" style="width:900px;height:100px;">${partyOrg.attachment}</script>
				</td>
			</tr>
			<tr>
				<th>
					备注:
				</th>
				<td>
					<textarea id="description" name="description">${partyOrg.description}</textarea>
				</td>
			</tr>
			<tr>
				<th>
					&nbsp;
				</th>
				<td>
					<input type="submit" class="submit" value="${message("admin.common.submit")}" />
					<input type="button" class="back" value="${message("admin.common.back")}" onclick="location.href='list.do'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>