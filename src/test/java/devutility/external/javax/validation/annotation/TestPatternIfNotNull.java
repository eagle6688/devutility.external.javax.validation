package devutility.external.javax.validation.annotation;

import devutility.external.javax.validation.ValidationUtils;
import devutility.external.javax.validation.model.User;
import devutility.external.javax.validation.model.ValidationResult;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class TestPatternIfNotNull extends BaseTest {
	@Override
	public void run() {
		User user = new User();
		test(user);

		user.setCellphone("asd");
		test(user);

		user.setCellphone("13888888888");
		test(user);
	}

	private void test(User user) {
		ValidationResult result = ValidationUtils.validate(user);

		if (result.isFailed()) {
			println(result.getFirstErrorMessage());
		} else {
			println("Test success!");
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(TestPatternIfNotNull.class);
	}
}