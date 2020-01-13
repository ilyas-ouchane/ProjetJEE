<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 		<%= session.getAttribute("status") %>
 		<%= session.getAttribute("password") %>
<%= session.getAttribute("email") %>
            <form action="UpdateHotel" method="post">
        
        
		<table>
		
		<c:if test="${hm != null}">
                    <input type="hidden" name="id" value="<c:out value='${hm.id_hotel}' />" />
                </c:if> 
                
		<c:if test="${hm != null}">
                    <input type="hidden" name="id_prs" value="<c:out value='${hm.id_prs}' />" />
                </c:if> 
		<tr>	
                <td>
                    <img src="pic_trulli.jpg" alt="Italian Trulli" name="img"> 
                  
                </td>
            </tr>
		<tr>	
			
                <th>Nom: </th>
                <td>
                    <input type="text" name="nom" size="45"
                            value="${hm.nom_hotel}"
                        />
                </td>
            </tr>
            <tr>
                <th>Ville: </th>
                <td>
                    <input type="text" name="ville" size="45"
                            value="'${hm.ville_hotel}"
                    />
                </td>
            </tr>
            <tr>
                <th>Description: </th>
                <td>
                    <input type="text" name="desc" size="5"
                            value="${hm.description}"
                    />
                </td>
            </tr>
             <tr>
                <th>Tel: </th>
                <td>
                    <input type="text" name="tel" size="5"
                            value="${hm.tel_hotel}"
                    />
                </td>
            </tr>
             <tr>
                <th>Adresse: </th>
                <td>
                    <input type="text" name="adresse" size="5"
                            value="${hm.adresse_hotel}"
                    />
                </td>
            </tr>
             <tr>
                <th>etoiles: </th>
                <td>
                    <input type="text" name="etoiles" size="5"
                            value="${hm.nbr_etoiles}"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
        
</body>
</html>