<!DOCTYPE html>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<br><br>
<div class="row">
<div class="col-md-3">Name:</div>
<div class="col-md-3">${client.name}</div>
<div class="col-md-3">Surname:</div>
<div class="col-md-3">${client.surname}</div>
</div>
<br>
<div class="row">
    <div class="col-md-4">
        <div class="container-fluid">
		<div class="row header">
				<div class="col-md-6">Account id</div>
				<div class="col-md-6">Balance</div>
		</div>
		<c:forEach items="${accounts}" var="account">
		<div class="row tab-row">
				<div class="col-md-6">${account.id}</div>
				<div class="col-md-6">${account.credit}</div>
		 </div>
		 </c:forEach>
		</div>
	</div>
		
	<div class="col-md-8">
		<div class="container-fluid">
		<div class="row header">
				<div class="col-md-4">Transaction id</div>
				<div class="col-md-4">Account id</div>
				<div class="col-md-4">Amount</div>
		</div>
		<c:forEach items="${transactions}" var="transaction">
		<div class="row tab-row">
				<div class="col-md-4">${transaction.id}</div>
				<div class="col-md-4">${transaction.account}</div>
				<div class="col-md-4">${transaction.amount}</div>
		</div>
		</c:forEach>
		</div>
	</div>
   </div>