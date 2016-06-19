<%-- 
    Document   : index
    Created on : Jun 13, 2016, 8:29:13 PM
    Author     : Glen Graebner
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/main.js"></script>
        <script src="js/ajax.js"></script>
        <script src="js/panels.js"></script>
        <link rel="stylesheet" href="css/main.css">
        <title>ECMS</title>
    </head>
    <body onload="initPage();" onresize="redisplayPage();">
        <div id="div_container">
            <div id="div_header">
                <div id="titleblock">ECMS</div>
            </div>
            <div id="div_menu">
                <div class="menuitem" id="div_menuitem1" onclick="selectMenuItem(1);">Dashboard</div>
                <div class="menuitem" id="div_menuitem2" onclick="selectMenuItem(2);">Library</div>
                <div class="menuitem" id="div_menuitem3" onclick="selectMenuItem(3);">Publications</div>
            </div>
            <div id="div_main">
                <div id="div_panel1">

                </div>
                <div id="div_panel2">
                    <div id="div_panel2_nav"></div>
                    <div id="div_panel2_content"></div>
                </div>
                <div id="div_panel3">

                </div>
            </div>
            <div id="div_tray"></div>
        </div>
    </body>
</html>
