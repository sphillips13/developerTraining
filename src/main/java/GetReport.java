import td.api.Report;
import td.api.TDException;
import td.api.TeamDynamix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Get Report Class
 * Description:
 *     This Classes purpose for the Training is to get an idea of how to get data from a report. You will read in
 *     the ticket IDs from a report and save that into a list. Then you will display the size of the list which
 *     will also be the total amount of tickets on the report read in.
 */

/*
 * Author: Shawn Phillips
 * Date: 12/29/2020
 */
public class GetReport {

    /*
     * run
     * Description:
     *     Sets up the td object and logs the user in. This will
     * @param TeamDynamix tdapi
     */
    public static void run(TeamDynamix tdapi) {

       // TODO: Create a UI Object. You will need to great that class
        UserInterface ui = new UserInterface();

        // TODO: Get a report ID from ui
        // Please use report ID 18171. There should be 5 tickets on this report
        int reportID = ui.getReportID(tdapi);

        // TODO: Create Report Object and set it equal to validateReport()
        // The Report Object comes from the tdapi
        Report report = validateReport(tdapi, reportID);

        // TODO: Call readReportData and pass in the report
        int reportTotal = readReportData(report);

        // TODO: Output reportTotal
        // Shortcut: Type "sout".
        System.out.println("The amount of tickets in the report are: " + reportTotal);

    }

    /*
     * Read Report Data
     * Description:
     *     Read the passed in report and returns the amount of rows
     *
     * @param Report report
     *
     * @return int size of report
     */
    public static int readReportData(Report report) {

        // TODO: Create an Integer Array list and a currentTicket String
        List<Integer> ticketIDsList = new ArrayList<>();
        String currentTicket;

        // TODO: Create a double nested for loop to read the Row/Column
        // Reads the report by Row and Column
        for (Map<String, String> row : report.getDataRows()) {  // Row
            for (String key : row.keySet()) { // Column

                // TODO: Get the Key of "TicketID"
                // NOTICE: We are using "TicketID" because that is a default attribute to TD
                // if this was a custom attribute, we would look for it attribute ID.
                if (key.equals("TicketID")) {

                    // TODO: Assign currentTicket a value using "row.get(key)"
                    // row.get(key) saves the ticketID in a string like "123456.0"
                    // this will lose the floating point number
                    currentTicket = row.get(key);
                    // TODO: Add currentTicket to your Array
                    ticketIDsList.add((int) (Float.parseFloat(currentTicket)));

                }
            }
        }
        // TODO: Return the size of your Array
        return ticketIDsList.size();
    }

    /*
     * Validate Report
     * Description:
     *     Checks to see if the report is valid in TD. If so then it saves that data
     *     to the report object passed in.
     *
     * @param TeamDynamix td
     * @param Report report
     * @param int reportID
     *
     * @return Report that was successfully valid
     */
    public static Report validateReport(TeamDynamix tdapi, int reportID) {

        // TODO: Create report object
        Report report = null;

        // TODO: Check if the report is valid and add data to the report object
        boolean validReport = false;
        while (!validReport){

            try {
                report = tdapi.getReport(reportID, true, null);
                validReport = true;
            } catch (TDException e) {
                e.printStackTrace();
                validReport = false;
            }
        }
        return report;

    }

}
