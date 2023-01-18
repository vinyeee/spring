package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MeetingVO;
import vo.ReplyVO;
@Repository
public class MeetingMyBatisDAO {
	@Autowired
	SqlSession session = null;	
	public List<MeetingVO> listM(){
		String statement = "resource.MeetingMapper.selectMeeting";
		List<MeetingVO> list = session.selectList(statement);
		return list;
	}
	
	public MeetingVO oneM(){
		String statement = "resource.MeetingMapper.selectOneMeeting";
		MeetingVO vo = session.selectOne(statement);
		return vo;
	}
	
	public List<MeetingVO> searchM(String keyword){
		String statement = "resource.MeetingMapper.searchMeeting";
		List<MeetingVO> list = session.selectList(statement, keyword);
        return list;
	}
	
	public boolean insertM(MeetingVO vo) {
		boolean result = true;
		String statement = "resource.MeetingMapper.insertMeeting";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	
	public boolean deleteM(int id) {
		boolean result = true;
		String statement = "resource.MeetingMapper.deleteMeeting";
		if(session.delete(statement, id) != 1)
			result = false;
		return result;
	}
	
	public boolean updateM(MeetingVO vo) {
		boolean result = true;
		String statement = "resource.MeetingMapper.updateMeeting";
		if(session.update(statement, vo) != 1)
			result = false;
		return result;	
	}	
	public List<ReplyVO> listReply(int refid) {
		String statement = "resource.MeetingMapper.replySelectMeeting";
		List<ReplyVO> list = session.selectList(statement, refid);
        return list;		
	}

	public boolean insertReply(ReplyVO vo) {
		boolean result=true;
		String statement = "resource.MeetingMapper.replyInsertMeeting";
		if(session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
}
