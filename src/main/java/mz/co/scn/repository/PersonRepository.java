package mz.co.scn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mz.co.scn.model.Person;

/**
 *
 * @author Sidónio Goenha on Jun 23, 2020
 *
 */
public interface PersonRepository extends JpaRepository<Person, Long>{

}
