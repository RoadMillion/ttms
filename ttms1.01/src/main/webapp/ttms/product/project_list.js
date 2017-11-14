var pageCurrent = 1;
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
}

function doGetObjects(currentPage) {
	console.log(typeof currentPage);
	var url = "project/doFindPageObjects.do?currentPage=" + currentPage
	$.ajax({
		"url" : url,
		"type" : "get",
		"datatype" : "json",
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
		page(pageObject);
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
function page(pageObject){
		$(".pageCount").html("总页数(" + pageObject.pageCount+ ")");
		pageCount = pageObject.pageCount;
	}


	

	
	
	
	
	
	
	
	
	
	
	
	
}