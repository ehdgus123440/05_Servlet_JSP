<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Todo List</title>
  <link rel="stylesheet" href="/resources/css/main.css">
</head>
<body>
  <h1>Todo List</h1>
  <h3>전체 Todo 개수 : ${fn:length(todoList)} / 
      완료된 Todo 개수 : ${completeCount}</h3>
  <hr>

    <h4>할 일 추가</h4>
    <form action="/todo/add" method="post" id="addForm">
      <div>
        제목 : <input type="text" name = "title">
      </div>
      <div>
        <textarea name="detail" cols="50" rows="3" placeholder="상세 내용"></textarea>
      </div>

      <button>추가</button>
    </form>

  <hr>
  <%-- 할 일 목록 출력 --%>
  <table id ="todoList" border="1">
    <thead>
      <tr>
        <th>번호</th>
        <th>할 일 제목</th>
        <th>완료 여부</th>
        <th>등록 날짜</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${todoList}" var="todo" varStatus="vs">
        <tr>
          <th>${vs.count}</th>
          <td>
            <a href="#">${todo.title}</a>
          </td>
          <th>
            <c:if test="${todo.complete}" > O
            </c:if>
            <c:if test="${not todo.complete}" > X
            </c:if>
          </th>
          <td>${todo.regDate}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>

  <c:if test="${not empty sessionScope.message}" >
    <script>
      alert( "${message}" ); // JSP 에서는 Java(EL/JSTL) 먼저 해석되고 그 다음에 front 해석 
    </script>

    <c:remove var="message" scope="session" />

  </c:if>
  <script src="\resources\js\main.js"></script>
</body>
</html>