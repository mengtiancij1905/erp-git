/**
 * 生成一个span标签，并且span标签中的内容是ajax执行后返回内容
 * @param url 请求的地址
 * @param value 传递的数据
 * @param id 
 * @param key 
 * @returns
 */
function ajax(url, value,id, key){
	if(value!=null){
		$.ajax({
			url:url+value,
			dataType:'json',
			success:function(val){
				$("#"+id).html(val[key]);
			}
		});
	}
	return "<span id='"+id+"'></span>";
}