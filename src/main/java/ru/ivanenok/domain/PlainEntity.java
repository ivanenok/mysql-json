package ru.ivanenok.domain;

import javax.persistence.*;

/**
 * Created by ivanenok
 */
@Entity
@Table(name = "test_plain_tbl")
public class PlainEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "text_plain", columnDefinition = "TEXT")
    private String textPlain;

    @Column(name = "name", columnDefinition = "VARCHAR(80) AS (JSON_UNQUOTE(text_plain->\"$.name\"))", insertable = false, updatable = false)
    private String name;

    // inserts and updates must be disabled cuz you can't do any modification in syntetic fields
    @Column(name = "last_name", columnDefinition = "VARCHAR(80) AS (JSON_UNQUOTE(text_plain->\"$.lastName\"))", insertable = false, updatable = false)
    private String lastName;

    public PlainEntity() {
    }

    public PlainEntity(String textPlain) {
        this.textPlain = textPlain;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextPlain() {
        return textPlain;
    }

    public void setTextPlain(String textPlain) {
        this.textPlain = textPlain;
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
