package dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vo.VisitorVO;
@Repository
public class VisitorMybatisDAO {	
	@Autowired
	SqlSession session;	
	public List<VisitorVO> list() {
		List<VisitorVO> list = null;
		try {
			String statement = "resource.VisitorMapper.selectVisitor";
			list = session.selectList(statement);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}
	
	public VisitorVO one(int id) {
		VisitorVO vo = null;
		try {
			String statement = "resource.VisitorMapper.selectVisitorOne";
			vo = session.selectOne(statement, id);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return vo;
	}
	
	public List<VisitorVO> search(String keyword) {
		List<VisitorVO> list = null;
		try {			
			String statement = "resource.VisitorMapper.searchVisitor";
			list = session.selectList(statement, keyword);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;		
	}
	
	public boolean insert(VisitorVO visitor) {
		boolean result = false;
		try {
			String statement = "resource.VisitorMapper.insertVisitor";
			session.insert(statement, visitor);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public boolean delete(String id) {
		boolean result = false;
		try {			
			String statement = "resource.VisitorMapper.deleteVisitor";
			session.delete(statement, Integer.parseInt(id));
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public boolean update(VisitorVO visitor) {
		boolean result = false;
		try {			
			String statement = "resource.VisitorMapper.updateVisitor";
			session.update(statement, visitor);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
}
