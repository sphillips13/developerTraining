package Solutions;
import td.api.CustomAttribute;
import td.api.TDException;
import td.api.TeamDynamix;
import td.api.Ticket;

/*
 * Create Ticket Class
 * Description:
 *     Normally testing should be done in sandbox however the tdapi calls are only for live td.
 *     This Class will be used to create a simple Developer Training ticket.
 */

/*
 * Author: Shawn Phillips
 * Date: 12/30/2020
 */
public class CreateTicket {

    /*
     * Run
     * Description:
     *     This function is the driver of this class. It will call the buildDeveloperTicket() and
     *     createDeveloperTicket() functions to help you create the ticket in TD.
     * @param TeamDynamix tdapi
     */
    public void run(TeamDynamix tdapi) {

        // TODO: Create a Ticket object and set it equal to buildDeveloperTicket()
        Ticket developerTicket = buildDeveloperTicket();

        // TODO: Create a int called newlyCreatedTicketID and set it equal to createDeveloperTicket()
        int newlyCreatedTicketID = createDeveloperTicket(developerTicket, tdapi);

        // TODO: Display newlyCreatedTicketID
        System.out.println("The Newly Ticket ID created is: " + newlyCreatedTicketID);
    }

    /*
     * Build Developer Ticket
     * Description:
     *     This function is creates a ticket object and returns it. This will set up the Default TD attributes and one
     *     custom attribute.
     *
     * @return Ticket that has attributes built
     */
    public Ticket buildDeveloperTicket() {

        // TODO: Create a Ticket and DeveloperTicketIds object
        // NOTE: You will need to set the ID's for DeveloperTicketIDs class
        Ticket developerTicket = new Ticket();
        DeveloperTicketIDs iDs = new DeveloperTicketIDs();

        // NOTE: This link comes from the TeamDynamix Api website. This link shows what values are required
        // in order to use the create ticket function in our tdapi class
        // https://api.teamdynamix.com/TDWebApi/Home/type/TeamDynamix.Api.Tickets.Ticket

        // TODO: Using the Ticket and DeveloperTicketIDs objects you created, set the values for;
        // FormID, Title, RequestorUid, Description, StatusID, AppID, TypeID, AccountID, and Priority ID
        // Default Attributes
        developerTicket.setFormId(iDs.FORM_ID);
        developerTicket.setTitle(iDs.TITLE);
        developerTicket.setRequestorUid(iDs.REQUESTOR_UID);
        developerTicket.setDescription(iDs.DESCRIPTION);
        developerTicket.setStatusId(iDs.STATUS_ID);
        developerTicket.setAppID(iDs.APP_ID);
        developerTicket.setTypeId(iDs.TYPE_ID);
        developerTicket.setAccountId(iDs.ACCOUNT_ID);
        developerTicket.setPriorityId(iDs.PRIORITY_ID);

        // TODO: Create a CustomAttribute object and use the DeveloperTicketIDs object to set the custom attribute
        // Custom Attributes
        CustomAttribute customAttribute = new CustomAttribute(iDs.DEVELOPER_TAG_ID, Integer.toString(iDs.DEVELOPER_TAG_VALUE_HTML_ID));
        developerTicket.getAttributes().add(customAttribute);

        // TODO: Return your Ticket Object
        return developerTicket;
    }

    /*
     * Create Developer Ticket
     * Description:
     *     This function takes the ticket that was built from the buildDeveloperTicket() function and uses the
     *     tdapi to create the actual ticket in TD.
     *
     * @param TeamDynamix tdapi
     * @param Ticket developerTicket
     *
     * @return int of the newly created ticket ID
     */
    public int createDeveloperTicket(Ticket developerTicket, TeamDynamix tdapi) {

        // TODO: Create a DeveloperTicketIDs object and a createdTicketID int
        DeveloperTicketIDs iDs = new DeveloperTicketIDs();
        int createdTicketID = 0;

        // TODO: Use the tdapi and call createTicket() to create the ticket you built
        // Creates the Developer Training ticket
        try {
            // API Call Link: https://api.teamdynamix.com/TDWebApi/Home/section/Tickets
            Ticket newlyCreatedTicket = tdapi.createTicket(iDs.APP_ID, developerTicket);
            createdTicketID = newlyCreatedTicket.getId();
        } catch (TDException e) {
            e.printStackTrace();
        }

        // TODO: return createdTicketID
        return createdTicketID;
    }
}

