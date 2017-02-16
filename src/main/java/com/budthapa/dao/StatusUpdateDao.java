package com.budthapa.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.budthapa.domain.StatusUpdate;

public interface StatusUpdateDao extends PagingAndSortingRepository<StatusUpdate, Long>{

	/**
	 * @return
	 */
	StatusUpdate findFirstByOrderByAddedDesc();
	

}
