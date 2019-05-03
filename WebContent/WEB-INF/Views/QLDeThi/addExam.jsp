<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:WrapperAdmin>
                <div class="row ">
                    <div class="col-md-4">
                        <div class="card card-user">
                            <div class="row justify-content-center my-2">
                            	<div class="col-lg-10">
                                    <select class="form-control my-2" id="sltSubject">
                                     	<option value="${ subject.subjectID }" selected> ${subject.subjectName}</option>
                                    	<c:forEach items="${ lstSubject }" var="su" >
 											<option value="${ su.subjectID }"> ${su.subjectName}</option>
										</c:forEach>
                                    </select>
                                </div>

                            </div>
                            <div class="row justify-content-center">
                                <div class="col-md-10">
                                    <div class="card card-user border">
                                        <div class="card-header">
                                            <h4 class="card-title text-center"> Loại câu hỏi</h4>
                                        </div>
                                        <div class="col-md-12">
                                            <div class="row justify-content-center ">
                                                <div class="col-md-4">
                                                    <div class="form-group justify-content-center text-center">
                                                        <input type="number" class="form-control" value="${listType.get(0)}" name="easy" id="easy">
                                                        <p>Dễ</p>
                                                    </div>
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group justify-content-center text-center">
                                                        <input type="number" class="form-control" value="${listType.get(1)}" name="normal" id="normal">
                                                        <p>TB</p>
                                                    </div>	
                                                </div>
                                                <div class="col-md-4">
                                                    <div class="form-group justify-content-center text-center">
                                                        <input type="number" class="form-control" value="${listType.get(2)}" name="difficult" id="difficult">
                                                        <p>Khó</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row justify-content-center ">
                                            <div class="form-group justify-content-center text-center">
                                                <input type="text" class="form-control text-center" value="${listType.get(0)+listType.get(1)+listType.get(2)}" readonly id="total">
                                                <p>Tổng số câu hỏi</p>
                                            </div>
                                            
                                        </div>
                                        
                                    </div>
                                    <button type="button"  class="btn btn-primary btn-round col-12" id="btnCreateExam">Tạo ngẫu nhiên</button>
                                </div>
                            </div>
                            
                        </div>
                        <div class="card">
                            <div class="card-header">
                                <h4 class="card-title"><b>Tùy Chọn</b></h4>
                            </div>
                            <div class="card-body">
                            <form action="${pageContext.request.contextPath}/AddExam" method="post" id="frmAddExam">
                                <ul class="list-unstyled ">
                                    <li>
                                    	<p class="my-1"> Thời gian mở đề </p>
                                        <div class="my-1">
                                            <input type="datetime-local" class="form-control" placeholder="Thời Gian Mở" name="timeOpen">
                                        </div>
                                    </li>
                                    <li>
                                        <p class="my-1"> Thời gian đóng đề </p>
                                    
                                        <div class="my-1">
                                            <input type="datetime-local" class="form-control" placeholder="Thời gian đóng" name="closeTime">
                                        </div>
                                    </li>
                                    	
                                    <li>
                                    	<p class="my-1"> Tên bài thi </p>
                                    	<div class="my-1">	
                                        	<input type="text" class="form-control" placeholder="Tên bài thi" name="nameExam" >
										</div>
                                    </li>
                                    <li>
                                    	<p class="my-1"> Thời gian làm (phút) </p>
                                    	<div class="my-1">	
                                        	<input type="number" name="limitTime" class="form-control" placeholder="Thời gian làm bài">
										</div>
                                    </li>
                                </ul>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="card card-user">
                            <div class="card-header row mx-2 justify-content-center">
                                <h5 class="card-title col-8">Danh Sách Câu Hỏi</h5>
                                <button class="btn btn-danger col-4" id="btnDeleteAll"> Xóa toàn bộ </button>
                                <button class="btn btn-info col-4" id="btnAdd"> Thêm câu hỏi </button>
                                
                            </div>
                            <div class="card-body">
                                <table class="table">
                                    <thead>
                                        <tr>
                                            <th>Stt</th>
                                            <th>Nội Dung</th>
                                            <th>Đáp án</th>
                                            <th class="text-center">Lựa Chọn</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<tr id="frameAdd" class="my-3">
	                                            <td colspan="4" class="my-3">
	                                            	 <select class="form-control slcQuestion" class="my-3" id="addQuestion">
	                                            		<option selected> Chọn câu hỏi thêm vào<option>
		                                            	<c:forEach items="${lstQuestionChoose}" var="qe">
															<option  value="${qe.questionId}"> ${qe.question}<option>
														</c:forEach>
	                                            	
	                                            	</select>
	                                            </td>
	                                        </tr>
                                       <c:forEach items="${lstCurrentQuestion}" var="question" varStatus="loop">
                                    
                                            <tr id= "frameQuestion_${loop.index}" >
	                                            <td> ${question.questionId } </td>
	                                            <td>
	                                            	 <select class="form-control slcQuestion" data-id="${question.questionId}">
	                                            		<option selected value="${question.questionId}" id="nowQuestion" > ${ question.question }<option>
		                                            	<c:forEach items="${lstQuestionChoose}" var="qe">
															<option  value="${qe.questionId}"> ${qe.question}<option>
														</c:forEach>
	                                            	
	                                            	</select>
	                                            </td>
	                                            <td>
	                                            	<c:forEach items="${question.lsAnswer}" var="ans">
														<c:if test="${question.correctAnswerID == ans.id}">
															<p>
																<b>${ ans.answer }</b>
															</p>
														</c:if>
														<c:if test="${  question.correctAnswerID != ans.id}">
															<p>${ ans.answer }</p>
														</c:if> 
													</c:forEach>
	                                            </td>
                                                <td class="text-center">
                                                    <button type="button" class="btn btn-danger btnDelete" 
                                                            data-id="${ question.questionId }"
                                                            data-index="${loop.index}">
                                                        <i class="fa fa-trash" style="font-size:10px"></i>
                                                    </button>
	                                            </td>
	                                        </tr>
										</c:forEach>
                                    </tbody>
                                </table>
                                <nav aria-label="Page navigation example" class="float-right">
                                    <ul class="pagination">
                                        
                                        <c:forEach var="i" begin="1" end="${numberPage}">
											<li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/AddExam?page=${i}">${i}</a>
											</li>
										</c:forEach>
																				
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>

                
            	</div>
            	<div class="row justify-content-center">
            	      <button type="button" class="btn btn-success btn-round col-8" id="btnAddExam"> Tạo Đề Thi </button>           	
            	</div>
<script>
$('#frameAdd').hide();
         	$(document).ready(function() {
                $('#btnCreateExam').click(function(){
                    var difficult = $('#difficult').val();
                    var normal = $('#normal').val();
                    var easy = $('#easy').val();
                    var subject = $('#subject').val();
                    if(difficult == "" ||normal == "" ||easy == "")
                    {
                        alert("Xin vui lòng nhập số lượng câu hỏi từng loại");
                    }
                    else 
                    	if (subject == "")
                    	{ 
                            alert("Xin vui lòng chọn lớp");
                    	}
	                    else    
	                        {
	                            var link = '/WebThi/AddExam?difficult='+difficult+'&normal='+normal+'&easy='+easy;
	                            window.location=link;
	                        }
                   });
             $('.btnDelete').click(function(){
           	  	var id = $(this).data("id");

                var link = '/WebThi/AddExam?deleteId='+id+'&action=DELETE';
                window.location=link;
			  });
             
             $('.slcQuestion').change(function(){
            	 var oldQues = $(this).data('id');
            	 var newQues = $(this).val();
                 var link = '/WebThi/AddExam?action=UPDATE&replaceId='+oldQues+'&newId='+newQues;
                 window.location=link;
 			  });
             
              $('#btnDeleteAll').click(function(){
                 var link = '/WebThi/AddExam?action=DELETEALL';
                 window.location=link;
 				//deleteQuestion(index);
 			  });

        	  $('#sltSubject').change(function(){
        		  var id = $(this).val();
        		  selectSubject(id);
        	  });
        	  $('#easy').change(function(){
        		  update();
        	  });
        	  $('#normal').change(function(){
        		  update();
        	  });
        	  $('#difficult').change(function(){
        		  update();
        	  });
        	  $('#btnAddExam').click(function(){
        		/* if(false)
        	  	{
        			  
        	  	}
        		else */
        			$('#frmAddExam').submit();
        	  });
        	  
        	  $('#btnAdd').click(function(){
                  $('#frameAdd').show();
  			  });
        	  
        	  $('.slcQuestion').change(function(){
             	 var oldQues = $(this).data('id');
             	 var newQues = $(this).val();
                  var link = '/WebThi/AddExam?action=UPDATE&replaceId='+oldQues+'&newId='+newQues;
                  window.location=link;
  			  });
        	  addQuestion
        	  $("#addQuestion").change(function(){
              	 var newQues = $(this).val();
                   var link = '/WebThi/AddExam?action=ADD&newId='+newQues;
                   window.location=link;
   			  });
         	});
        function update()
        {
        	  var diff =  parseInt($("#difficult").val());
	  		  var normal =  parseInt($("#normal").val());
	  		  var easy =  parseInt($("#easy").val());
	
	  		  var total = diff+normal+easy;
	  		  $("#total").val(total);
        }
		function selectSubject(subjectId) {
			$.ajax({
				url : '${pageContext.request.contextPath}/AddExam?subjectId='+subjectId,
				type : 'PUT',
				contentType : "json",
				success : function(data) {
					if (data!=""){
						var obj = $.parseJSON(data);
						console.log(obj);

					}
					else{
						alert("Không thể đổi môn học khi đã có danh sách câu hỏi");
					}
				}
		});

	};
</script>
</t:WrapperAdmin>
            

