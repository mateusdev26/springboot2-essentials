package br.com.devdojo.awesome.endpoint;

import br.com.devdojo.awesome.model.Student;
import br.com.devdojo.awesome.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

@Log4j2
@RestController
@RequestMapping("student")
public class StudentEndpoint {
    @Autowired
    private DateUtil dateUtil ;
    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public List<Student> listAll() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return asList(
                new Student("Mike", 16, 'M'),
                new Student("Ana", 12, 'F'),
                new Student("John", 9, 'M')
        );
    }
}
