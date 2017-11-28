$(document).ready(function () {
    $(window).scroll(function () {
        var barra = $(window).scrollTop();
        var posicion = (barra * 0.05);
        $('body').css({
            'background-position': '0 -' + posicion + 'px'
        });
    });
});


$(document).ready(function () {
    $(window).scroll(function () {
        var barra = $(window).scrollTop();
        var posicion = (barra * 0.05);
        $('body').css({
            'background-position': '0 -' + posicion + 'px'
        });
    });
});

$(document).ready(function () {
    $(window).scroll(function () {
        var barra = $(window).scrollTop();
        var posicion = (barra * 1);
        $('circulito').css({
            'background-position': '0 -' + posicion + 'px'
        });
    });
});


