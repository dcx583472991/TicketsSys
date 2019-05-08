//根据id删除用户
function DeleteBookInfo(bookId){
	if(confirm("你确定退订该票吗?")){
		location.href="DeleteBookInfoAction?id="+bookId;
	}
}

//修改，现根据id查询用户详细信息，以供修改
function queryBookDetails(bookId){
	//调用queryActionById
	if(confirm("你确定修改该票信息吗?"))
		location.href="QuerryActionById?id="+bookId;
}