package com.cooperationHub.site.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cooperationHub.common.StringUtil;
import com.cooperationHub.site.domain.SiteDomain;
import com.cooperationHub.site.domain.SiteRequest;
import com.cooperationHub.site.service.SiteService;


@Controller
public class SiteController {
	
	@Autowired
	@Qualifier("siteService")
	private SiteService siteService;
	
	@RequestMapping("/index.do")
	public ModelAndView indexView(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		String team = StringUtil.nvlEncode(request.getParameter("team"),"");
		String part = StringUtil.nvlEncode(request.getParameter("part"),"");
		
		List<SiteDomain> siteList = new ArrayList<SiteDomain>();
		List<SiteDomain> siteTeamList = siteService.selectTeam();
		List<SiteDomain> sitePartList = new ArrayList<SiteDomain>();
		
		if (siteTeamList.size() > 0) {
			if ("".equals(team) ) {
				team = siteTeamList.get(0).getTeam();
			}
			
			SiteRequest siteRequest = new SiteRequest();
			siteRequest.setTeam(team);
			sitePartList = siteService.selectPart(siteRequest);
			
			if (!"all".equals(part)) {
				siteRequest.setPart(part);				
			}
			
			siteList = siteService.selectSite(siteRequest);			
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("site/site");
		modelAndView.addObject("siteList", siteList);
		modelAndView.addObject("siteTeamList", siteTeamList);
		modelAndView.addObject("sitePartList", sitePartList);
		modelAndView.addObject("team", team);
		modelAndView.addObject("part", part);
		return modelAndView;
	}
	
	@RequestMapping("/siteInsertAjax.do")
	public void siteInsertAjax(HttpServletRequest request,  HttpServletResponse response) throws IOException {

		String team = StringUtil.nvlEncode(request.getParameter("modalTeam"),"");
		String part = StringUtil.nvlEncode(request.getParameter("modalPart"),"");
		String name = StringUtil.nvlEncode(request.getParameter("modalName"),"");
		String stageUrl = StringUtil.nvlEncode(request.getParameter("modalStageUrl"),"");
		String realUrl = StringUtil.nvlEncode(request.getParameter("modalRealUrl"),"");
		String description = StringUtil.nvlEncode(request.getParameter("modalDescription"),"");

		JSONObject resultJSON = new JSONObject();
		try {
			SiteRequest siteRequest = new SiteRequest();
			siteRequest.setTeam(team);
			siteRequest.setPart(part);
			siteRequest.setName(name);
			siteRequest.setStageUrl(stageUrl);
			siteRequest.setRealUrl(realUrl);
			siteRequest.setDescription(description);
		
			boolean result = siteService.insertSite(siteRequest);
			resultJSON.put("result", result);
		} catch (Exception e) {			
			resultJSON.put("result", false);
			resultJSON.put("msg", e.toString());
		}		
				
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(resultJSON.toString());		
		response.flushBuffer();	
	}
	
	@RequestMapping("/siteDeleteAjax.do")
	public void siteDeleteAjax(HttpServletRequest request,  HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(StringUtil.nvl(request.getParameter("id"),"0"));

		JSONObject resultJSON = new JSONObject();
		try {
			SiteRequest siteRequest = new SiteRequest();
			siteRequest.setId(id);
		
			boolean result = siteService.deleteSite(siteRequest);
			resultJSON.put("result", result);
		} catch (Exception e) {			
			resultJSON.put("result", false);
			resultJSON.put("msg", e.toString());
		}		
				
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(resultJSON.toString());		
		response.flushBuffer();	
	}
	
	@RequestMapping("/siteUpdateAjax.do")
	public void siteUpdateAjax(HttpServletRequest request,  HttpServletResponse response) throws IOException {

		int id = Integer.parseInt(StringUtil.nvl(request.getParameter("modalId"),"0"));
		String team = StringUtil.nvlEncode(request.getParameter("modalTeam"),"");
		String part = StringUtil.nvlEncode(request.getParameter("modalPart"),"");
		String name = StringUtil.nvlEncode(request.getParameter("modalName"),"");
		String stageUrl = StringUtil.nvlEncode(request.getParameter("modalStageUrl"),"");
		String realUrl = StringUtil.nvlEncode(request.getParameter("modalRealUrl"),"");
		String description = StringUtil.nvlEncode(request.getParameter("modalDescription"),"");

		JSONObject resultJSON = new JSONObject();
		try {
			SiteRequest siteRequest = new SiteRequest();
			siteRequest.setId(id);
			siteRequest.setTeam(team);
			siteRequest.setPart(part);
			siteRequest.setName(name);
			siteRequest.setStageUrl(stageUrl);
			siteRequest.setRealUrl(realUrl);
			siteRequest.setDescription(description);
		
			boolean result = siteService.updateSite(siteRequest);
			resultJSON.put("result", result);
		} catch (Exception e) {			
			resultJSON.put("result", false);
			resultJSON.put("msg", e.toString());
		}		
				
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.getWriter().write(resultJSON.toString());		
		response.flushBuffer();	
	}
}
