package devutility.external.javax.validation.model;

import devutility.external.javax.validation.annotation.PatternIfNotNull;

public class User {
	@PatternIfNotNull(regexp = "^1(3|4|5|7|8)\\d{9}$", message = "请输入正确格式的手机号码！")
	private String cellphone;

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
}