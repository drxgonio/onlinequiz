<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<t:WrapperQuiz>
	<!--Banner-->
	<div class="banner">
		<div class="bg-color">
			<div class="container">
				<div class="row">
					<div class="banner-text text-center">
						<div class="text-border">
							<h2 class="text-dec">Ứng dụng thi trắc nghiệm</h2>
						</div>
						<div class="intro-para text-center quote">
							
								<p class="big-text">Bạn đã thi xong với với số điểm là: ${grade} </p>
							
								<a  href="${pageContext.request.contextPath}/ReportExam" class="btn get-quote">
									Xem kết quả
									</a>
						</div>
						<!--  <a href="#feature" class="mouse-hover">
              <div class="mouse"></div>
            </a> -->
					</div>
				</div>
			</div>
		</div>
	</div>
</t:WrapperQuiz>