package programmerzamannow.webmvc.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public String hello(String name) {
        if(name == null) {
            return "Hello Guest";
        } else {
            return "Hello " + name;
        }
    }
}
