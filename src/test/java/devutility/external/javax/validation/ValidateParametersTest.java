package devutility.external.javax.validation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import devutility.external.javax.validation.model.TestController;
import devutility.external.javax.validation.model.User;
import devutility.external.javax.validation.model.ValidationResult;
import devutility.internal.test.BaseTest;
import devutility.internal.test.TestExecutor;

public class ValidateParametersTest extends BaseTest {
	@Override
	public void run() {
		TestController target = new TestController();

		User user = new User();
		user.setCellphone("asd");

		Object[] parameters = { "ip.asd", user, Arrays.asList(user) };

		try {
			ValidationResult result = ValidationUtils.validateParameters(target, target.getClass().getDeclaredMethod("test", String.class, User.class, List.class), parameters);
			Map<String, String> errorMap = result.getErrorMessages();

			for (Map.Entry<String, String> entry : errorMap.entrySet()) {
				println(entry.getKey() + ":" + entry.getValue());
			}
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TestExecutor.run(ValidateParametersTest.class);
	}
}