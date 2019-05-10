package cn.thoughtworks.school.services;

import cn.thoughtworks.school.entities.Example;
import cn.thoughtworks.school.repositories.ExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExampleService {
    @Autowired
    private ExampleRepository exampleRepository;

    public Example findById(Long id) {
        return exampleRepository.findById(id).orElse(new Example());
    }
}
