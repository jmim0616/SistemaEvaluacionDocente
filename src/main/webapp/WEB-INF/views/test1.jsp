<!--Menu-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/project/js/layout/menu/menu.js"></script>

<!--Toolbar-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/project/js/layout/toolbar/toolbar.js"></script>


<!--prueba-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/project/js/test/test.js"></script>

<!--pruebas-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/project/js/test/tests.js"></script>




<div class="menu">

    <ul class="menu-list">

        <li><a href="#"> Opcion1 <i class="icon-right"><ion-icon  name="arrow-dropdown"></ion-icon></i></a>

            <ul>
                <li><a href=""> Opcion1.1</a></li>
                <li><a href=""> Opcion1.2 </a>
                </li>
            </ul>



        </li>
        <li><a href="#"> Opcion2 <i class="icon-right"><ion-icon  name="arrow-dropdown"></ion-icon></i> </a>
            <ul>
                <li><a href=""> Opcion2.1</a></li>
                <li><a href=""> Opcion2.2 </a>
                </li>
            </ul>
        </li>
        <li><a href=""> Opcion3 </a></li>
        <li><a href=""> Opcion4 </a></li>
        <li><a href=""> Opcion5 </a></li>
    </ul>


</div>



<div class="content">

    <h1>
        PRUEBA1</h1>
        
        
          <h2>A ${bienes} Z</h2>
        

<%@include file="/includes/toolbars/toolbar-teacher-update.jsp"%>


    

    <table class="table standard-table">

        <thead>

            <tr class="not">
                <th>Descripcion</th>
                <th>Mes</th>
                <th>Costo</th>
                <th>1</th>
                <th>2</th>
                <th>3</th>
                <th>4</th>
                <th>5</th>
            </tr>

        </thead>
        <tr>
            <td>Agua</td>
            <td>Enero</td>
            <td>$3000</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
        </tr>

        <tr>
            <td>energia</td>
            <td>Febrero</td>
            <td>$6000</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
        </tr>

        <tr>
            <td>Internet</td>
            <td>Junio</td>
            <td>$1000</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
        </tr>

        <tr>
            <td>Telefono</td>
            <td>Junio</td>
            <td>$500</td>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
            <td>5</td>
        </tr>


    </table>





</div>
