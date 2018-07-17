<!DOCTYPE html>
<html lang="en">

<head>

<%@include file="/includes/statics-resources/index-srcs.jsp"%>

    <title>INDEX</title>

</head>


<body>


	<form action="./Teachers/CreateExcel" method="POST"
		enctype="multipart/form-data">
		Excel upload	
		<input  type="file"  name="file" accept= ".xls, .xlsx" /> <input
			type="submit" value= "upload"/>

	<br> 
	<br>
	
	<h3>Registrar Docente</h3>

	<input id="buttonCreateTeacherExcel" class="button add-button"
	type="submit" value="Registrar Docente" />
	
	</form>

    <header>

        <div class="row">

            <div class="logo">
                <img src="resources/project/img/logo-uao.png" />
            </div>
            
			   <nav class="main-bar-navigation">

                <ul>
                    <li><a id="teachers" href="#">Docentes</a></li>
<!--                     <li><a id="subjects" href="#">Asignaturas</a></li> -->
<!--                     <li><a href="#">Cursos</a></li> -->
                    <li><a id="faculties" href="#">Facultades</a></li>
                    <li><a id="disciplinaryAreas" href="#">Areas Disciplinarias</a></li>
                    <li><a id="academicPrograms" href="#">Programas Academicos</a></li>
                    <li><a id="departments" href="#">Departamentos</a></li>
<!--                     <li><a href="#">Personas</a></li> -->
<!--                     <li><a href="#">Periodos Academicos</a></li> -->
                </ul>
            </nav>
            
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

