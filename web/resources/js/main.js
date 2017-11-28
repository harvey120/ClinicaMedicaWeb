$(document).ready(function () {
    $('.tooltips-general').tooltip('hide');
    $('.mobile-menu-button').on('click', function () {
        var mobileMenu = $('.navbar-lateral');
        if (mobileMenu.css('display') == 'none') {
            mobileMenu.fadeIn(300);
        } else {
            mobileMenu.fadeOut(300);
        }
    });
    
    $('.dropdown-menu-button').on('click', function () {
        var dropMenu = $(this).next('ul');
        dropMenu.slideToggle('slow');
    });
    
    $('.exit-system-button').on('click', function (e) {
        e.preventDefault();
        var LinkExitSystem = $(this).attr("data-href");
        swal({
            title: "Estas seguro?",
            text: "Quieres salir del sistema y cerrar la sesion actual",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#5cb85c",
            confirmButtonText: "Si, salir",
            cancelButtonText: "No, cancelar",
            animation: "slide-from-top",
            closeOnConfirm: false
        }, function () {
            window.location = LinkExitSystem;
        });
    });
    
    
    $('.search-persona-button').click(function (e) {
        e.preventDefault();
        var LinkSearchBook = $(this).attr("data-href");
        swal({
            title: "Necesitas ayuda",
            text: "En esta pagina podra registrar nuevas personas al cual podra ver modifcar y eliminar tambien en la pestana de listado de personas",
            closeOnConfirm: false,
            animation: "slide-from-top",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "#3598D9",
        });
    });
    
     $('.search-paciente-button').click(function (e) {
        e.preventDefault();
        var LinkSearchBook = $(this).attr("data-href");
        swal({
            title: "¿Ayuda?",
            text: "En esta pagina podra registrar nuevos pacientes al cual podra ver modifcar y eliminar tambien en la pestana de listado de pacientes",
            closeOnConfirm: false,
            animation: "slide-from-top",
            confirmButtonText: "Aceptar",
            confirmButtonColor: "#3598D9",
        });
    });
    
    
});

(function ($) {
    $(window).load(function () {
        $(".custom-scroll-containers").mCustomScrollbar({
            theme: "dark-thin",
            scrollbarPosition: "inside",
            autoHideScrollbar: true,
            scrollButtons: {enable: true}
        });
    });
})(jQuery);