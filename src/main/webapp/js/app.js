/**
 * Main script of the application
 */
$( document ).ready(function() {
    $('.burger-img').each(function(){
        SmartCrop.crop(this, {width: 100, height: 100}, function(result){
            console.log(result);
        });
    });
});