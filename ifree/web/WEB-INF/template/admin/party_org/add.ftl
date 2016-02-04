<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新增党组织</title>
<#include "admin/common/common-new.ftl">
<script type="text/javascript" src="${base}/resources/admin/js/jquery.validate.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/input.js"></script>
<script type="text/javascript" src="${base}/resources/admin/plugins/datePicker/WdatePicker.js"></script>
<script type="text/javascript">
$().ready(function() {
	var $inputForm = $("#inputForm");
	
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
	</div>
	<form id="inputForm" action="save.do" method="post">
		<table class="input">
			<tr>
				<th>
					<span class="requiredField">*</span>党支部名称:
				</th>
				<td>
					<input type="text" name="orgName" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					党员人数:
				</th>
				<td>
					<input type="text" name="partyMemberNum" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					党支部书记:
				</th>
				<td>
					<input type="text" name="secretary" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					党支部副书记:
				</th>
				<td colspan="4">
					<input type="text" name="deputySecretary" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					党支部委员:
				</th>
				<td>
					<input type="text" name="committeeMember" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					本届支部换届时间:
				</th>
				<td colspan="4">
					<input class="Wdate text" type="text" value="" id="changeDate" name="changeDate" onFocus="WdatePicker()"/></li>
				</td>
			</tr>
			<tr>
				<th>
					党小组数:
				</th>
				<td colspan="4">
					<input type="text" name="teamNum" class="text" maxlength="200" />
				</td>
			</tr>
			<tr>
				<th>
					附件:
				</th>
				<td colspan="4">
					<script id="editor" name="attachment" type="text/plain" class="editor edui-default" style="width:900px;height:100px;"></script>
				</td>
			</tr>
			<tr>
				<th>
					备注:
				</th>
				<td>
					<textarea id="description" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<th>
					&nbsp;
				</th>
				<td>
					<input type="submit" class="submit" value="提交" />
					<input type="button" class="back" value="返回" onclick="location.href='list.do'" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>