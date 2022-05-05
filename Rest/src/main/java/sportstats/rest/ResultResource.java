/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sportstats.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sportstats.domain.Result;
import sportstats.service.ResultService;

/**
 *
 * @author annjohansson
 */
@RestController
@RequestMapping("result")
public class ResultResource {
     private final ResultService service;

    @Autowired
    public ResultResource(ResultService service){
        this.service = service;
    }

    
    @PostMapping
    public Result saveResult(@RequestBody Result result){
        return service.saveResult(result);
    }

    @GetMapping("{id}")
    public Result getResultById(@PathVariable Long id){
        return service.getResult(id);
    }

    @GetMapping
    public List<Result> getAllResult(){
        return service.getAllResult();
    }
}
