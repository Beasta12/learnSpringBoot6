package programmerzamannow.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CodeController {

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ResponseBody
    public void delete(@PathVariable("id") Integer id) {
        //delete dari db
    }

}
