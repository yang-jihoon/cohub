package com.cooperationHub.site.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cooperationHub.site.dao.SiteDAO;
import com.cooperationHub.site.domain.SiteDomain;
import com.cooperationHub.site.domain.SiteRequest;

@Service("siteService")
public class SiteServiceImpl implements SiteService {
	@Autowired
	@Qualifier("siteDao")
	private SiteDAO siteDao;
	
	public List<SiteDomain> selectAll() {
		return siteDao.selectAll();
	}

	@Override
	public List<SiteDomain> selectTeam() {
		return siteDao.selectTeam();
	}

	@Override
	public List<SiteDomain> selectPart(SiteRequest request) {
		return siteDao.selectPart(request);
	}

	@Override
	public List<SiteDomain> selectSite(SiteRequest request) {
		return siteDao.selectSite(request);
	}

	@Override
	public boolean insertSite(SiteRequest request) {
		return siteDao.insertSite(request);
	}

	@Override
	public boolean deleteSite(SiteRequest request) {
		return siteDao.deleteSite(request);
	}

	@Override
	public boolean updateSite(SiteRequest request) {
		return siteDao.updateSite(request);
	}
}
