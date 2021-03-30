package br.com.zup.Squad.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.Locale;

public class ValidEmailValidator implements ConstraintValidator <ValidEmail,String>{


    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
return email.toLowerCase().endsWith("@zup.com.br");

    }
}
