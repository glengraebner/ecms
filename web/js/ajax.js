/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getData(url,callback)
{
    var xobj = new XMLHttpRequest();
    
    xobj.open("GET", url, true);
    xobj.onreadystatechange = function()
    {
        if(xobj.readyState === 4 && xobj.status === 200)
        {
            callback(xobj.responseText);
        }
    };
    xobj.send(null);    
}
