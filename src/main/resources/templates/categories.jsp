<%@taglib uri="http://java.sun.com/jsp/jstL/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<div>
	${exceptions}
</div>
<div id="formCat">
	<f:form modelAttribute="categories" action="saveCat" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Categorie</td>
				<td><f:input path="idcategorie" /></td>
				<td><f:errors path="idcategorie" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>NOM Categorie</td>
				<td><f:input path="nomcategorie" /></td>
				<td><f:errors path="nomcategorie" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description" /></td>
				<td><f:errors path="description" cssClass="errors"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<td><input type="file" name="file" /></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>
</div>
<div id="">
	<table>
		<tr>
			<th>ID</th>
			<th>NOM CAT</th>
			<th>PHOTO</th>
		</tr>
		<c:forEach items="${categories}" var="cat">
			<tr>
				</td>${cat.idcategories}<td>
				</td>${cat.nomcategories}<td>
				</td>${cat.description}<td>
				<td><img src="photoCat?idCat=${cat.idcategorie}"/></td>
				<td><a href="suppCat?idCat=${cat.idcategorie}">Supp</a></td>
				<td><a href="editCat?idCat=${cat.idcategorie}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
