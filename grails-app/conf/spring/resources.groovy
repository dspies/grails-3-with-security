import example.GormUserDetailsService
import simpleappwithsecurity.SecurityConfiguration

beans = {
    webSecurityConfiguration(SecurityConfiguration)
    userDetailsService(GormUserDetailsService)
}
