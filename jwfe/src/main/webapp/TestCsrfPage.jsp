<%@ taglib prefix="jwfeTagLib" uri="/WEB-INF/tags/JwfeTag.tld"%>

<html>
<body>

	<form method="POST" action="/jwfe/testCsrf/testPost1">
		<jwfeTagLib:csrf key="test" isGenEl="true"/>
		<button type="submit">submit</button>
	</form>

</body>
</html>
