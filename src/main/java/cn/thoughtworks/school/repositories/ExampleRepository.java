package cn.thoughtworks.school.repositories;

import cn.thoughtworks.school.entities.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepository extends JpaRepository<Example,Long> {

}
