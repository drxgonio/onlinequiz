<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:WrapperQuiz>
	<!--/ Banner-->
	<!--Feature-->
	<section id="feature" class="section-padding ">
		<div class="container">
			
			<div class="row " style="margin-top: 25px">

				<div class="col-md-8 col-12">

					<!-- Default unchecked -->
					<c:forEach var="i" begin="0" end="${lsQus.size()-1}">
						<div class="panel panel-success">

							<c:if test="${param.page eq null}">
								<div class="panel-heading ">
									câu ${i+1} : ${lsQus.get(i).getQuestion()}
								</div>
							</c:if>
							<c:if test="${param.page>0}">
								<div class="panel-heading ">câu ${(param.page-1)*8+i+1} :
									${lsQus.get(i).getQuestion()}</div>
							
								
							
							</c:if>
						
							<div class="panel-body">

								<ul class="nav flex-column" name="listAnswer">
									<c:forEach items="${lsQus.get(i).lsAnswer}" var="item1">
										<li class="nav-item" style="margin-bottom: 5px">
											<div class="input-group">
												<span class="input-group-addon"> <c:if
														test="${item1.getisTick()}">
														<input type="radio" aria-label="..."
															name="${lsQus.get(i).questionId}"
															tag="${lsQus.get(i).questionId}_${item1.id}"
															style="display: block" checked>
													</c:if> <c:if test="${!item1.getisTick()}">
														<input type="radio" aria-label="..."
															name="${lsQus.get(i).questionId}"
															tag="${lsQus.get(i).questionId}_${item1.id}"
															style="display: block">
													</c:if>
												</span> <input type="text" class="form-control"
													value="${item1.answer}" disabled>
											</div> <!-- /input-group -->
										</li>
									</c:forEach>
								</ul>
							</div>
						</div>

					</c:forEach>

					<!-- 	<div class="row welcome-grids">

						<div class="card-body">
							<form></form>

						</div>

					</div> -->
					<nav aria-label="Page navigation example">
						<ul class="pagination justify-content-center">
							<li class="page-item disabled"><a class="page-link" href="#"
								tabindex="-1">Previous</a></li>
							<c:forEach var="i" begin="1" end="${numberPage}">

								<li class="page-item"><a class="page-link"
									href="${pageContext.request.contextPath}/TestOn?page=${i}">${i}</a></li>
							</c:forEach>
							<li class="page-item"><a class="page-link" href="#">Next</a>
							</li>
						</ul>
					</nav>
				</div>

				<div class="col-md-3 col-12 pull-right" style="margin-left: 50px;position:sticky;top:100px">
				<div class="col">
				<div class="row">
						<div class="logo">
							 <a href="http://www.creative-tim.com"
									class="simple-text logo-normal">
								<h4 style="font-weight: bold;">Câu hỏi:</h4>
							</a>
						</div>
						<c:forEach var="i" begin="0" end="${lsQusAllParent.size()-1}">
							
								<c:if test="${lsQusAllParent.get(i).getIsTick()}">
										<button type="button" class="btn btn-primary"
										style="width: 50px;margin:3px" tag="btn_${i+1}">${i+1}</button>
								</c:if> 
								<c:if test="${!lsQusAllParent.get(i).getIsTick()}">
										<button type="button" class="btn btn-default"
										style="width:50px;margin:3px" tag="btn_${i+1}">${i+1}</button>
								</c:if> 
						</c:forEach>
					</div>
					<div class="row">
						<a href="trangxemketqua.jsp" data-toggle="modal"
								data-target="#myModal" style="color: blue">Finish attempt..</a>
								<h4 id="timeLimit" style="color: blue;"></h4>
						</a>
					</div>
				</div>
					
				</div>


			</div>
			<!-- Default unchecked -->

		</div>
		</div>


		<!-- modal -->
		<form action="${pageContext.request.contextPath}/Submit" method="POST">
			<div class="modal fade" id="myModal" role="dialog">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4 class="modal-title">Bạn có chắn chắc nộp bài không!</h4>
						</div>
						<div class="modal-footer">
							<div class="row" style="padding: 30px">
								<button type="button" class="btn btn-danger"
									data-dismiss="modal" style="float: left;">Close</button>
								<button id="btnSubmit" type="submit" class="btn btn-success"
									style="float: right">Đồng Ý</button>
							</div>

						</div>
					</div>
				</div>
			</div>

		</form>

		<!-- endmodal -->
	</section>
	<!--/ feature-->



	<script type="text/javascript">
		var b = [];
		function loadtime() {
			$.ajax({
				url : '${pageContext.request.contextPath}/CountDown',
				success : function(data) {
					$('#timeLimit').text(data);
				}
			});

		}
		function getQuestion(a) {
			return a.split("_")[0];
		}
		function saveQuestiton(array) {
			$.ajax({
				url : '${pageContext.request.contextPath}/DoTest',
				type : 'POST',
				data : {
					answerSelect : b
				},
				success : function(data) {

				}
			});

		}
		var myVar = setInterval(loadtime, 1000);
		function loadtime() {
			$.ajax({
				url : '${pageContext.request.contextPath}/CountDown',
				success : function(data) {
					if (data == '0 : 1') {
					/* 	$.ajax({
							url : '${pageContext.request.contextPath}/Submit',
							type : 'POST',
							success : function(data) {

							}
						}); */
						
						var url = '${pageContext.request.contextPath}/Submit'; 
						var form = $('<form action="' + url + '" method="post">' + 
						    '</form>'); 
						$('body').append(form); 
						form.submit(); 
						
					} else
						$('#timeLimit').text(data);
				}
			});

		}

		$(document)
				.ready(
						function() {

							$('[type="radio"]')
									.change(
											function(event) {
												for (i = 0; i < b.length; i++) {
													if (getQuestion($(this)
															.attr("tag")) == getQuestion(b[i])) {
														b.splice(i, 1);
													}
												}
												b.push($(this).attr("tag"));
												$(
														'[tag="btn_'
																+ getQuestion($(
																		this)
																		.attr(
																				"tag"))
																+ '"]')
														.removeClass(
																"btn-default")
														.addClass("btn-primary");
												saveQuestiton(b);
												console.log(b);
											});
						})
	</script>
</t:WrapperQuiz>
