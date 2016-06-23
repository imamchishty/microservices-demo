package com.demo.product.domain.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <pre>
 *     Simplifies the configuration of the JPA, does require a DS to have been created.
 * </pre>
 *
 * @author imamchishty
 */
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@Import(ProductDomainConfiguration.class)
public @interface EnableProductJpa {
}
