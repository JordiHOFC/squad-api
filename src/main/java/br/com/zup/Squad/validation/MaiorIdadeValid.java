package br.com.zup.Squad.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MaiorIdadeValidator.class)
public @interface MaiorIdadeValid {
    String message() default "O membro deve ter no mínimo dezoito anos";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload()default {};

}
