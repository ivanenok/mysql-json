package ru.ivanenok.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivanenok.domain.JSONEntity;

import java.util.List;

/**
 * Created by ivanenok
 */
@Repository
interface RepositoryJSONEntity extends JpaRepository<JSONEntity, Long>{
    List<JSONEntity> findByName(String name);
    List<JSONEntity> findByLastName(String name);
}
