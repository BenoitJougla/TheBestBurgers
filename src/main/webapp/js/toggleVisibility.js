function Hide(addr) 
{
	document.getElementById(addr).style.display = "none";	
}

function Show(addr) 
{
	document.getElementById(addr).style.display = "block";	
}

function toggle(anId, button, hideclass, showclass)
{
	if (document.getElementById(anId).style.display == "none")
	{
		document.getElementById(button).className  = hideclass;
		Show(anId);	
	}
	else
	{	
		document.getElementById(button).className  = showclass;
		Hide(anId);	
	}
}