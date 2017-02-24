/**
 * 
 */
package com.budthapa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.budthapa.domain.SiteUser;
import com.budthapa.domain.UserDao;

/**
 * @author budthapa
 * Feb 23, 2017
 * 
 */

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void register(SiteUser siteUser){
		siteUser.setRole("ROLE_USER");
//		siteUser.setPassword(passwordEncoder.encode(siteUser.getPassword()));
		userDao.save(siteUser);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		SiteUser user = userDao.findByEmail(email);
		
		if(user==null){
			System.out.println("UsernameNotFoundException: Username not found for email =====> "+email );
			throw new UsernameNotFoundException("Username not found");
		}
		
		List<GrantedAuthority> auth=AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
		String password = user.getPassword();
		return new User(email,password,auth);
	}
}
