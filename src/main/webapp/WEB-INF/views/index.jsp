<!DOCTYPE html>
<html lang="en">

<head>

<%@include file="/includes/statics-resources/index-srcs.jsp"%>

    <title>INDEX</title>

</head>


<body>

    <header>

        <div class="row">

            <div class="logo">
                <img src="/SistemaEvaluacionDocente/resources/project/img/logo-uao.png" />
            </div>
            
			   <nav class="main-bar-navigation">

                <ul>
                    <li><a id="teachers" href="./Teachers">Docentes</a></li>
<!--                     <li><a id="subjects" href="#">Asignaturas</a></li> -->
<!--                     <li><a href="#">Cursos</a></li> -->
                    <li><a id="faculties" href="./Faculties">Facultades</a></li>
                    <li><a id="disciplinaryAreas" href="./DisciplinaryAreas">Areas Disciplinarias</a></li>
                    <li><a id="academicPrograms" href="./AcademicPrograms">Programas Academicos</a></li>
                    <li><a id="departments" href="#">Departamentos</a></li>
<!--                     <li><a href="#">Personas</a></li> -->
<!--                     <li><a href="#">Periodos Academicos</a></li> -->
					<li><a id="users" href="#">Usuarios</a></li>
                </ul>
            </nav>

            <div class="user">
            	<h5>${SessionId}</h5>
            	<form action="./Login/logOut">
  				<input type="image" 
  				src="/SistemaEvaluacionDocente/resources/project/img/exit-icons-20.png" 
  				alt="Submit" width="48" height="48">
				</form>
            
            </div>
            
        </div>
        


    </header>

<div class="clearfix">
    <div class="success">
     <a href="#" class="close">X</a>
	 <a class="icon"><ion-icon name="checkmark-circle-outline"></ion-icon></a> 
	<label class="message"></label>
    </div>
    <div class="error">
    <a href="#" class="close">X</a>
	 <a class="icon" ><ion-icon name="warning"></ion-icon></a>
	<label class="message"></label>
    </div>
</div>

    <section class="container">



    </section>


    <footer class="clearfix">


    </footer>





</body>



</html>

