/*var pageCurrent = 1;
var pageCount;
function clear(){
	$("#tbodyId").empty();
}

$(function(){
	doGetObjects(1);
	$(".first").click(function(event){
		event.stopPropagation();
		$(".pageCurrent").html("当前页(1)");
		clear();
		doGetObjects(1);
	});
	$(".pre").click(function(event) {
		event.stopPropagation();
		prePage();
	});
	$(".next").click(function(event) {
		event.stopPropagation();
		nextPage();
	});
	$(".last").click(function(event){
		event.stopPropagation();
		$(".pageCurrent").html("当前页(" + pageCount + ")");
		clear();
		doGetObjects(pageCount);
	});
});
function prePage() {
	var pre = pageCurrent - 1 ;
	if(pre < 1) {
		return false;
	}else{
		clear();
		$(".pageCurrent").html("当前页(" + pre +")");
		pageCurrent--;
		doGetObjects(pre);
	}
}
function nextPage() {
	var next = pageCurrent + 1;
	if(next > pageCount) {
		return false;
	}else{
		clear();
		$(".pageCurrent").html("当前页(" + next +")");
		pageCurrent ++;
		doGetObjects(next);
	}
}*/
$(function() {
	doGetObjects();
	$("#queryFormId").on("click",".btn-search",doQueryObjects);//如果给某个函数加括号，表示执行这个函数，绑定事件时要注意。
});
function doQueryObjects(){
	//1.初始化当前页码
	$("#pageId").data("pageCurrent",1);
	doGetObjects();
	//2.执行查询操作。
	//2.1获得表单数据。
	//2.2提交表单数据。
}
function getQueryFormData(){
	var params = {
			name : $("#searchNameId").val(),
			valid : $("#searchValidId").val()
	}
	return params;
}
function doGetObjects() {
	var pageCurrent=$('#pageId').data("pageCurrent");
	//获取表单数据，查询时使用
	var params = getQueryFormData();
	if(!pageCurrent) pageCurrent=1;
	params.pageCurrent=pageCurrent;
	var url = "project/doFindPageObjects.do";
	$.ajax({
		"url" : url,
		"type" : "post",
		"datatype" : "json",
		"data" : params,
		"success" : function(data){
//			console.log(data);
//				$(".content").html(data);
			setTableBodyRows(data);
		},
		"error" : function(status) {
			console.log("状态码 " + status + ",加载列表失败");
			
		}
		
	}
	/*
	$.getJSON(url,function(result) {
		console.log(result);
		setTableBodyRows(result);
	});*/
	
	);
	function setTableBodyRows(result) {
		var tBody=$("#tbodyId");
		var list = result.list;
		var pageObject = result.pageObject;
		setPagination(pageObject);
		console.log(pageObject);
		tBody.empty();
		for(var x in list) {
			var tr = $("<tr/>");
			var tds = "<td><input type='checkbox' name='checkItem'></td>" + 
						"<td>" + list[x].code + "</td>" + 
						"<td>" + list[x].name + "</td>" + 
						"<td>" + list[x].beginDate+    "</td>" + 
						"<td>" + list[x].endDate + "</td>" + 
						"<td>" + (list[x].valid?"启用" : "禁用") + "</td>" + 
						"<td><a href='javascript:void(0)'>修改</a></td>";
			tr.append(tds);
			tBody.append(tr);
		} 
	}
	
}

/*function doGetObjects1(){
	console.log("doGetObjects1");
	var url = "project.doFindPageObjects.do";
	var param = {pageCurent:1};
	$.getJSON
	
}

function page(pageObject){
		$(".pageCount").html("总页数(" + pageObject.pageCount+ ")");
		pageCount = pageObject.pageCount;
}

*/