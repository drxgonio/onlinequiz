<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:WrapperAdmin>
	<div class="card-body">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-plain">
					<div class="card-header">
						<h5 class="card-title">Thông báo gần đây</h5>
					</div>
					<div class="card-body">
						<div
							class="alert alert-success alert-with-icon alert-dismissible fade show">
							<button type="button" aria-hidden="true" class="close"
								data-dismiss="alert" aria-label="Close">
								<i class="nc-icon nc-simple-remove"></i>
							</button>
							<span data-notify="icon" class="nc-icon nc-simple-add"></span> <span
								data-notify="message"> Bạn vừa thêm 5 sản phẩm trong 1
								giờ gần đây </span>
						</div>
						<div
							class="alert alert-info alert-with-icon alert-dismissible fade show"
							data-notify="container">
							<button type="button" aria-hidden="true" class="close"
								data-dismiss="alert" aria-label="Close">
								<i class="nc-icon nc-simple-remove"></i>
							</button>
							<span data-notify="icon" class="nc-icon nc-chat-33"></span> <span
								data-notify="message">Từ: <b>Đạt Trần</b></span> <span
								data-notify="message">Anh ơi cho em xin vào group học tập
								của anh với ạ!</span>

						</div>
						<div
							class="alert alert-danger alert-with-icon alert-dismissible fade show"
							data-notify="container">
							<button type="button" aria-hidden="true" class="close"
								data-dismiss="alert" aria-label="Close">
								<i class="nc-icon nc-simple-remove"></i>
							</button>
							<span data-notify="icon" class="nc-icon nc-paper"></span> <span
								data-notify="message"> Đã có <i> 55 người </i> trả lời
								câu hỏi <b>abcxyz </b> của bạn.
							</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</t:WrapperAdmin>