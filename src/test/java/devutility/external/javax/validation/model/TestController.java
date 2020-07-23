package devutility.external.javax.validation.model;

import javax.validation.Valid;

import devutility.external.javax.validation.annotation.PatternIfNotBlank;
import devutility.internal.model.OperationResult;
import devutility.internal.security.RegExpUtils;

public class TestController {
	public OperationResult test(@PatternIfNotBlank(regexp = RegExpUtils.IP, message = "Invalid IP address") String ip, @Valid User user) {
		return new OperationResult();
	}
}