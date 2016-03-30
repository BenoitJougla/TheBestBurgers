/**
 * Main script of the application
 */

/* fonction which display the correct burger details */
function displayDetail(id){
	
	if(id != undefined && id != 0){
		document.location.href="detailBurger?id="+id;
	}
}