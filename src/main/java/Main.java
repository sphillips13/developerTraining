/*
 * WELCOME!
 *
 * This program is designed to help BSC R2S2 Developers to start working on programming
 * projects. This should not take longer than 2 hours to complete and there is a solution
 * guide for this project once you have completed it. Think of this project as a way to
 * connect your knowledge of TD and apply it to Java code. There could be better solutions
 * to this project than what is given but this project should get you a solid foundation
 * of developing in TD.
 *
 * This project will be overly commented to help guide you.
 *
 * Outcomes:
 *  Developer will know how to create a Class
 *  Developer will know how to read TD reports
 *  Developer will know how to create TD tickets
 *  Developer will know how to style code according to the BSC Developer Standards
 *  Developer will know how to write tests for projects
 */

import td.api.TDException;
import td.api.TeamDynamix;

/*
 * Main Class
 * Description:
 *     This Main class is where you will set up the start of your program. It should run main first. It will then
 *     help you call different classes in order to get a report and create a new ticket.
 */

/*
 * Author: Shawn Phillips
 * Date: 12/28/2020
 */
public class Main {

    /*
     * Main
     * Description:
     *     Starts up the program.
     */
    public static void main(String[] args) {

        /*
         * "TODO:" can be found in the bottom left corner of Intellij
         * This is a keyword so you can put in thoughts and notes you have.
         * It will be used for instructions for this project.
         */

        /***************************** Step 1 **********************************/
        // Log into TD
        // TODO: Create 3 strings. BASE_PATH, username, and password. Use environment variables to get those values
        String BASE_PATH = System.getenv("tdbasepath");
        String username = System.getenv("tduser");
        String password = System.getenv("tdpassword");

        // TODO: Create TD Object
        TeamDynamix tdapi = new TeamDynamix(BASE_PATH, username, password);

        // TODO: Log into TD
        login(tdapi);

        // Class objects created.
        GetReport getReport = new GetReport();
        CreateTicket createTicket = new CreateTicket();

        /***************************** Step 2 **********************************/
        // Read in a report output the amount of tickets on that report 18171
        getReport.run(tdapi);

        /***************************** Step 3 **********************************/
        // Create a Developer Test ticket
        createTicket.run(tdapi);

    }

    /*
     * Login
     * Description:
     *     Uses the td object to login.
     * @param TeamDynamix td
     */
    public static void login(TeamDynamix td) {

        // TODO: Login to TD using your td object
        try {
            td.login();
        } catch (TDException e) {
            e.printStackTrace();
        }
    }
}
