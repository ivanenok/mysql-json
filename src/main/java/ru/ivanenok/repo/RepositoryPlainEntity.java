package ru.ivanenok.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ivanenok.domain.PlainEntity;

import java.util.List;

/**
 * Created by ivanenok
 */
@Repository
interface RepositoryPlainEntity extends JpaRepository<PlainEntity, Long>{
    List<PlainEntity> findByName(String name);
    List<PlainEntity> findByLastName(String name);
}
