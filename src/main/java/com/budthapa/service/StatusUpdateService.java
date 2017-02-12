/**
 * 
 */
package com.budthapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.budthapa.dao.StatusUpdateDao;
import com.budthapa.domain.StatusUpdate;

/**
 * @author budthapa
 * Feb 12, 2017
 * 
 */
@Service
public class StatusUpdateService {
	@Autowired
	private StatusUpdateDao statusUpdateDao;
	
	public void save(StatusUpdate statusUpdate){
		statusUpdateDao.save(statusUpdate);
	}
	
	public StatusUpdate getLatest(){
		return statusUpdateDao.findFirstByOrderByAddedDesc();
	}
}
