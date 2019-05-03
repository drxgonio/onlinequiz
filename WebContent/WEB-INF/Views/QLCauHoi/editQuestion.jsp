<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:WrapperAdmin>

	<form class="row" action="/WebThi/EditQuestion" method="post">
		<div class="col-md-12">
			<div class="card">
				<div class="card-header">
					<div class="row">
						<div class="col-md-6">
							<h3 class="card-title">
								<b> Chỉnh sửa câu hỏi: <i>${question.questionId }</i>
								</b>
							</h3>
						</div>
						<div class="col-md-3"></div>
						<div class="col-md-3 mr-0">
							<div class="input-group">
								<input type="file" class="custom-file-input"
									id="inputGroupFile04" aria-describedby="inputGroupFileAddon04">
								<label class="custom-file-label" for="inputGroupFile04">Choose
									file</label>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<div class="card ">
						<div class="card-header ">
							<h5 class="card-title">Nội dung câu hỏi</h5>
						</div>
						<div class="card-body ">
							<div class="input-group mb-4">
								<div class="form-control" style="border: none">
									<p>
										<b>Môn học</b>
									</p>
									<select class="custom-select" id="inputGroupSelect01"
										name="sltSubject">
										<c:forEach items="${lstSubject}" var="subject">
											<c:if test="${ subject.subjectID eq question.subjectID }">
												<option value="${subject.subjectID}" selected> ${subject.subjectName} </option>
											</c:if>
											<option value="${subject.subjectID}"> ${subject.subjectName} </option>
										</c:forEach>
											
									</select>
								</div>
							</div>

							<p>
								<b> Nội dung câu hỏi </b>
							</p>
							<textarea class="form-control p-2 my-2" rows="5"
								style="max-height: 400px" name="question" ><c:out
									value="${question.getQuestion()}" />
                    </textarea>
							<p>
								<b>Mức độ</b>
							</p>

							<div class="input-group">
								<div class="input-group-text"
									style="border: none; background: none">
									<c:if test="${ question.getLevel() eq 'Dễ' }">
										<input type="radio" name="radLevel" class="ml-2 mr-1"
											checked=checked value="de"> Dễ
										
									<input type="radio" name="radLevel" class="ml-2 mr-1"
											aria-label="Radio button for following text input" value="tb">
									Trung bình <input type="radio" name="radLevel"
											class="ml-2 mr-1"
											aria-label="Radio button for following text input" value="kh">Khó
										</c:if>
									<c:if test="${ question.getLevel() eq 'Trung bình' }">

										<input type="radio" name="radLevel" class="ml-2 mr-1"
											aria-label="Radio button for following text input" value="de"> Dễ
									<input type="radio" name="radLevel" class="ml-2 mr-1"
											aria-label="Radio button for following text input"
											checked=checked value="tb">
									Trung bình <input type="radio" name="radLevel"
											class="ml-2 mr-1"
											aria-label="Radio button for following text input" value="kh">Khó
										</c:if>
									<c:if test="${ question.getLevel() eq 'Khó' }">

										<input type="radio" name="radLevel" class="ml-2 mr-1" id="easy"
											aria-label="Radio button for following text input" value="de"> 
											<label for="easy">Dễ</label>
											
										<input type="radio" name="radLevel" class="ml-2 mr-1" id="normal"
											aria-label="Radio button for following text input" value="tb">
										
										<label for="normal">Trung bình</label>
									
										<input type="radio" name="radLevel"
											class="ml-2 mr-1"
											aria-label="Radio button for following text input"
											checked=checked value="kh"
											id="diffi">
											<label for="diffi">Khó</label>
										</c:if>
									
									<input type="hidden" name ="id" value="${param.id }">
								</div>
							</div>
						</div>
						<hr>
						<div class="card-footer">
							<div class="input-group-text"
								style="border: none; background: none">
								<input type="checkbox"  name="radAns" id="activate"
									class="mr-2" aria-label="Radio button for following text input">
								<label for="activate">Kích hoạt</label>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-8">
					<div class="card card-chart">
						<div class="card-header">
							<h5 class="card-title">Danh sách câu trả lời</h5>
							<p class="card-category">Chọn 1 đáp án đúng</p>
						</div>
						<div class="card-body">
							<div>
								<ul class="nav flex-column">
								<c:forEach items="${question.lsAnswer}" var="no1">
								<li class="nav-item">
									<div class="input-group-text">
										<c:if test="${no1.id eq question.correctAnswerID}">
											<input type="radio" name="radAnsa" class="mr-2" checked
															aria-label="Radio button for following text input"  value="${no1.id }">
										</c:if>
										<c:if test="${no1.id != question.correctAnswerID}">
											<input type="radio" name="radAnsa" class="mr-2"
															aria-label="Radio button for following text input"  value="${no1.id }">
										</c:if>
										<input type="text" class="form-control"
										aria-label="Text input with radio button" value="${no1.answer }" >
									</div>
								</li>
								</c:forEach>
									
								</ul>
							</div>
						</div>
						<div class="card-footer">
							<hr />
							<div class="card-stats">
								<button class="col-md-12 btn btn-success">
									<i class="fa fa-plus"></i> Thêm câu trả lời
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="row justify-content-center">
				<button type="submit" class="btn btn-info col-3">
					<i class="fa fa-save"></i>Lưu thay đổi
				</button>


				<a href="${pageContext.request.contextPath}/ListQuestion" class="btn btn-danger col-3"> <i
					class="fa fa-times"></i> Hủy
				</a>
			</div>
		</div>
	</form>
</t:WrapperAdmin>