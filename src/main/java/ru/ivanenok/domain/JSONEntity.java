package ru.ivanenok.domain;

import javax.persistence.*;

/**
 * Created by ivanenok
 */
@Entity
@Table(name = "test_json_tbl")
public class JSONEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "text_json", columnDefinition = "JSON")
    private String textJSON;

    // inserts and updates must be disabled cuz you can't do any modification in syntetic fields
    @Column(name = "name", columnDefinition = "VARCHAR(80) AS (JSON_UNQUOTE(text_json->\"$.name\"))", insertable = false, updatable = false)
    private String name;

    // inserts and updates must be disabled cuz you can't do any modification in syntetic fields
    @Column(name = "last_name", columnDefinition = "VARCHAR(80) AS (JSON_UNQUOTE(text_json->\"$.lastName\"))", insertable = false, updatable = false)
    private String lastName;

    public JSONEntity() {
    }

    public JSONEntity(String textJSON) {
        this.textJSON = textJSON;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextJSON() {
        return textJSON;
    }

    public void setTextJSON(String textJSON) {
        this.textJSON = textJSON;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
