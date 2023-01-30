package org.iclass.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.NewMember;

import mybatis.SqlSessionBean;

public class NewMemberMybatisDao {
	private static final NewMemberMybatisDao dao = new NewMemberMybatisDao();
	private NewMemberMybatisDao() {};
	public static NewMemberMybatisDao getInstance()	{
		return dao;
	}
	
	public List<NewMember> selectAll(){
		SqlSession mapper = SqlSessionBean.getSession();
		
		List<NewMember> list = mapper.selectList("selectAll");
		
		mapper.close();
		return list;
	}
	
	public int insert(NewMember vo) {
		SqlSession mapper = SqlSessionBean.getSession();
		
		int result = mapper.insert("insert", vo);
		mapper.commit();
		mapper.close();
		
		return result;
	}
	
	public int update(NewMember member) {
		SqlSession mapper = SqlSessionBean.getSession();
		
		int result = mapper.update("update", member);
		mapper.commit();
		mapper.close();
		
		return result;
	}
	
	public int delete(String id) {
		SqlSession mapper = SqlSessionBean.getSession();
		
		int result = mapper.delete("delete", id);
		mapper.commit();
		mapper.close();
		
		return result;
	}
	
	public NewMember selectById(String id) {
		SqlSession mapper = SqlSessionBean.getSession();
		NewMember member = null;
		
		member = mapper.selectOne("selectOne", id);
		mapper.commit();
		mapper.close();
		
		return member;
	}
	
	public NewMember login(Map<String, String> map) {
		SqlSession mapper = SqlSessionBean.getSession();
		NewMember member = null;
		
		member = mapper.selectOne("login", map);
		mapper.commit();
		mapper.close();
		
		return member;
	}
	
	
}
