package com.beacon.security.annotation;

import com.beacon.security.config.Application;
import com.beacon.security.config.BeaconSecurityConfigurationSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(BeaconSecurityConfigurationSelector.class)
public @interface EnableBeaconSecurity {

    Application application() default Application.NONE;
}
