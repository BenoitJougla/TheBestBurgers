<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="rating">
	<input type="radio" name="${param.id}" id="${param.id}-note-5" value="5" 
		<c:if test="${param.value == '5'}" >checked="checked"</c:if> ><label for="${param.id}-note-5">★</label>
	<input type="radio" name="${param.id}" id="${param.id}-note-4" value="4"
		<c:if test="${param.value == '4'}" >checked="checked"</c:if> ><label for="${param.id}-note-4">★</label>
	<input type="radio" name="${param.id}" id="${param.id}-note-3" value="3"
		<c:if test="${param.value == '3'}" >checked="checked"</c:if> ><label for="${param.id}-note-3">★</label>
	<input type="radio" name="${param.id}" id="${param.id}-note-2" value="2"
		<c:if test="${param.value == '2'}" >checked="checked"</c:if> ><label for="${param.id}-note-2">★</label>
	<input type="radio" name="${param.id}" id="${param.id}-note-1" value="1"
		<c:if test="${param.value == '1'}" >checked="checked"</c:if> ><label for="${param.id}-note-1">★</label>
</div>