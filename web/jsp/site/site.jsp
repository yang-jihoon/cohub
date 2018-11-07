<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<c:set var="title" value="Co.Hub - ${team} ${part}"/>
<%@ include file="../common/header.jsp" %>
<script type="text/javascript" src="js/site.js" ></script>
</head>
<body>

	<!-- 	상단 메뉴 -->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-inner">		
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<img class="pull-left" style="width:50px; height:40px;padding-right: 10px;"src="img/11st_logo_black.jpg">
				<a class="brand" href="index.do">Cooperation Hub</a>
				<div class="nav-collapse collapse navbar-inverse-collapse">
				<ul class="nav">
					<c:forEach var="siteTeam" items="${siteTeamList}">
						<li class="${(team eq siteTeam.team) ? "active" : "" }"><a href="index.do?team=${siteTeam.team}">${siteTeam.team}</a></li>
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>		
	</div>
	
	<div class="row-fluid">
		<!-- 사이드 메뉴 -->
		<div class="span2" >
			<ul class="nav nav-list affix">
					<li class="nav-header">파트</li>
					<li class="${(part eq '') ? "active" : "" }"><a href="index.do?team=${team}">전체</a></li>
					<c:forEach var="sitePart" items="${sitePartList}">
						<li class="${(part eq sitePart.part) ? "active" : "" }"><a href="index.do?team=${team}&part=${sitePart.part}">${sitePart.part }</a></li>
					</c:forEach>
			</ul>
		</div>
		<!-- 본문 -->
		<div class="span10 pull-right" >
			<div class="row-fluid" >
				<div class="span6">
					<h4>관리 사이트<small> site</small></h4>
				</div>	
				<div class="span6" align="right" >
					<a href="#"  data-toggle="modal" data-target="#siteModal"><button type="button" class="btn" onclick="setSiteInsertValue('siteModal')"><i class="icon-plus"></i> 관리 사이트 추가</button></a>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<table class="table table-hovor">
						<thead>
							<tr>
								<th class="hide">팀명</th>
								<th>파트명</th>
								<th>사이트명</th>
<!-- 								<th>스테이지 URL</th> -->
								<th>URL</th>
								<th>설명</th>
								<th>수정</th>
								<th>삭제</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="site" items="${siteList}">
							<tr>			
								<td class="hide"><input type="hidden" id="team${site.id}" value="${site.team }" /></td>				
								<td id="part${site.id}">${site.part }</td>
								<td id="name${site.id}" title="${site.name}">${(fn:length(site.name) > 50) ? fn:substring(site.name,0,50) : site.name}</td>
<%-- 								<td id="stageUrl${site.id}"><a href="${site.stageUrl}" target="new" title="${site.stageUrl}">${(fn:length(site.stageUrl) > 45) ? fn:substring(site.stageUrl,0,45) : site.stageUrl}</a></td> --%>
								<td id="realUrl${site.id}"><a href="${site.realUrl}" target="_blank" title="${site.realUrl}">${(fn:length(site.realUrl) > 70) ? fn:substring(site.realUrl,0,70) : site.realUrl}</a></td>
								<td id="description${site.id}">${site.description }</td>
								<td><button type="button" class="btn" data-toggle="modal" data-target="#siteModal" onclick="setSiteUpdateValue('${site.id}')"><i class="icon-edit"></i></button></td>
								<td><button type="button" class="btn" onclick="siteDeleteAjax('${site.id}')"><i class="icon-trash"></i></button></td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
					
		</div>	
	</div>	
	<!-- Modal -->
	<div id="siteModal"" class="modal hide fade" style="width: 700px;'" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"  data-backdrop="static">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true" onclick="location.reload();">×</button>
			<h3 id="myModalLabel">관리 사이트 추가</h3>
		</div>
		<div class="modal-body" style="padding-right: 50px">
			<form class="form-horizontal">
				  <input type="hidden" id="modalId" >
				  <div class="control-group">
				    <label class="control-label" for="modalTeam">팀명</label>
				    <div class="controls">
				      <input type="text" class="span2"  id="modalTeam" placeholder="팀명"  value="${team}" >
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="modalPart">파트</label>
				    <div class="controls">
				      <input type="text" class="span2"  id="modalPart" placeholder="파트"  value="${part}" >
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="modalName">사이트명</label>
				    <div class="controls">
				      <input type="text" class="span5" id="modalName" placeholder="사이트명" >
				    </div>
				  </div>
				  <div class="control-group">
				    <label class="control-label" for="modalRealUrl">URL</label>
				    <div class="controls">
				      <input type="text" class="span5" id="modalRealUrl" placeholder="URL"  value="http://">
				    </div>
				  </div>				  
				  <div class="control-group">
				    <label class="control-label" for="modalDescription">설명</label>
				    <div class="controls">
				      <input type="text" class="span5" id="modalDescription" placeholder="설명" >
				    </div>
				  </div>
			</form>				  
		</div>
		<div class="alert alert-success hide" id="alertSuccess">
			<h4>Success</h4>
			Save success 
		</div>
		<div class="alert alert-block hide" id="alertBlock">
			<h4>Warning!</h4>
			<span id="blockMsg"></span>
		</div>
		<div class="alert alert-error hide" id="alertError">
			<h4>Fail</h4>
			Save fail  : <span id="errorMsg"></span>
		</div>
		<div class="modal-footer">
			<button class="btn"  data-dismiss="modal" aria-hidden="true" onclick="location.reload();">취소</button>
			<button id="modalSaveBtn" class="btn btn-primary">저장</button>
		</div>
	</div>	
</body>
</html>