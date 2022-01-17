/**
 * @auther Yaaqov Shkifati
 * @Since 07/20/2020
 * @verison 1.0
 */
package socsecexception;

import java.util.Scanner;

/**
 * The SocSecProcessor class tests the SocSecException class to find  if 
 * there is any errors with social security number.
 */
public class SocSecProcessor {

    public static void main(String[] args) throws Exception{

        Scanner input = new Scanner(System.in);

        String name, ssn, response;
        char answer= 'Y';

        while (Character.toUpperCase(answer) == 'Y') {
         
            System.out.print("Name? ");
              name = input.nextLine();
        
            System.out.print("SSN? ");
            ssn = input.nextLine();

            try {

                if (isValid(ssn)) {
                   System.out.println("Name" + name + " " + ssn + " is valid.");
                }
            
            } 
            catch (SocSecException error) {

                System.out.println(error.getMessage());

            }

            System.out.print("Continue ? ");
               response = input.nextLine();
               answer=response.charAt(0);

        }

    }

    /**
     * The isValid method checks to see if there is any errors with the 
     * social security number.
     * @param ssn social security number.
     * @return true or false if social security number is good.
     * @throws SocSecException 
     */
    public static boolean isValid(String ssn) throws SocSecException {

        boolean good_SSN = true;

        if (ssn.length() != 11) {
            
            good_SSN = false;

            throw new SocSecException("wrong number of characters");
        }
        
        if (ssn.charAt(3) != '-' || ssn.charAt(6) != '-') {

            good_SSN = false;

            throw new SocSecException("dashes at wrong positions");
        }
        
        for (int i = 0; i < ssn.length(); i++) {

            if (i == 3 || i == 6) {
                continue;
            }
             
            char c = ssn.charAt(i);
               
            if (!Character.isDigit(c)) {
                good_SSN = false;
                throw new SocSecException("contains a character that is not a "
                        + "digit");
            }
        }
        return good_SSN;
    }
}
