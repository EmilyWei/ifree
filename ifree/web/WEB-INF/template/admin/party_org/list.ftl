<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>党组织列表</title>
<#include "admin/common/common-new.ftl">
<script type="text/javascript" src="${base}/resources/admin/js/common.js"></script>
<script type="text/javascript" src="${base}/resources/admin/js/list.js"></script>
<script type="text/javascript" src="${base}/resources/admin/plugins/datePicker/WdatePicker.js"></script>
<script type="text/javascript">
$().ready(function() {
	<#assign dateFormat = "yyyy-MM-dd" />
	iframeJs();
	<@flash_message />
});
</script>
</head>
<body>
	<div class="path">
		<a href="${base}/admin/common/index.do">${message("admin.path.index")}</a> &raquo;组织列表 <span>(${message("admin.page.total", page.total)})</span>
	</div>
	<form id="listForm" action="list.do" method="get">
		<div class="search">
			<ul>
		        <li class="title">党支部名称：</li>
		        <li><input type="text" name="orgName"  value="${partyOrg.orgName}" class="first" /></li>
		        <li class="title">党支部书记：</li>
		        <li><input type="text" name="secretary"  value="${partyOrg.secretary}" class="second" /></li>
		        <li class="title">党支部副书记：</li>
		        <li><input type="text" name="deputySecretary"  value="${partyOrg.deputySecretary}" class="third" /></li>
			</ul>
			<ul>
		        <li class="title">党支部委员:：</li>
		        <li><input type="text" name="committeeMember"  value="${partyOrg.committeeMember}" class="first" /></li>
		        <li class="title">支部换届时间：</li>
		        <li><input class="Wdate second" type="text" value="<#if startDate??>${startDate?string(dateFormat)}</#if>" id="startDate" name="startDate" onFocus="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'2020-10-01\'}'})"/></li>
		        <li class="title">到：</li>
		        <li><input class="Wdate third" type="text" value="<#if endDate??>${endDate?string(dateFormat)}</#if>" id="endDate" name="endDate" onFocus="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'2020-10-01'})"/></li>
			</ul>
			<ul>
		        <li class="title">&nbsp;</li>
		        <li>
		            <input type="submit" value="搜索" class="btnSubmit" />
		        </li>
		    </ul>
		</div>
		<div class="toolbar">
			<div class="btn-group btn-group" role="group" aria-label="...">
				<a href="add.do" class="btn btn-primary" role="button">
					<span class="glyphicon glyphicon-plus-sign" aria-hidden="true">&nbsp;${message("admin.common.add")}</span>
				</a>
				<button type="button" id="deleteButton" class="btn btn-primary disabled">
					<span class="glyphicon glyphicon-trash" aria-hidden="true">&nbsp;${message("admin.common.delete")}</span>
				</button>
				<button type="button" id="refreshButton" class="btn btn-primary">
					<span class="glyphicon glyphicon-refresh" aria-hidden="true">&nbsp;${message("admin.common.refresh")}</span>
				</button>
				<div class="btn-group btn-group" role="group"  aria-label="...">
					<button type="button" id="pageSizeSelect" class="btn btn-info dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					  <span class="glyphicon glyphicon-triangle-bottom" aria-hidden="true">${message("admin.page.pageSize")}<span class="caret"></span></span>
					</button>
					<ul id="pageSizeOption" class="dropdown-menu">
					  <li><a href="javascript:;"<#if page.pageSize == 10>  class="btn btn-primary"</#if> val="10">10</a></li>
					  <li><a href="javascript:;"<#if page.pageSize == 20>  class="btn btn-primary"</#if> val="20">20</a></li>
					  <li><a href="javascript:;"<#if page.pageSize == 50>  class="btn btn-primary"</#if> val="50">50</a></li>
					  <li><a href="javascript:;"<#if page.pageSize == 100>  class="btn btn-primary"</#if> val="100">100</a></li>
					</ul>
				</div>
			</div>
		</div>
		<table id="listTable" class="list">
			<tr>
				<th class="check">
					<input type="checkbox" id="selectAll" />
				</th>
				<th>
					<a href="javascript:;" class="sort" name="orgName">党支部名称</a>
				</th>
				<th>
					<a href="javascript:;" class="sort" name="partyMemberNum">党员人数</a>
				</th>
				<th>
					<a href="javascript:;" class="sort" name="secretary">党支部书记</a>
				</th>
				<th>
					<a href="javascript:;" class="sort" name="deputySecretary">党支部副书记</a>
				</th>
				<th>
					<a href="javascript:;" class="sort" name="committeeMember">党支部委员</a>
				</th>
				<th>
					<a href="javascript:;" class="sort" name="changeDate">本届支部换届时间</a>
				</th>
				<th>
					<a href="javascript:;" class="sort" name="teamNum">党小组数</a>
				</th>
				<th>
					<span>${message("admin.common.handle")}</span>
				</th>
			</tr>
			<#list page.content as partyOrg>
				<tr>
					<td>
						<input type="checkbox" name="ids" value="${partyOrg.id}" />
					</td>
					<td>
						${partyOrg.orgName}
					</td>
					<td>
						${partyOrg.partyMemberNum}
					</td>
					<td>
						${partyOrg.secretary}
					</td>
					<td>
						${partyOrg.deputySecretary}
					</td>
					<td>
						${partyOrg.committeeMember}
					</td>
					<td>
						<span title="<#if partyOrg.changeDate??>${partyOrg.changeDate?string("yyyy-MM-dd")}</#if>">${partyOrg.changeDate}</span>
					</td>
					<td>
						${partyOrg.teamNum}
					</td>
					<td>
						<div align="center" class="operation">
							<a class="edit" href="edit.do?id=${partyOrg.id}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span><a>
						</div>
					</td>
				</tr>
			</#list>
		</table>
		<@pagination pageNumber = page.pageNumber totalPages = page.totalPages>
			<#include "/admin/include/pagination-new.ftl">
		</@pagination>
	</form>
</body>
</html>