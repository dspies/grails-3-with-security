package example.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

class GrailsUserDetails extends User {

    private static final long serialVersionUID = 1;

    private final Object id;

    GrailsUserDetails(String username, String password, boolean enabled,
                  boolean accountNonExpired, boolean credentialsNonExpired,
                  boolean accountNonLocked,
                  Collection<GrantedAuthority> authorities,
                  long id) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities)
        this.id = id
    }

    /**
     * Get the id.
     * @return the id
     */
    public Object getId() {
        return id;
    }

}