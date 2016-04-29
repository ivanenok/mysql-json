package ru.ivanenok;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by ivanenok
 */
@Configuration
@EnableJpaRepositories
@EntityScan({"ru.ivanenok.domain"})
public class PersistenceContext {
}
