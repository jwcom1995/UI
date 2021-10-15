/**
 * 
 */

$(function(){
	parseJson();
});


function parseJson(){
	$.getJSON("./json/bike.json",function(data){
		$.ajax({
			url:"bike.do?command=second_db",
			method:"post",
			//String으로 변환 JSON.stringify
			data:{"obj":JSON.stringify(data)},
			success:function(msg){
				alert(msg);
				
				if(msg>0){
					$.each(data,function(key,val){
			if(key=="DESCRIPTION"){
				$("table").attr("border","1");
				$("thead").append(
					"<tr>"+
					"<th>"+val.ADDR_GU+"</th>"+
					"<th>"+val.CONTENT_ID+"</th>"+
					"<th>"+val.CONTENT_NM+"</th>"+
					"<th>"+val.NEW_ADDR+"</th>"+
					"<th>"+val.CRADLE_COUNT+"</th>"+
					"<th>"+val.LONGITUDE+"</th>"+
					"<th>"+val.LATITUDE+"</th>"+
					"</tr>"
				);
			} else{
				var list=val;
				for(var i =0 ; i<list.length;i++){
					//str: 배열안에 있는 json
					var str=list[i];
					$("tbody").append(
						"<tr>"+
						"<td>"+str.addr_gu+"</td>"+
						"<td>"+str.content_id+"</td>"+
						"<td>"+str.content_nm+"</td>"+
						"<td>"+str.new_addr+"</td>"+
						"<td>"+str.cradle_count+"</td>"+
						"<td>"+str.longitude+"</td>"+
						"<td>"+str.latitude+"</td>"+
						"<input type='hidden' name='bike' value='"+
						str.addr_gu+"/"+str.content_id+"/"+str.content_nm+"/"+str.new_addr+"/"+
						str.cradle_count+"/"+str.longitude+"/"+str.latitude+
						"'/>"+
						"</tr>"
					);
				}
			}
		});
				}else{
					alert("data 저장 실패");
				}
			},
			error:function(){
				alert("통신 실패");
			}
		});
	});
}