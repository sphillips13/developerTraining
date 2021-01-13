package Solutions;

import td.api.TeamDynamix;
import java.util.Scanner;

/*
 * User Interface
 * This class is used for any ui that will be needed throughout this training.
 */

/*
 * Author: Shawn Phillips
 * Date: 12/30/2020
 */

public class UserInterface {

    /*
     * User inputs a Report ID
     *
     * @param td TeamDynamix td
     */
    public static int getReportID(TeamDynamix td) {

        String report;

        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Report ID: ");
        report = sc.nextLine();

        // converts String to an Int
        return Integer.parseInt(report);
    }

}
