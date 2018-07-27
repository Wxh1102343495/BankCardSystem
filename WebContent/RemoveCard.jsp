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
				<div class="panel panel-default panel-danger">
					<div class="panel-heading">银行卡销毁</div>
					<div class="panel-body">
				   		<button type="button" class="btn btn-danger" id="look">查看</button>
				   		<table class="table">
							<thead>
								<tr>
									<th>卡号</th>
									<th>开户行</th>
									<th>余额</th>
									<th>注销</th>
								</tr>
							</thead>
							<tbody id="tb">
										   
							</tbody>
						</table>
					</div>
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
			$("#look").click(function(){
				$("#tb").empty();
				$.getJSON("LookCard.do",function(data){
					$.each(data,function(i,s){
						$tr = $("<tr></tr>");
						$("<td>"+s.CardId+"</td>").appendTo($tr);
						$("<td>"+s.CardName+"</td>").appendTo($tr);
						$("<td>"+s.CardMoney+"</td>").appendTo($tr);
						$("<td class="+'td'+"><a>"+'注销'+"<a></td>").click(function(){
							var cid=s.Id;
							console.log(cid);
							$.getJSON("RemoveCard.do",{cid:cid},function(da){
								if(da){
									$('#modal-success').modal('show');
									$("#tb").empty();

								}else{
									$('#modal-error').modal('show');
								}
							})
						}).appendTo($tr);
						$tr.appendTo("#tb");
					})
				})
			})
		})
	</script>
</body>
</html>
<%@ include file="foot.jsp" %>