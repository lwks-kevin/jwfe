<%@ taglib prefix="jwfeTagLib" uri="/WEB-INF/tags/JwfeTag.tld"%>
<%@ page import="com.kvnl.jwfe.security.csrf.CsrfProtectionProvider" %>
<% 
	String csrfKey = CsrfProtectionProvider.getInstance().getReqAttrsKeyCsrfKey(); 
	String csrfValue = CsrfProtectionProvider.getInstance().getReqAttrsKeyCsrfValue(); 
%>>
<html>
<body>
<h2>HW</h2>
<jwfeTagLib:csrf key="index" isGenEl="false"/>
<%= request.getAttribute(csrfKey) %>
<%= request.getAttribute(csrfValue) %>
</body>
</html>
