package example

class User {

    String username
    String password
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean credentialsExpired

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Authority> getAuthorities() {
        UserAuthority.findAllByUser(this).collect { it.authority }
    }

}
