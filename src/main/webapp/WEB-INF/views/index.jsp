<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
    .error {
      color: #ff0000;
    }
  </style>
</head>
<body>
	<c:url var="url" value="/ekle" />
	<c:set var="buton" value="EKLE" />
	<c:if test="${ !empty guncelle}">
		<c:url var="url" value="/guncelle" />
		<c:set var="buton" value="GÜNCELLE" />
	</c:if>

	<form:form  modelAttribute="yKisi"  method="post"
		action="${url}" >
		<fieldset>

			<legend>KİŞİ ${buton}</legend>


			<div>
				<label for="ad">Ad</label>
				<div>
					<form:hidden path="id" />
					<form:input id="ad" path="ad" type="text" />
					<form:errors path="ad" cssClass="error" />
				</div>
			</div>


			<div>
				<label for="soyad">Soyad</label>
				<div>
					<form:input id="soyad" path="soyad" type="text" />
					<form:errors path="soyad" cssClass="error" />
				</div>
			</div>


			<div>
				<label for="adres">Adres</label>
				<div>
					<form:input id="adres" path="adres" type="text" />
					<form:errors path="adres" cssClass="error" />
				</div>
			</div>


			<div>
				<label for="ekle"></label>
				<div>
					<input type="submit" id="buton" 
						value="${buton}" />
				</div>
			</div>

		</fieldset>
	</form:form>


	<c:forEach items="${kisiler}" var="kisi">
		<tr>
			<td><c:out value="${kisi.ad}" /></td>
			<td><c:out value="${kisi.soyad}" /></td>
			<td><c:out value="${kisi.adres}" /></td>

			<td><a href="sil?kisiId=${kisi.id}" type="button">SİL</a> <a
				href="duzelt?kisiId=${kisi.id}" type="button">DÜZELT</a></td>

		</tr>
		<br />
	</c:forEach>

</body>
</html>