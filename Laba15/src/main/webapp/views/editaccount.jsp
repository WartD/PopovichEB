<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>План счетов</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>AccountPlan</title>
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
                <h3>Список планов:</h3>
                <table class="table">
                    <thead>
                    <th scope="col">Код</th>
                    <th scope="col">Наименование счета</th>
                    <th scope="col">Тип счета</th>
                    <th scope="col">Номер операции</th>
                    </thead>
                    <tbody>
                    <c:forEach var="accounts" items="${accounts}">
                        <tr>
                            <td>${accounts.getId()}</td>
                            <td>${accounts.getName()}</td>
                            <td>${accounts.getType()}</td>
                            <td>${accounts.getNumber()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-4 border px-4 a-color">
                <form method="POST" action="">
                    <h3>Редактировать план счета:</h3>
                    <br>
                    <div class="mb-3 row">
                        <label for="idaccount"
                               class="col-sm-3 col-form-label">Код плана счетов</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" readonly id="idaccount" value="${accountEdit.getId()}"/>
                        </div>
                        <label for="inputName"
                               class="col-sm-3 col-form-label">Наименование счета</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputName" name="name" value='${accountEdit.getName()}'/>
                        </div>
                        <label for="inputType"
                               class="col-sm-3 col-form-label">Тип счета</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputType" name="type" value='${accountEdit.getType()}'/>
                        </div>

                        <label for="inputNumber"
                               class="col-sm-3 col-form-label">Номер операции</label>
                        <div class="col-sm-7">
                            <input type="text"
                                   class="form-control" id="inputNumber"
                                   name="number" value='${accountEdit.getNumber()}'/>
                        </div>
                    </div>
                    <p> <br>
                        <button type="submit"
                                class="btn btn-primary">Редактировать</button>
                        <a href='<c:url value="/accountPlan" />' role="button" class="btn btn-secondary">Отменить</a>
                    </p>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>