package example
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(AdminController)
class AdminControllerSpec extends Specification {

    void "test renders 'You are in the admin controller'"() {
        when: 'admin controller index is called'
        controller.index()

        then: 'response is You are in the admin controller'
        response.text == 'You are in the admin controller'
    }
}