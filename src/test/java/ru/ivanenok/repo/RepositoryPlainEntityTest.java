package ru.ivanenok.repo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import ru.ivanenok.MysqlJsonApplication;
import ru.ivanenok.domain.JSONEntity;
import ru.ivanenok.domain.PlainEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivanenok
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {MysqlJsonApplication.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
@Transactional
public class RepositoryPlainEntityTest {
    @Autowired
    private RepositoryJSONEntity repositoryJSONEntity;

    @Autowired
    private RepositoryPlainEntity repositoryPlainEntity;

    @Test
    public void testPlain(){
        repositoryPlainEntity.save(buildPlain());
        List<PlainEntity> butchers = repositoryPlainEntity.findByLastName("Butcher");
        Assert.assertEquals(2, butchers.size());
    }

    @Test
    public void testJSON(){
        repositoryJSONEntity.save(buildJSON());
        List<JSONEntity> butchers = repositoryJSONEntity.findByLastName("Butcher");
        Assert.assertEquals(2, butchers.size());
    }

    private Iterable<PlainEntity> buildPlain() {
        ArrayList<PlainEntity> result = new ArrayList<>();
        result.add(new PlainEntity("{\"name\":\"John\", \"lastName\":\"Butcher\"}"));
        result.add(new PlainEntity("{\"name\":\"Sam\", \"lastName\":\"Butcher\"}"));
        result.add(new PlainEntity("{\"name\":\"Ivan\", \"lastName\":\"Drunk\"}"));
        return result;
    }

    private Iterable<JSONEntity> buildJSON() {
        ArrayList<JSONEntity> result = new ArrayList<>();
        result.add(new JSONEntity("{\"name\":\"John\", \"lastName\":\"Butcher\"}"));
        result.add(new JSONEntity("{\"name\":\"Sam\", \"lastName\":\"Butcher\"}"));
        result.add(new JSONEntity("{\"name\":\"Ivan\", \"lastName\":\"Drunk\"}"));
        return result;
    }
}