package simpleappwithsecurity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
class SecurityConfiguration extends WebSecurityConfigurerAdapter {

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

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser('user').password('user').roles('USER')
                .and()
                .withUser('admin').password('admin').roles('ADMIN');
    }
}