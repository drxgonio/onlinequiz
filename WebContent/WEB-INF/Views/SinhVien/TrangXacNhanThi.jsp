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
							
								<p class="big-text">Môn:
									${exam.getSubjectObject().getSubjectName()}</p>
								<p class="small-text">Gồm có ${exam.numQuestions} câu hỏi và
									câu trả lời. Nếu bạn trả lời đúng thì bạn được 0.5đ. Nếu làm
									full sẽ được 10 điểm. Chọn một câu trả lời đúng.</p>
								<!-- <p class="big-text">Danh sách đề thi</p> -->
								<a  href="${pageContext.request.contextPath}/TestOn?id=${exam.id}" class="btn get-quote">
									Bắt đầu
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