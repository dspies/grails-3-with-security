package example.security

import grails.transaction.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

@Transactional
public class GrailsUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        def user = User.findByUsername(username)
        if (user){
            return user
        } else {
            throw new UsernameNotFoundException('Username was not found for ' + username)
        }
    }
}