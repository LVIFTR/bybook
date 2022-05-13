package com.ipz.bybook.repository;

import com.ipz.bybook.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    List<Role> findAll();

    Optional<Role> findById(long id);

}
