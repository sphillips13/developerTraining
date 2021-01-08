import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import td.api.CustomAttribute;
import td.api.Ticket;

/*
 * Creat Ticket Tests
 * Description:
 *     This class is a test class to make sure that the buildDeveloperTicket() function is working correctly.
 *     We use asserts to assume our information is the same as how it is being built.
 */

/*
 * Author: Shawn Phillips
 * Date: 1/8/2021
 */
public class CreateTicketTests {

    // TODO: Create CreatTicket, DeveloperTicketIDs, and Custom Attribute Objects
    private CreateTicket testCreateTicket = new CreateTicket();
    private Ticket testDeveloperTicket = new Ticket();
    private DeveloperTicketIDs iDs = new DeveloperTicketIDs();
    private CustomAttribute customAttribute = new CustomAttribute();

    @BeforeAll
    public void setup() {

        // TODO: Set your Ticket Object equal to buildDeveloperTicket()
        testDeveloperTicket = testCreateTicket.buildDeveloperTicket();

        // TODO: Set your CustomAttribute Ticket
        customAttribute = new CustomAttribute(iDs.DEVELOPER_TAG_ID, Integer.toString(iDs.DEVELOPER_TAG_VALUE_HTML_ID));

    }

    @Test
    public void shouldBuildDeveloperTicketCorrectly() throws Exception {

        // TODO: Assert that each value set is correct
        // Default Attributes
        assert(testDeveloperTicket.getFormId() == 3300);
        assert(testDeveloperTicket.getTitle() == "Developer Training Ticket");
        assert(testDeveloperTicket.getRequestorUid() == "e578bb85-0041-e511-80d1-005056ac5ec6");
        assert(testDeveloperTicket.getDescription() == "R2S2 Member Test Ticket");
        assert(testDeveloperTicket.getStatusId() == 979);
        assert(testDeveloperTicket.getAppId() == 63);
        assert(testDeveloperTicket.getTypeId() == 857);
        assert(testDeveloperTicket.getAccountId() == 553);
        assert(testDeveloperTicket.getPriorityId() == 21);

        // TODO: Assert that your CustomAttribute is in your Ticket Object
        // Custom Attributes
        assert(testDeveloperTicket.getAttributes().contains(customAttribute));

    }
}
