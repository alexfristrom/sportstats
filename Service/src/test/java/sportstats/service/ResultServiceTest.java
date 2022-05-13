/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package sportstats.service;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import sportstats.domain.Result;
import sportstats.repository.ResultRepository;

/**
 *
 * @author max
 */
public class ResultServiceTest {
    
    @Mock
    
    private ResultRepository resultRep;
    ResultService resultService;
    
    public ResultServiceTest() {
    }
   
    /**
     * Test of saveResult method, of class ResultService.
     */
    @Test
    public void testSaveResult() {
        resultRep = mock(ResultRepository.class);
        resultService = new ResultService(resultRep);
        Result result = new Result();
        
        Mockito.when(resultRep.save(any(Result.class))).thenReturn(result);
        Result newResult = resultService.saveResult(result);
    }

    /**
     * Test of getResult method, of class ResultService.
     */
    @Test
    public void testGetResult() {
        
    }

    /**
     * Test of getAllResult method, of class ResultService.
     */
    @Test
    public void testGetAllResult() {
        
    }
    
}
