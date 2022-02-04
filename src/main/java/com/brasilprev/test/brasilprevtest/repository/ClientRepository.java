package com.brasilprev.test.brasilprevtest.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brasilprev.test.brasilprevtest.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
