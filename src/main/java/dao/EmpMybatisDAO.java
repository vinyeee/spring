package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.EmpVO;
import vo.PageVO;

@Repository
public class EmpMybatisDAO {
	@Autowired
	SqlSession session;	
	public int getAllDataNum() {		
		String statement = "testdb.countEmp";
		int num = session.selectOne(statement);
		return num;
	}
	
	public List<EmpVO> listAll() {
		String statement = "testdb.selectEmp";
		List<EmpVO> list = session.selectList(statement);
		return list;
	}
	
	public List<EmpVO> listPart(PageVO vo) {
		String statement = "testdb.partEmp";
		List<EmpVO> list = session.selectList(statement, vo);
		return list;
	}
}
