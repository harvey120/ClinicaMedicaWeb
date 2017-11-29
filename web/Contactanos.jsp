<%-- 
    Document   : Contactanos
    Created on : 26/11/2017, 11:56:22 AM
    Author     : DanielG
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contactanos</title>
        <link href="resourcesFronted/booststrpa-4.0.0-zip/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="resourcesFronted/booststrpa-4.0.0-zip/css/Stylepagemail.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <!--=============Menu principal==================-->
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <a class="navbar-brand" href="faces/index.xhtml">Inicio</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarCollapse">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="faces/Valores.xhtml">Valores <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="faces/Instalaciones.xhtml">Instalaciones</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="faces/Equipo.xhtml">Equipos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="faces/personal.xhtml">Personal</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="faces/Localicacion.xhtml">Localizanos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="Contactanos.jsp">Contactanos</a>
                    </li>
                </ul>
                <form class="form-inline mt-2 mt-md-0">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">  <a href="login.xhtml">Inicio de Sesion</a> </button>
                </form>
            </div>
        </nav>
        <!--========================Menu principal==================================-->

        <header>
            <div class="col-sm-12">
                <strong> <h1 class="titulo">Llena Los campos con la información Solicitada</h1> </strong>
            </div>
        </header>

        <section>
            <div class="col-sm-4 container">

            </div>

            <div id="formulario" class="col-sm-4 container-fluid">
                <div class="form-group">
                    <form method="POST" action="EmailServlet">
                        <label for="subject">Nombre: </label><input id="subject" class="form-control form-control-lg" name="subject" type="text"/><br/>
                        <label for="body">Mensaje: </label>
                        <textarea name="body" cols="60" class="form-control form-control-lg" rows="15"></textarea><br/>

                        <div class="form-check">
                            <input type="submit" class="btn alert-success btn-lg btn-block" value="Enviar"/>
                        </div>
                    </form>
                </div>
            </div>

            <div class="col-sm-4 container">

            </div>
        </section>

        <footer>
            <div class="container col-md-12">
                <strong> DEHECK SYSTEMS 2017 </strong>
            </div>
        </footer>
    </body>
</html>
