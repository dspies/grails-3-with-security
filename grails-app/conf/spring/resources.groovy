
import example.security.GrailsUserDetailsService
//import simpleappwithsecurity.SecurityConfiguration

beans = {
//    webSecurityConfiguration(SecurityConfiguration)
    userDetailsService(GrailsUserDetailsService)
}
