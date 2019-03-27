package com.sophos.poc.wsrestauditorialst.cache.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sophos.poc.wsrestauditorialst.model.Accion;

@Repository
public interface AccionRepository extends CrudRepository<Accion, String> {

}
