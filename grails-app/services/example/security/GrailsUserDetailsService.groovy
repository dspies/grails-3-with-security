package example.security

import grails.transaction.Transactional
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import example.security.GrailsUserDetails

@Transactional
public class GrailsUserDetailsService implements UserDetailsService {

    public static final String NO_ROLE = "ROLE_NO_ROLES";

    /**
     * Some Spring Security classes (e.g. RoleHierarchyVoter) expect at least
     * one role, so we give a user with no granted roles this one which gets
     * past that restriction but doesn't grant anything.
     */
    static final List NO_ROLES = [new SimpleGrantedAuthority(NO_ROLE)]

    UserDetails loadUserByUsername(String username, boolean loadRoles)
            throws UsernameNotFoundException {
        return loadUserByUsername(username)
    }

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = User.findByUsername(username)
        if (!user) throw new UsernameNotFoundException('User not found', username)

        def authorities = user.authorities.collect {
            new SimpleGrantedAuthority(it.authority)
        }

        return new GrailsUserDetails(user.username, user.password, user.enabled,
            !user.accountExpired, !user.passwordExpired,
            !user.accountLocked, authorities ?: NO_ROLES, user.id)

    }

}