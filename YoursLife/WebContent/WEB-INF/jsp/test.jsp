<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>Example</title>
</head>
<body>
<c:forEach var="dimension" items="${params.res2}">
    <c:out value="${dimension.dimensionId} - ${dimension.name}"/> 
    <br/>
</c:forEach>
</body>
</html>