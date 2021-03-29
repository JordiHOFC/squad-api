package br.com.zup.Squad.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class MaiorIdadeValidator implements ConstraintValidator<MaiorIdadeValid, LocalDate> {

    @Override
    public boolean isValid(LocalDate localDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate date=LocalDate.now();
        return date.minusYears((long) localDate.getYear()).getYear()>17;
    }
}
