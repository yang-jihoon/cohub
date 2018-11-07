package com.cooperationHub.site.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cooperationHub.site.domain.SiteDomain;
import com.cooperationHub.site.domain.SiteRequest;

@Repository("siteDao")
public class SiteDAOImpl implements SiteDAO {
	Logger logger = LoggerFactory.getLogger(SiteDAOImpl.class);

	@Autowired
	@Qualifier("sqlSession")
	private SqlSession sqlSession;
	
	public List<SiteDomain> selectAll() {
		return sqlSession.selectList("SiteMapper.selectAll");
	}

	@Override
	public List<SiteDomain> selectTeam() {
		return sqlSession.selectList("SiteMapper.selectTeam");
	}

	@Override
	public List<SiteDomain> selectPart(SiteRequest request) {
		return sqlSession.selectList("SiteMapper.selectPart", request);
	}

	@Override
	public List<SiteDomain> selectSite(SiteRequest request) {
		return sqlSession.selectList("SiteMapper.selectSite", request);
	}

	@Override
	public boolean insertSite(SiteRequest request) {
		try {
			sqlSession.insert("SiteMapper.insertSite", request);
			return true;			
		} catch (Exception e) {
			logger.error("{}",e);
			return false;
		}
	}

	@Override
	public boolean deleteSite(SiteRequest request) {
		try {
			sqlSession.delete("SiteMapper.deleteSite", request);
			return true;			
		} catch (Exception e) {
			logger.error("{}",e);
			return false;
		}
	}

	@Override
	public boolean updateSite(SiteRequest request) {
		try {
			sqlSession.delete("SiteMapper.updateSite", request);
			return true;			
		} catch (Exception e) {
			logger.error("{}",e);
			return false;
		}
	}
}
