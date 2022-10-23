package com.savelyev.movies.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Column(name = "role")
    private String role;
}