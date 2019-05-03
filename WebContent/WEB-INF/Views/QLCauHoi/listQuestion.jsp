<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:WrapperAdmin>
	<div class="row">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<div class="row">

						<div class="col-md-3">
							<h4 class="card-title">Danh sách câu hỏi</h4>
						</div>
					</div>
					<div class="row">

						<div class="col-md-3">
							<a class="btn btn-success col-12"
								href="${pageContext.request.contextPath}/AddQuestion"> <i
								class="fa fa-plus"></i> Add Question
							</a>
						</div>
						<div class="col-md-3">
						
							<a class="btn btn-success col-12"
								href="${pageContext.request.contextPath}/uploadFileControler"> <i
								class="fa fa-plus"></i> Import câu hỏi từ file
							</a>
						</div>

						<div class="navbar navbar-light">
							<form class="form">

								<div class="col-12">
									<div class="input-group mb-3">
										<input class="form-control " type="search"
											placeholder="Search .." aria-label="Search"
											data-toggle="collapse" data-target="#demo"
											name="characterSearch">
										<div class="input-group-append">
											<button class="btn btn-outline-success  py-2 my-sm-0"
												type="submit">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
									<select multiple class="form-control sticky-top" name="sellist2"
										id="resultSearch" hidden="hidden">

									</select>
								</div>
							</form>

						</div>

					</div>
				</div>

				<div class="card-body">
					<div class="table-responsive">

						<table class="table">
							<thead class=" text-primary">
								<tr>
									
									<th width="8%">Mã</th>
									<th>Câu hỏi</th>
									<th width="20%">Câu trả lời</th>
									<th width="20%">Đáp án</th>
									<th width="20%" class="mr-0">Tùy chọn</th>
								</tr>
							</thead>
							<c:forEach items="${list}" var="item">
								<tr>
									<td>${item.questionId}</td>
									<td>${item.question}</td>
									<td>
									
									<c:forEach items="${item.lsAnswer}" var="item1">
								${item1.answer} 
							
								<br />
										
										</c:forEach></td>
										
									<td> <b> ${item.answerCorrect.answer} </b></td>

									<td><a
										href="${pageContext.request.contextPath}/EditQuestion?command=update&id=${item.questionId}"
										class="btn btn-warning"><i class="fa fa-pencil"></i></a> <a
										class="btn btn-danger"
										href="${pageContext.request.contextPath}/EditQuestion?command=delete&id=${item.questionId}">
											<i class="fa fa-trash"></i>
									</a></td>
								</tr>
							</c:forEach>


						</table>

						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<c:forEach var="i" begin="1" end="${numberPage}">
									<li class="page-item"><a class="page-link"
										href="${pageContext.request.contextPath}/ListQuestion?page=${i}">${i}</a>
									</li>
								</c:forEach>

							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
  
		function searchResult(character) {

			$.ajax({
				url : '${pageContext.request.contextPath}/SearchListQuestion',
				data : {
					character : character
				},
				dataType : 'json',
				success : function(data) {
					$("#resultSearch").show();
					var obj = $.parseJSON(data);
					//console.log(obj);
					$.each(obj, function(index, el) {
						var str = el.question.length > 30 ? el.question
								.substring(0, 30) : el.question;
						$("<option id='selected'>" + str + "</option>").appendTo(
								$("#resultSearch"));
					});
				}
			});

			$("#resultSearch").removeAttr("hidden")

		}
		$(document).ready(function() {
			$('#selected').click(function(){
				$("#resultSearch").val($('#selected').text());
			});
			
			$('[name="characterSearch"]').keyup(function(event) {

				if (!$(this).val())
					$("#resultSearch").attr("hidden");
				else {
					$("#resultSearch").empty();
					searchResult($(this).val());
				}
			});
		});
	</script>
</t:WrapperAdmin>