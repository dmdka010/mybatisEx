package org.iclass;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.dao.NewMemberMybatisDao;
import org.iclass.vo.NewMember;

import mybatis.SqlSessionBean;

public class MybatisSessionTest {

	public static void main(String[] args) {
		SqlSession mapper = SqlSessionBean.getSession();
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "dmdka1");
		map.put("pw", "1111");
		
		
		if(mapper == null) {
			System.out.println("mabatis 설정에 오류가 있음");
		}else {
			System.out.println(mapper);
		}
		
		mapper.close();
		
		NewMemberMybatisDao dao = NewMemberMybatisDao.getInstance();
		
		NewMember vo = dao.login(map);
		assertNotNull(vo.getId());
		
		/*System.out.println(dao.selectAll().get(0));
		System.out.println(dao.selectAll().get(1));*/
	
		System.out.println(dao.selectById("dmdka3"));
		
		System.out.println(dao.login(map));
		
		
	}

}
