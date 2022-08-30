package fr.dawan.projet1.forms;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MotdePasseValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz==UserForm.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserForm userForm = (UserForm) target;
		if(userForm.getMotPasse() == null || userForm.getConfirmMotPasse() == null || !userForm.getMotPasse().equals(userForm.getConfirmMotPasse())) {
			userForm.setMotPasse("");
			userForm.setConfirmMotPasse("");
			errors.rejectValue("confirmMotPasse", "user.confirmPassword.NotEquals", "Les mots de passe sont différents");
		}

	}

}
