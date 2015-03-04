package example
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(HomeController)
class HomeControllerSpec extends Specification {

    void "test renders 'You are in the home controller'"() {
        when: 'home controller index is called'
        controller.index()

        then: 'response is You are in the home controller'
        response.text == 'You are in the home controller'
    }
}