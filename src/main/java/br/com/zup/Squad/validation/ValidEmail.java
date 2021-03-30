package br.com.zup.Squad.validation;


import org.springframework.stereotype.Repository;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidEmailValidator.class)
public @interface ValidEmail {
    String message() default "Email não pertece ao dominio da ZUP";
    Class<?>[] groups() default {};
    Class <? extends Payload> [] payload () default {};

}
