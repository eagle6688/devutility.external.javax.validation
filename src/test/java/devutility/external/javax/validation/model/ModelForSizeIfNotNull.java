package devutility.external.javax.validation.model;

import devutility.external.javax.validation.annotation.SizeIfNotNull;

public class ModelForSizeIfNotNull {
	@SizeIfNotNull(min = 6, max = 10, message = "请输入6-10位密码！")
	private String cellphone1;

	@SizeIfNotNull(min = 6, message = "请输入6-位以上密码！")
	private String cellphone2;

	@SizeIfNotNull(max = 10, message = "请输入少于10位密码！")
	private String cellphone3;

	public String getCellphone1() {
		return cellphone1;
	}

	public void setCellphone1(String cellphone1) {
		this.cellphone1 = cellphone1;
	}

	public String getCellphone2() {
		return cellphone2;
	}

	public void setCellphone2(String cellphone2) {
		this.cellphone2 = cellphone2;
	}

	public String getCellphone3() {
		return cellphone3;
	}

	public void setCellphone3(String cellphone3) {
		this.cellphone3 = cellphone3;
	}
}