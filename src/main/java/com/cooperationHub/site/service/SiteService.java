package com.cooperationHub.site.service;

import java.util.List;

import com.cooperationHub.site.domain.SiteDomain;
import com.cooperationHub.site.domain.SiteRequest;

public interface SiteService {
	public List<SiteDomain> selectAll();
	public List<SiteDomain> selectTeam();
	public List<SiteDomain> selectPart(SiteRequest request);
	public List<SiteDomain> selectSite(SiteRequest request);
	public boolean insertSite(SiteRequest request);
	public boolean deleteSite(SiteRequest request);
	public boolean updateSite(SiteRequest request);
}
