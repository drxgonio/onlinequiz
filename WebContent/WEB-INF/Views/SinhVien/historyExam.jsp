<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:WrapperQuiz>


	<div class="col" style="padding: 150px;">
		<div class="row " align="center">
			<div class="col-md-8 col-12"
				style="margin-left: auto; margin-right: auto; float: none;">
				<c:forEach items="${lsExam}" var="item">
					<div class="panel panel-success" style="margin-bottom: 10px;">
						<div class="panel-heading">
							<h3>Môn: ${item.examObject.subjectObject.subjectName}</h3>
						</div>
						<div class="panel-body"></div>
						<div style="margin-bottom: 5px;">
							<label style="font-weight: bold;">Bài kiểm tra:
								${item.examObject.name}</label>
						</div>

						<div style="margin-bottom: 5px;">
							<label style="font-weight: bold;">Điểm:</label> <span>${item.score}</span>
						</div>
						<div style="margin-bottom: 5px;">
							<label style="font-weight: bold;">Thời gian làm:</label> <span>${item.startTime}</span>
						</div>
						<div style="margin-bottom: 5px;">
							<label style="font-weight: bold;">Thời kết thúc:</label> <span>${item.finishTime}</span>
						</div>
						<div class="panel-footer">
							<a href="${pageContext.request.contextPath}/ReportExam?idExam=${item.examObject.id}" class="btn btn-info"> Xem Chi Tiết Kết Quả</a>
						</div>
					</div>
				</c:forEach>

			</div>
		</div>
	</div>


</t:WrapperQuiz>