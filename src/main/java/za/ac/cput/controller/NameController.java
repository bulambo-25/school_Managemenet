/*
 * @Author Reanetsi Sholoko
 * @Student number: 218160402*/
package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Name;
import za.ac.cput.service.impl.NameServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/name")
public class NameController {

  /*  @Autowired
    private NameServiceImpl nameService;

    @GetMapping("/getall")
    public List<Name> getAll(){
        return nameService.getAll();
    }

    @GetMapping("/read/{firstname}")
    public List<Name> getByFirstName(@PathVariable String firstname) {
        return nameService.findByFirstName(firstname);
    }

    @PostMapping("/create")
    public Name create(@RequestBody Name name){
        return nameService.create(name);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody Name name){
        nameService.delete(name);
    }

    @PutMapping("/update")
    public Name update(@RequestBody Name name) {
        return nameService.create(name);
    }*/
}
