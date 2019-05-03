<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!--/ Banner-->
<!--Feature-->
<t:WrapperQuiz>

	<section id="feature" class="section-padding"
		style="background: #DDDDDD;">
		<div class="container">
			<div class="row ">
				<div class="alert alert-primary" role="alert">
					<p class="big-text" style="">Danh Sách Môn Thi Sắp Tới Của Bạn</p>
				</div>
				<div class="col-md-9 col-12">

					<!-- Default unchecked -->
					<div class="row justify-content-start">
						<c:forEach items="${lsExam}" var="item1">
							<div class="col-md-3 col-12">
								<div class="price-table pt-bg-black">
									<div>
										<span>${item1.getSubjectObject().getSubjectName()}</span>
										<span>${item1.name}</span>
									</div>
									<ul>
										<li>Kiểm tra ${item1.limitTime} phút</li>
										<li>Thời gian:${item1.timeStarting}</li>
										<li>Trắc nghiệm:${item1.numQuestions}</li>
									</ul>
									<a href="${pageContext.request.contextPath}/TestOn?id=${item1.id}">Thi</a>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				<div class="col-md-3 col-12 " style="border-radius: 20px" id="demoPicker">
				
				</div>


<script type="text/javascript">
$(document).ready(function() {
	// Cho nay lam hoi ga
	var ngayXem=[];
	var tenKhoaHoc=[];
	var idExam=[];
	
	<c:forEach items="${lsDateExamInMonth}" var="item">
	ngayXem.push(${item});
	</c:forEach>
	<c:forEach items="${lsTenKhoaHoc}" var="item">
	tenKhoaHoc.push('${item}');
	</c:forEach>
	<c:forEach items="${lsIdExamInMonth}" var="item">
	idExam.push(${item});
	</c:forEach>
	
	
	
	 var now = new Date();
     var a = [];
     var b = [];
     for (var j = 0; j < ngayXem.length; j++) {
         var highlight = {
             start: new Date(now.getFullYear(), now.getMonth(), ngayXem[j]),
             end: new Date(now.getFullYear(), now.getMonth(), ngayXem[j]),
             backgroundColor: '#05676E',
             color: '#fff',
             legend: 'Highlight'
         }
         var tooltip = {
             date: new Date(now.getFullYear(), now.getMonth(),  ngayXem[j] ),
             text:  '<a href="${pageContext.request.contextPath}/TestOn?id='+idExam[j]+'">'+tenKhoaHoc[j]+'</a>'
         };
         b.push(tooltip);
         a.push(highlight);
     }

     var demoPicker = new Datepickk({
         container: document.querySelector('#demoPicker'),
         inline: true,
         range: true,
         tooltips: {
             date: new Date(),
             text: 'Tooltip'
         }
         // highlight:{
         // 	start: new Date(now.getFullYear(),now.getMonth(),3),
         // 	end: new Date(now.getFullYear(),now.getMonth(),3),
         // 	backgroundColor:'#05676E',
         // 	color:'#fff',
         // 	legend: 'Highlight'
         // }
     });
     demoPicker.highlight = a;
     demoPicker.tooltips=b;
});
</script>

				<!-- Default unchecked -->



			</div>
		</div>

	</section>

</t:WrapperQuiz>


