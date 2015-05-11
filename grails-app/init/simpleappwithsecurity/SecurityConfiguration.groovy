package simpleappwithsecurity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.core.userdetails.UserDetailsService;

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
    UserDetailsService userDetailsService

    @Autowired
    protected void globalConfigure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
    }

}