function _change() {
	$("#vCode").attr("src", "/lv02/VerifyCodeServlet?" + new Date().getTime());
}