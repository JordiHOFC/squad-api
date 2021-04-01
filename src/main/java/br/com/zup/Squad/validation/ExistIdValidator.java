package br.com.zup.Squad.validation;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistIdValidator implements ConstraintValidator<ExistIdValid, Long> {
    private Class<?> domainClass;

    @PersistenceContext
    private EntityManager manager;


    public void initialize(ExistIdValid constraint) {
        this.domainClass = constraint.domainClass();
    }

    public boolean isValid(Long id, ConstraintValidatorContext context) {
        String jpql = "select r from " + domainClass.getSimpleName() + " r where r.id=:id";
        Query query = manager.createQuery(jpql);
        query.setParameter("id", id);
        List<?> register = query.getResultList();
        return register.size() == 1;
    }
}


    