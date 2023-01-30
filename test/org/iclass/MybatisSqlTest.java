package org.iclass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mybatis.SqlSessionBean;

class MybatisSqlTest {
	private NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();

	@DisplayName("SqlSessionTest")
	@Test
	void session() {
		SqlSession mapper = SqlSessionBean.getSession();
		assertNotEquals(mapper, null);
		mapper.close();
	}
	
	@DisplayName("SelectTest")
	@Test
	void selectList() {
		SqlSession mapper = SqlSessionBean.getSession();
		assertEquals(dao.selectAll().size(), 2);
		mapper.close();
	}
	
	/*@DisplayName("InsertTest")
	@Test
	void insert() {
		int result = dao.insert(NewMember.builder().id("dmdka3").name("삼다다").password("3333").email("dmdka3@dmdka3.com").age(25).gender("2").hobbies("농구").build());
		
		assertEquals(result, 1);
	}*/
	
	/*@DisplayName("UpdateTest")
	@Test
	void update() {
		int result = dao.update(NewMember.builder().id("dmdka3").email("dmdka3@dmdka33.com").hobbies("농구3").build());
		
		assertEquals(result, 1);
	}*/
	
	/*@DisplayName("DeleteTest")
	@Test
	void delete() {
		int result = dao.delete("dmdka3");
		
		assertEquals(result, 1);
	}*/
	
	/*@DisplayName("selectByIdTest")
	@Test
	void selectById() {
		assertEquals(dao.selectById("dmdka1").getName(), "일가가");
	}*/
	
	@DisplayName("LoginTest")
	@Test
	void login() {
		String id = "dmdka1";
		String pw = "1111";
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", pw);
		
		NewMember vo = dao.login(map);
		assertNotNull(vo.getId());
	}
	
	
	
}
