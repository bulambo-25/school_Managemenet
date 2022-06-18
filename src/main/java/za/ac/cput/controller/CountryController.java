/*CountryController.java
 Entity CountryController
 Author: Kululo Mangcunyana (219387117)
 Date: 18 June 2022
 */

package za.ac.cput.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.Country;
import za.ac.cput.factory.CountryFactory;
import za.ac.cput.service.interf.CountryService;
import java.util.List;

@RestController
@RequestMapping("school/country/")
public class
CountryController {
    private final CountryService countyservice;

    @Autowired public CountryController(CountryService countyservice){
        this.countyservice = countyservice;
    }
    @PostMapping("save")
    public ResponseEntity<Country> save(@RequestBody Country country){
        Country ob;
        try{
            ob= CountryFactory.build(country.getId(),country.getName());
        } catch (IllegalArgumentException e){
            //throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
            throw e;
        }
        Country save=countyservice.save(ob);
        return ResponseEntity.ok(save);
    }
    @GetMapping("read/{id}")
    public ResponseEntity<Country> read(@PathVariable String id){
        Country country= this.countyservice.read(id).orElseThrow(() -> new  ResponseStatusException(HttpStatus.NOT_FOUND));
        return ResponseEntity.ok(country);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.countyservice.deleteById(id);
        return  ResponseEntity.noContent().build();
    }
    @GetMapping("all")
    public ResponseEntity<List<Country>> findAll(){
        List<Country> countries = this.countyservice.findAll();
        return ResponseEntity.ok(countries);
    }
}