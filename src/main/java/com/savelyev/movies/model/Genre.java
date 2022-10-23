package com.savelyev.movies.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name="genres")
@EqualsAndHashCode(callSuper=true)
public class Genre extends BaseEntity {
    private String genre;

}
