<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>СубСчета</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SubAccount</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <!-- jQuery -->
    <script defer src="js/jquery.min.js"></script>
    <!-- Bootstrap JS + Popper JS -->
    <script defer src="js/bootstrap.min.js"></script>
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.mi
n.js"></script>
</head>
<body>
<div class="container-fluid back-container">
    <jsp:include page="/views/header.jsp" />
    <div class="container-fluid back-container">
        <div class="row justify-content-start ">
            <div class="col-8 border bg-light px-4">
                <h3>Список субсчетов:</h3>
                <table class="table">
                    <thead>
                    <th scope="col">Код</th>
                    <th scope="col">План счетов</th>
                    <th scope="col">Наименование</th>
                    <th scope="col">Номер</th>
                    <th scope="col">Редактировать</th>
                    <th scope="col">Удалить</th>
                    </thead>
                    <tbody>
                    <c:forEach var="sub" items="${subAccount}">
                        <tr>
                            <td>${sub.getId()}</td>
                            <td>${sub.getAccount().getName()}</td>
                            <td>${sub.getName()}</td>
                            <td>${sub.getNumber()}</td>
                            <td width="20"><a href="#" role="button"
                                              class="btn btn-outline-primary">
                                <img alt="Редактировать"
                                     src="img/edit.png"></a>
                            </td>
                            <td width="20"><a href="#" role="button"
                                              class="btn btn-outline-primary">
                                <img alt="Удалить"
                                     src="img/delete.png"></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-4 border px-4">
                <form method="POST" action="">
                    <h3>Новый субсчет:</h3>
                    <br>
                    <div class="mb-3 row">
                        <label for="inputAccount"
                               class="col-sm-3 col-form-label">План счетов</label>
                        <div class="col-sm-7">
                            <select name="faculty" class="form-control">
                                <option>Выберите план счета: </option>
                                <c:forEach var="acc" items="${accounts}">
                                    <option value="${acc}">
                                        <c:out value="${acc.getName()}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputName"
                               class="col-sm-3 col-form-label">Наименование субсчета</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputName" name="name" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputNumber"
                               class="col-sm-3 col-form-label">Номер субсчета</label>
                        <div class="col-sm-7">
                            <input type="text"
                                   class="form-control" id="inputNumber"
                                   name="number" />
                        </div>
                    </div>
                    <p> <br>
                        <button type="submit"
                                class="btn btn-primary">Добавить</button>
                    </p>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>