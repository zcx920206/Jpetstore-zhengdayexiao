<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script type="text/javascript" src="resources/js/jquery-2.1.4.min.js"></script>
  <title>JPetStore Demo</title>

  <script>
    function getallstudent(){
      $('.studentinfo').empty();
      $.ajax({
        url: "getstudent?cname="+$('#course_name').val(),
        type:"GET",
        dataType: "json",
        success: function(data){
          $.each(data,function(i,item){
            //alert(item.coursea.get(0));
            $('.studentinfo').append("<tr><td>id:"+item.id+"</td>"
                    +"<td>&nbsp;name:"+item.name+"</td>"
                    +"<td>&nbsp;classes:"+item.classes+"</td></tr>"

            );
          });
        }
      });
    }
    function getpassstudent(){
      $('.studentinfo').empty();
      $.ajax({
        url: "getpassstudent?cname="+$('#course_name').val(),
        type:"GET",
        dataType: "json",
        success: function(data){
          $.each(data,function(i,item){

            // alert(item.coursea);
            $('.studentinfo').append("<tr><td>id:"+item.id+"</td>name:"
                    +"<td>"+item.name+"</td>classes:"
                    +"<td>"+item.classes+"</td></tr>"
            );
          });
        }
      });
    }
    $(function(){
      $('.studentinfo').empty();
      $.ajax({
        url: "getAllStudent",
        type:"GET",
        dataType: "json",
        success: function(data){
          $.each(data,function(i,item){
            $('.studentinfo').append("<tr><td>"+item.id+"</td>"
                    +"<td>"+item.name+"</td>"
                    +"<td>"+item.classes+"</td></tr>"
            );
          });
        }
      });
    })
  </script>
</head>
<style>
  table td{
    width: 100px;
    border: 1px solid black;
  }
</style>
<body>
<div id="Content">
  <h2>Welcome</h2>

  <h2>insert student</h2>
  <form action="addstudent" >
    id：<input type="text" name="id"><br>
    name：<input type="text" name="name"><br>
    class：<input type="text" name="classes">
    <input type="submit" value="Add">
  </form>
  <br><br>
  <h2>insert course</h2>
  <form action="addcourse" >
    id of student：<input type="text" name="id"><br>
    course name：<input type="text" name="cname"><br>
    grade：<input type="text" name="grade">
    <input type="submit" value="Add">
  </form>
  <br><br>
  <h2>select student</h2>
  <p>please input the name of course :</p>
  <input id="course_name"/>
  <button onclick="getallstudent()" ondblclick="getallstudent()">All Student</button>
  <button onclick=getpassstudent()>Student of Pass course</button>
  <br>
  <table>
    <tr><th>student ID</th><th>name</th><th>class</th></tr>

    <p class="studentinfo"></p>
  </table>



</div>
</body>
</html>