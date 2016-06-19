/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var req;

function initPage()
{
    document.getElementById('div_panel1').style.display = "inline";
    document.getElementById('div_panel2').style.display = "none";
    document.getElementById('div_panel3').style.display = "none";
    document.getElementById('div_panel2_nav').style.width = "250px";
    redisplayPage();
}

function redisplayPage()
{
    var containerheight = 0;
    var containerwidth = 0;
    var mainheight = 0;
    var mainheighttxt = "";
    
    containerheight = window.innerHeight;
    containerwidth = window.innerWidth;
    
    mainheight = containerheight - 102;
    mainheighttxt = String(mainheight);
    
    document.getElementById('div_main').style.height = mainheighttxt + "px";
    document.getElementById('div_panel2_nav').style.height = mainheighttxt + "px";
    document.getElementById('div_panel2_content').style.height = mainheighttxt + "px";
}

function selectMenuItem(item)
{
    var itemtxt = "";
    
    document.getElementById('div_panel1').style.display = "none";
    document.getElementById('div_panel2').style.display = "none";
    document.getElementById('div_panel3').style.display = "none";
    itemtxt = String(item);
    document.getElementById('div_panel' + itemtxt).style.display = "inline";
    loadPanel(item);
}

function loadPanel(item)
{
    var url = "";
    
    if(item === 2)
    {
        url = "LibraryServlet?action=getlist";
        getData(url,
            function(response)
            {
                var data = (new window.DOMParser()).parseFromString(response, "text/xml");
                
                loadModuleList(data);
            }
        );
    }
}