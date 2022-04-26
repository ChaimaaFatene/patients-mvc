package com.chaimaa.patientsmvc.sec.repositories;

import com.chaimaa.patientsmvc.sec.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
   AppRole findByRoleName(String roleName);
}
