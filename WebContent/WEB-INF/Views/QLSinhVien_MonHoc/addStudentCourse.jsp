<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:WrapperAdmin>
                         <form method="post" action="${pageContext.request.contextPath}/AddStudentCourse">
		<input type="hidden" name="courseId" value="${course.courseId }">
        <div class="row">
        
            <div class="col-md-12">
          
                <div class="card">
                  <div class="card-header">
                      <h3 class="card-title"><b> Thêm sinh viên vào lớp ${course.getName()} </b> </h3>
                      <div class="card-body">

                                <div class="form-group row">
                                    <label for="inputId" class="col-sm-2 col-form-label">Mã số sinh viên</label>
                                    <div class="col-sm-9">
                                      <input type="text" class="form-control" id="studentId" placeholder="Mã số sinh viên" name="studentId">
                                    </div>
                                    <button type="button" class="btn btn-info col-sm-1 col-form-label" style="margin:0" id="btnSearchById"> <i class="fa fa-search"></i></button>
                                  </div>
                                <div class="form-group row">
                                  <label for="name" class="col-sm-2 col-form-label my-1"> Họ tên sinh viên</label>
                                  <div class="col-sm-9">
                                    <input type="text" class="form-control" id="name" placeholder="Nguyễn Văn A">
                                  </div>
                                  <button type="button" class="btn btn-info col-sm-1 col-form-label" style="margin:0" id="btnSearchByName"> <i class="fa fa-search"></i></button>
                                  
                                </div>
                               <div class="form-group row justify-content-end px-3">
                                <select class="custom-select col-sm-10 form-control" multiple id="sltStudent">
								  <option selected> Chọn sinh viên</option>
								  
								</select>
								</div>
                                <div class="form-group row">
                                  <label for="year" class="col-sm-2 col-form-label my-1"> Niên khóa</label>
                                  <div class="col-sm-10">
                                    <input type="text" class="form-control" id="year" placeholder="Niên khóa" disabled>
                                  </div>
                                  
                                </div>
                                 <div class="form-group row">
                                  <label for="cmnd" class="col-sm-2 col-form-label my-1"> Số CMND </label>
                                  <div class="col-sm-4">
                                    <input type="text" class="form-control" id="cmnd" placeholder="CMND" disabled>
                                  </div>
                                  <label for="gender" class="col-sm-2 col-form-label my-1"> Giới tính </label>
                                  <div class="col-sm-4">
                                    <input type="text" class="form-control" id="gender" placeholder="Giới tính" disabled>
                                  </div>
                                </div>
                                <div class="form-group row">
                                  <label for="address" class="col-sm-2 col-form-label my-1"> Địa chỉ</label>
                                  <div class="col-sm-10">
                                    <input type="text" class="form-control" id="address" placeholder="Địa chỉ" name ="address" disabled>
                                  </div>
                                  
                                </div>
                                </div>
                                 <input type="hidden" name="typesearch" data-filter="id" id="typeSearch">
                            
                      </div>
                </div>
			<div class="row justify-content-center">
	          <button type="submit" class="btn btn-info col-3"> <i class="fa fa-check"></i> Lưu thay đổi</button>
	          <a href="${pageContext.request.contextPath}/ListStudent?idCourse=${course.courseId}" class="btn btn-danger col-3"> <i class="fa fa-times"></i> Danh sách sinh viên </a>
	        </div>
        </div>
      
        
    </div>      </form>

  <script type="text/javascript">
		
			function LoadStudent() { 
				var id = {};
				var typeSearch = $('#typeSearch').data("filter");
				if(typeSearch=="id"){
					id = $('#studentId').val();
	    		}
				else{
					id = $('#name').val();
				}
				$.ajax({
					url : '${pageContext.request.contextPath}/LoadInfoStudent',
					type:'GET',
					data : {
						studentId : id,
						typeSearch : typeSearch
					},
				    contentType: "html",
				    success : function(data) {
						var obj = $.parseJSON(data);

						if(!obj || obj.length == 0)
							{
								alert("Không tìm thấy sinh viên!");
								$('#cmnd').val("");
								$('#year').val("");
								$('#name').val("");
								$('#address').val("");
								$('#gender').val("");
								return;
							}
				    	if(typeSearch=="id")
			    		{
							$('#cmnd').val(obj.identityCardNumber);
							$('#year').val(obj.yearOfAdmission +" - " + obj.yearOfGraduation);
							$('#name').val(obj.name);
							$('#address').val(obj.address + ", " + obj.country);
							$('#gender').val(obj.gender);
			    		}
				    	else if(typeSearch=="name")
			    		{
				    		$('#sltStudent').empty();
							$.each(obj, function(index, st) {
								var str = st.name + " - MSSV : " +st.studentId;
								$("<option value='"+ st.studentId +"'>" + str + "</option>").appendTo(
										$("#sltStudent"));
							});
			    		}

					}
				});
			}

			$(document).ready(function() {
				$('#btnSearchById').click(function() {
					$('#typeSearch').data("filter","id");
					LoadStudent();
				});
				$('#btnSearchByName').click(function() {
					$('#typeSearch').data("filter","name");
					LoadStudent();
				});
				$('#sltStudent').change(function() {
					$('#typeSearch').data("filter","id");
					$('#studentId').val($('#sltStudent').val());
					LoadStudent();
				});

			});
		</script>
  </t:WrapperAdmin>