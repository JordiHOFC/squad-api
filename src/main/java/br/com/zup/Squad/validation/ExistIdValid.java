package br.com.zup.Squad.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.MODULE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistIdValidator.class)
@Repeatable(ExistIdValid.List.class)
public @interface ExistIdValid {
    String message() default "Não existe registro vinculado a este identificador";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    Class<?> domainClass();

    @Documented
    @Target({ElementType.FIELD,ElementType.TYPE,ElementType.MODULE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface List{
        ExistIdValid[] value();
    }

}
