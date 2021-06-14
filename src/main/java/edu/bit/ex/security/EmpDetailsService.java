package edu.bit.ex.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import edu.bit.ex.mapper.EmpMapper;
import edu.bit.ex.vo.EmpUser;
import edu.bit.ex.vo.EmpVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class EmpDetailsService implements UserDetailsService {

    @Autowired
	private EmpMapper empMapper;
    
    // 스프링 시큐리티가 호출하는 loadUserByusername()
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Load User By MemberVO number: " + username);
		EmpVO vo = empMapper.getEmp(username);

		System.out.println("queried by MemberVO mapper: " + vo);

		return vo == null ? null : new EmpUser(vo);

	}
}