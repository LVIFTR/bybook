package com.ipz.bybook.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    private long id;

    @Column(unique = true)
    private String name;

}
