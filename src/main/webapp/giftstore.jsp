<%@ include file="/common/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ include file="/common/taglibs.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
    <head>
        <%@ include file="/common/meta.jsp" %>
        <title><decorator:title/> | <fmt:message key="webapp.name"/></title>

        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["csstheme"]}/theme.css'/>" />
        <link rel="stylesheet" type="text/css" media="print" href="<c:url value='/styles/${appConfig["csstheme"]}/print.css'/>" />
        
        <script type="text/javascript" src="<c:url value='/scripts/jquery-1.4.2.js'/>"></script>
      
        <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>

		<script type="text/javascript">
		$(document).ready(function () {   
			  
		    /* Horizontal Menu */  
		    $('#hor li a').hover(   
		        function () {   
		            //convert current height to negative value   
		            height = $(this).height() * (-1);   
		            $(this).stop().animate({'backgroundPosition':'(0 ' + height + ')'}, {duration:200});       
		        },    
		               
		        function () {   
		            //reset the top position   
		            $(this).stop().animate({'backgroundPosition':'(0 0)'}, {duration:200});    
		        }   
		    );   
		  
		    /* Vertical Menu*/  
		    $('#ver li a').hover(   
		        function () {   
		            //convert current width to negative value   
		            width = $(this).width() * (-1);   
		            $(this).stop().animate({'backgroundPosition':'(' + width + ' 0)'}, {duration:200});    
		        },    
		               
		        function () {   
		            //reset the left position   
		            $(this).stop().animate({'backgroundPosition':'(0 0)'}, {duration:200});    
		        }   
		    );   
		           
		});  		
		</script>

		<style type="text/css">
/* CSS Style for Vertical Menu */      
       
#ver {   
    list-style:none;   
    padding:0;   
    margin:0;      
}   
           
    #ver li {   
        padding:2px;       
    }   
           
    #ver li a {   
        display:block;   
        height:12px;   
        text-indent:-999em;   
    }              
               
    #ver a.home {   
        width:47px;    
        background:url(hHome.gif) no-repeat 0 0;       
    }   
  
    #ver a.download {   
        width:95px;    
        background:url(hDownload.gif) no-repeat 0 0;       
    }   
               
    #ver a.contact {   
        width:74px;    
        background:url(hContact.gif) no-repeat 0 0;    
    }   
               
               
    .clear {   
        clear:both;    
    }     
		</style>
        <decorator:head/>
    </head>
<body <decorator:getProperty property="body.id" writeEntireProperty="true"/><decorator:getProperty property="body.class" writeEntireProperty="true"/>>

    <div id="page">
        <div id="header" class="clearfix">
            <jsp:include page="/common/header.jsp"/>
        </div>

        <div id="content" class="clearfix">
            <div id="main">
                <%@ include file="/common/messages.jsp" %>
                <h1><decorator:getProperty property="meta.heading"/></h1>
<b>Vertical Menu</b>  
<ul id="ver">  
    <li><a href="#" class="home">Home</a></li>  
    <li><a href="#" class="download">Download</a></li>  
    <li><a href="#" class="contact">Contact</a></li>  
</ul>

            </div>

            <c:set var="currentMenu" scope="request"><decorator:getProperty property="meta.menu"/></c:set>
            <c:if test="${currentMenu == 'AdminMenu'}">
            <div id="sub">
                <menu:useMenuDisplayer name="Velocity" config="cssVerticalMenu.vm" permissions="rolesAdapter">
                    <menu:displayMenu name="AdminMenu"/>
                </menu:useMenuDisplayer>
            </div>
            </c:if>

            <div id="nav">
                <div class="wrapper">
                    <h2 class="accessibility">Navigation</h2>
                    <jsp:include page="/common/menu.jsp"/>
                </div>
                <hr/>
            </div><!-- end nav -->
        </div>

        <div id="footer" class="clearfix">
            <jsp:include page="/common/footer.jsp"/>
        </div>
    </div>
</body>
</html>
