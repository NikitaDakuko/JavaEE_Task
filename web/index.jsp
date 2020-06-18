<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 17.06.2020
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <H1>Number to square</H1>

    <form action = result method="post">
      <input type="number" name="nom">
      <input type="submit">
    </form>
    <hr>
    <h1>File Upload</h1>
    <form method="POST" action=UploadServlet enctype="multipart/form-data" >
      File:
      <input type="file" name="file" id="file" /> <br/>
      Destination:
      <input type="text" value="/tmp" name="destination"/>
      </br>
      <input type="submit" value="Upload" name="upload" id="upload" />
    </form>

  </body>
</html>
