/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.service.util;

import org.hibernate.service.spi.ServiceException;

/**
 *
 * @author annjohansson
 */
public class CheckName {

    public static void checkName(boolean bool) {
        if (bool) {
            throw new ServiceException("New Sport object can not have dublicated name");
        }
    }
       /**
     * error handling such as which characters are allowed / whitespace remover.
     *
     * @param name - Attribute value name
     * @return 
     */
    public static String checkNameContent(String name) {
        name = name.trim();
        //Not sure if this regex code allows for whitespaces need to be tested,
        //but left unchecked until this text is removed.

        if (!name.matches("^[ A-Za-z]+")) {
            throw new IllegalArgumentException("Use of invalid characters.");
        }


        if (name.isBlank()) {
            throw new IllegalArgumentException("Input may not only be whitespaces.");
        }
       // name = CheckName.excessWhitespaceRemover(name);
        return name;
    }

    /**
     * Function for removing excess whitespace in string input. Example input: "
     * foo bar" Returns: "foo bar".
     *
     * @param s - Any string
     * @return - String with no consecutive whitespace
     */
    /*private static String excessWhitespaceRemover(String s) {
        s = s.trim();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                count++;
            }
            if (count == 2) {
                s = s.substring(0, i) + excessWhitespaceRemover(s.substring(i, s.length()));
            }
        }
        return s;

    }*/
}
