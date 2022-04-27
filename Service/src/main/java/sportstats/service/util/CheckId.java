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
public class CheckId {

    public static void checkId(Long id) {
        if (id != null) {
            throw new ServiceException("New Sport object can not have ID prior to persistence");
        }
    }
}
