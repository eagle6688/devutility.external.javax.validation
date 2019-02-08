package devutility.external.javax.validation.annotation;

import java.util.Map;

import devutility.external.javax.validation.ValidationUtils;
import devutility.external.javax.validation.model.ModelForSizeIfNotNull;
import devutility.external.javax.validation.model.ValidationResult;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class TestSizeIfNotNull extends BaseTest {
	@Override
	public void run() {
		ModelForSizeIfNotNull model = new ModelForSizeIfNotNull();
		test(model);

		model.setCellphone1("123");
		model.setCellphone2("123");
		model.setCellphone3("1234567890Z");
		test(model);

		model.setCellphone1("12345678");
		model.setCellphone2("12345678");
		model.setCellphone3("123456789");
		test(model);
	}

	private void test(ModelForSizeIfNotNull model) {
		ValidationResult result = ValidationUtils.validate(model);

		if (result.isFailed()) {
			Map<String, String> map = result.getErrorMessages();

			for (Map.Entry<String, String> item : map.entrySet()) {
				println(item.getValue());
			}
		} else {
			println("Test success!");
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(TestSizeIfNotNull.class);
	}
}