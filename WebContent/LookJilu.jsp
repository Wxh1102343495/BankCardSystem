<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" href="#" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/first.css">
<script type="text/javascript" src="js/jquery-3.2.1.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<title>首页</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-3">
				<%@ include file="left.jsp" %>
			</div>
			<div class="col-md-7">
				<div class="panel panel-default panel-primary">
					<div class="panel-heading">交易记录查询</div>
					<div class="panel-body">
						<form>
							<div class="form-group">
								<label>选择卡号:</label>
								<select id="select" style="width:200px;height:20px">
									
								</select>
							</div>
							<button type="button" class="btn btn-primary" id="findok">查询</button>
						</form>
					</div>
					<table class="table">
					<thead>
						<tr>
							<th>卡号</th>
							<th>交易时间</th>
							<th>交易金额</th>
							<th>交易类型</th>
						</tr>
					</thead>
					<tbody id="tb2">
					
					</tbody>
				  </table>
				</div>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>
	<!-- 模态框 -->
	<div class="modal fade" tabindex="-1" id="modal-error">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">提示</h4>
				</div>
				<div class="modal-body">
					<p>失败!</p>
				</div>	
			</div>
		</div>
	</div>
	<div class="modal fade" tabindex="-1" id="modal-success">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
					<h4 class="modal-title">提示</h4>
				</div>
				<div class="modal-body">
					<p>成功!</p>
				</div>	
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function(){
			$.getJSON("LookCard.do",function(data){
				$.each(data,function(i,s){
					$("<option>"+s.CardId+"</option>").appendTo("#select");
				})
			})
			$("#findok").click(function(){
				$("#tb2").empty();
				var findjilu=$("#select option:selected").val();
				if(findjilu!=""){
					$.getJSON("Lookjilu.do",{findjilu:findjilu},function(data){
						console.log(data);
						if(data!=null && data!=""){
							$.each(data,function(i,s){
								$tr = $("<tr></tr>");
								$("<td>"+s.cardid+"</td>").appendTo($tr);
								$("<td>"+s.cardtime+"</td>").appendTo($tr);
								$("<td>"+s.cardmoney+"</td>").appendTo($tr);
								$("<td>"+s.type+"</td>").appendTo($tr);
								$tr.appendTo("#tb2");
							})
						}else{
							$('#modal-error').modal('show');
						}
					})
				}else{
					$('#modal-error').modal('show');
				}
			})
		})
	</script>
</body>
</html>
<%@ include file="foot.jsp" %>