import grails.util.Environment
import example.security.*

class BootStrap {

    def init = { servletContext ->

        switch (Environment.current) {
            case Environment.DEVELOPMENT:
                Role ROLE_USER = new Role(authority: 'ROLE_USER').save(failOnError: true)
                Role ROLE_ADMIN = new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

                User USER_USER = new User(username: 'user', password: 'user').save(failOnError: true)
                User USER_ADMIN = new User(username: 'admin', password: 'admin').save(failOnError: true)

                UserRole.create(USER_USER, ROLE_USER, true)
                UserRole.create(USER_ADMIN, ROLE_USER, true)
                UserRole.create(USER_ADMIN, ROLE_ADMIN, true)
        }
    }
    def destroy = {
    }
}
