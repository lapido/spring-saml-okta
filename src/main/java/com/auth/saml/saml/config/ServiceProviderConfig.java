package com.auth.saml.saml.config;

import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderBuilder;
import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class ServiceProviderConfig extends ServiceProviderConfigurerAdapter {

    @Override
    public void configure(ServiceProviderBuilder serviceProvider) throws Exception {
        serviceProvider
                .metadataGenerator()
                .entityId("localhost-demo")
                .bindingsSSO("artifact", "post", "paos")
                .and()
                .ecpProfile()
                .and()
                .sso()
                .defaultSuccessURL("/home")
                .idpSelectionPageURL("/idpselection")
                .and()
                .metadataManager()
                .metadataLocations("classpath:/idp-okta.xml")
                .refreshCheckInterval(0)
                .and()
                .extendedMetadata()
                .ecpEnabled(true)
                .idpDiscoveryEnabled(true)
                .and()
                .keyManager()
                .privateKeyDERLocation("classpath:/localhost.key.der")
                .publicKeyPEMLocation("classpath:/localhost.cert");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/unprotected/**")
                .permitAll()
                .and()
                .anonymous();
    }
}