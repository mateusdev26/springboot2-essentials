package br.com.devdojo.awesome.endpoint;

import br.com.devdojo.awesome.model.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("student")
public class StudentEndpoint {
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Student> listAll() {
        return asList(
                new Student("Mike",16,'M'),
                new Student("Ana",12,'F'),
                new Student("John",9,'M'),
                new Student("Gabriella",7,'F'),
                new Student("Hugo",11,'M'),
                new Student("Manu",14,'F')
        );
    }
}
