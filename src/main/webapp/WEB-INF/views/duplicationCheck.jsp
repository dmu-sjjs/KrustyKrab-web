<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="kr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<%
    Boolean isDuplicate = true;
    String id = "";
    if (request.getAttribute("isDuplicate") != null && (boolean) request.getAttribute("isDuplicate") == false) {
        isDuplicate = false;
        id = (String)request.getAttribute("id");
    }

%>

<h1>중복체크</h1>

<%
    if (isDuplicate) {
%>
<form action="idDuplicationCheck" method="post" >
    <input id="duplicationCheckTextBox" type="text" name="id" ><br>
    <input type="submit" value="확인">
    <button onclick="window.close()" >취소</button>
</form><nobr>

<%
    } else {
%>
    <script>
        alert('중복이 아닙니다.');
        if(confirm('사용하시겠습니까?')){
            const parent = opener.document.querySelector('#joinId');
            parent.value = <%=id%>;
            parent.setAttribute('readonly', 'readonly');
            parent.setAttribute('style','background-color:lightgray;');
            window.close();
        }else{
            window.close();
        }
    </script>
<%
    }
%>

<script>
    const idText = document.querySelector("#duplicationCheckTextBox");
    const urlParams = new URL(location.href).searchParams;
    const name = urlParams.get('checkId');
    idText.value = name;
    console.log(openJoinForm);

</script>
</body>
</html>