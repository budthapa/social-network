/**
 * 
 */
package com.budthapa.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author budthapa
 * Feb 23, 2017
 * 
 */

@Repository
public interface UserDao extends CrudRepository<SiteUser, Long>{
	SiteUser findByEmail(String email);
}
