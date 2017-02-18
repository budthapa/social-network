/**
 * 
 */
package com.budthapa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	
	private final static int PAGESIZE=8;
	
	public void save(StatusUpdate statusUpdate){
		statusUpdateDao.save(statusUpdate);
	}
	
	public StatusUpdate getLatest(){
		return statusUpdateDao.findFirstByOrderByAddedDesc();
	}
	
	public Page<StatusUpdate> getPage(int pageNumber){
		PageRequest request = new PageRequest(pageNumber-1,PAGESIZE,Sort.Direction.DESC,"added");
		return statusUpdateDao.findAll(request);
	}
	
	public void delete(Long id){
		statusUpdateDao.delete(id);
	}

	/**
	 * @param id
	 */
	public boolean idExists(Long id) {
		return statusUpdateDao.exists(id);
	}

	/**
	 * @param id
	 */
	public StatusUpdate getStatus(Long id) {
		// TODO Auto-generated method stub
		return statusUpdateDao.findOne(id);
	}
}
