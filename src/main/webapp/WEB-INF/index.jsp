<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<style><%@include file="/WEB-INF/css/style.css"%></style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>

<script type="text/javascript">

function hideElements(){
	var tab = document.getElementsByClassName("div");
    for (var i = 0; i < tab.length; i++) {
    	tab[i].style.display = "none";
    }
    var step = document.getElementsByClassName("step");
    for (var i = 0; i < step.length; i++) {
    	step[i].className = step[i].className.replace(" active", "");
    }
    var messages = document.getElementsByClassName("message");
    for (var i = 0; i < messages.length; i++) {
    	messages[i].style.display = "none";
    }
    
    document.getElementById("AccountForm").reset();
    document.getElementById("TransactionForm").reset();
    document.getElementById("searchForm").reset();
        
    document.getElementById("results").style.display = "none";
}
    $(document).ready(function() {
    	$("#createAccount").click(function(){
    		var options = {
    				url : "/create-account",
    				type : 'POST',
    				data : $('#AccountForm').serialize(),
    				async : false,
    				success : function(data) {
    					if(data == 'OK')
    						{
    						$(".accountSuccess").show();
    			    		$(".accountError").hide();
    						}
    					else
    						{
    						$(".accountSuccess").hide();
    			    		$(".accountError").show();
    						}
    				}
    		};
    		$.ajax(options);
    	});  
    	$("#makeTransaction").click(function(){
    		var options = {
    				url : "/make-transaction",
    				type : 'POST',
    				data : $('#TransactionForm').serialize(),
    				async : false,
    				success : function(data) {
    					if(data == 'OK')
    						{
    						$(".success").show();
    			    		$(".error").hide();
    						}
    					else
    						{
    						$(".success").hide();
    			    		$(".error").show();
    						}
    				}
    		};
    		$.ajax(options);
    	});
    	$("#search").click(function(){
    		var options = {
    				url : "/customer-info",
    				data : $('#searchForm').serialize(),
    				type : 'GET',
    				async : false,
    				success : function(data) {
    					$("#results").html(data);
    					$("#results").show();
    				}
    		};
    		$.ajax(options);
    	});
    	$("#openTab1").click(function(){
    		hideElements();
    		document.getElementById("tab1").style.display = "block";
    		document.getElementById("openTab1").className += " active";
    	});
    	$("#openTab2").click(function(){
    		hideElements();
    		document.getElementById("tab2").style.display = "block";
    		document.getElementById("openTab2").className += " active";
    	});
    	$("#openTab3").click(function(){
    		hideElements();
    		document.getElementById("tab3").style.display = "block";
    		document.getElementById("openTab3").className += " active";
    	});
    });
</script>

<ul class="nav nav-tabs nav-justified">
		<li id="openTab1" class="step nav-item active"><a class="nav-link" href="#">Create Secondary Account</a></li>
		<li id="openTab2" class="step nav-item"><a class="nav-link" href="#">Review Customer Informations</a></li>
		<li id="openTab3" class="step nav-item"><a class="nav-link" href="#">Make a transaction</a></li>
</ul>

<div id="tab1" class="div">
        <div class="alert-success message accountSuccess" style="display:none;">
            the account was created successfully!
        </div>
        <div class="alert alert-danger message accountError" style="display:none;">
            The system encountered a problem while creating the new account!
        </div>
        <form:form modelAttribute="AccountForm" id="AccountForm">
        <div class="row">
            <div class="col-md-2">Client Id:</div>
	        <div class="col-md-3"><input type="number" min="0" class="form-control" name="clientId"/></div>
	        <div class="col-md-2">Initial credit :</div>
	        <div class="col-md-3"><input type="number" min="0" class="form-control" name="credit"/></div>
        </div>
        <div class="row">
	        <div class="col-md-8"></div>
	        <div class="col-md-2"><input type="button" class="btn blue-btn" id="createAccount" value="Create" /></div>
        </div>
        
        </form:form>
</div>

<div id="tab2" style="display:none;" class="div">
    
    <form:form modelAttribute="AccountForm" id="searchForm">
     <div class="row">
	        <div class="col-md-2">Client Id:</div>
	        <div class="col-md-6"><input type="number" min="0" class="form-control" name="clientId"/></div>
	        <div class="col-md-2"><input type="button" class="btn blue-btn" value="Search" id="search"/></div>
        </div>
      </form:form>  
     <div id="results">
     </div>
</div>

<div id="tab3" style="display:none;" class="div">
        <div class="alert-success message success" style="display:none;">
            the transaction was created successfully!
        </div>
        <div class="alert alert-danger message error" style="display:none;">
            The system encountered a problem while creating the transaction!
        </div>
        <form:form modelAttribute="AccountForm" id="TransactionForm">
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-2">Client Id:</div>
	        <div class="col-md-6"><input type="number" min="0" class="form-control" name="clientId"/></div>
        </div>
        <div class="row">
	        <div class="col-md-2"></div>
	        <div class="col-md-2">Account Id:</div>
	        <div class="col-md-6"><input type="number" min="0" class="form-control" name="id"/></div>
        </div>
        <div class="row">
	        <div class="col-md-2"></div>
	        <div class="col-md-2">Amount :</div>
	        <div class="col-md-6"><input type="number" min="0" class="form-control" name="credit"/></div>
        </div>
        <div class="row">
	        <div class="col-md-8"></div>
	        <div class="col-md-2"><input type="button" class="btn blue-btn" id="makeTransaction" value="Create"/></div>
        </div>
        
        </form:form>
        
</div>
</html>