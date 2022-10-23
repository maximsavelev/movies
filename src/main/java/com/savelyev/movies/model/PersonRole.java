package com.savelyev.movies.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "person_role")
public class PersonRole extends BaseEntity {
    private String role;

}
