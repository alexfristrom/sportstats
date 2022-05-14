/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service.util;

import org.hibernate.service.spi.ServiceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author max
 */
public class CheckNameTest {

    public CheckNameTest() {
    }

    @Test
    public void testCheckName() {
        CheckName cn = new CheckName();
        assertThrows(ServiceException.class,
                () -> {
                    cn.checkName(true);
                }
        );
    }

    /**
     * Test of checkNameContent method, of class CheckName.
     */
    @Test
    public void testCheckNameContent() {
        
    }

}
