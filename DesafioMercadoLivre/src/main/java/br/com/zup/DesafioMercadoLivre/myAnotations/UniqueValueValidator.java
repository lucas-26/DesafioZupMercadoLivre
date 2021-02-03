package br.com.zup.DesafioMercadoLivre.myAnotations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.Assert;



public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

	private String domainAtribute;
	private Class<?> klass;
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void initialize(UniqueValue params) {
		domainAtribute = params.fieldName();
		klass = params.domainClass();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Query query = entityManager.createQuery("SELECT 1 FROM " + klass.getName() +" WHERE " + domainAtribute + " = :value");
		query.setParameter("value", value);
		List<?> list = query.getResultList();
		Assert.state(list.size() <= 1, "Foi encontrado mais de um " + klass + "  com o atributo " + domainAtribute + " = " + value );
		
		return list.isEmpty();
		
	}
}