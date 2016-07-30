/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * Dashboard (Panel1) Procedures
 */

/* 
 * Modules (Panel2) Procedures
 */

function loadModuleList(data) {

    //var panel = document.getElementById('div_panel2');
    var navpanel = document.getElementById('div_panel2_nav');
    var modules;
    var modulescount = 0;
    var i = 0;
    
    // no matches returned
    if (data !== null && data !== "")
    {
        while(navpanel.childNodes.length > 0)
        {
            navpanel.removeChild(navpanel.lastChild);
        }
        //http://www.w3schools.com/xml/dom_element.asp
        modules = data.childNodes[0].childNodes;
        modulescount = modules.length;
        for(i=0;i<modulescount;i++)
        {
            var div1 = document.createElement('div');
            var txt1 = document.createTextNode(modules[i].textContent);
            
            div1.appendChild(txt1);
            navpanel.appendChild(div1);
        }
    }
}