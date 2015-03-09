package simpleappwithsecurity

import org.springframework.boot.autoconfigure.security.SecurityProperties
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers('/admin/**').hasAnyRole('ADMIN')
                .antMatchers('/home/**').hasAnyRole('USER', 'ADMIN')
                .antMatchers('/').permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
    }
}
