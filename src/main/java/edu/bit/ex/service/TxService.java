package edu.bit.ex.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bit.ex.mapper.UserMapper;
import edu.bit.ex.vo.UserVO;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@NoArgsConstructor
@Service
public class TxService {
    
    @Inject
    private UserMapper userMapper;
    
    // 트랜젝션 사용전 
    // mapper를 통해 Authrities와 Users 테이블을
    // 삭제하고 새로운 username과 password를 두개씩 넣는 테스트
    public void txTest1() {
        log.info("transactionTest1()..테스트1");
        
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();
        
        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");
        
        userMapper.insertUser(user);
        
        user.setUsername("efg");
        user.setPassword("2222");
        
        userMapper.insertUser(user);
    }
    
    
    // 트랜잭션 사용전
    // mapper를 통행 Authrities와 Users 테이블을
    // 삭제하고 하나의 userName 과 Password를 넣고
    // 하나의 값들은 null값으로 처리 
    public void txTest2() {
        log.info("transactionTest2()..테스트2");
        
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();
        
        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");
        
        userMapper.insertUser(user);
        
        user.setUsername("efg");
        user.setPassword("2222");
        
        userMapper.insertUser(null);
    }
    
    
    // 트랜잭션 사용 후
    // 원래있던 데이터들을
    // 로직중 null 즉, 오류가 생기면
    // 데이터를 롤백 시켜줌
    @Transactional
    public void txTest3() {
        
        log.info("transactionTest3()..테스트3");
        
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();
        
        UserVO user = new UserVO();
        user.setUsername("abcd");
        user.setPassword("1111");
        
        userMapper.insertUser(user);
        
        user.setUsername("efg");
        user.setPassword("2222");
        
        userMapper.insertUser(null);
    }
    
    // 트랜잭션 사용 후
    // 익셉션오류에 대해서도 롤백을 해줌
    @Transactional
    public void txTest4() {
        
        log.info("transactionTest4()..테스트4");
        
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();
        
        throw new RuntimeException("RuntimeException");
    }
    
    // 트랜잭션 사용 후
    // SQL익셉션 오류에 대해서는 롤백을 안해줌
    // 명시적 오류에 관해서는 롤백을 안해줌
    // 동적 오류에 관해서는 롤백을 해줌
    @Transactional
    public void txTest5() throws SQLException{
        
        log.info("transactionTest5()..테스트5");
        
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();
        
        throw new SQLException("SQLException");
    }
    
    @Transactional(rollbackFor = SQLException.class)
    public void txTest6() throws SQLException{
        
        log.info("transactionTest6()..테스트6");
        
        userMapper.deleteAuthorities();
        userMapper.deleteUsers();
        
        throw new SQLException("SQLException");
    }
}


























