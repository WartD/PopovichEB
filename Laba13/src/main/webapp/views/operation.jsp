<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Операции</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Operations</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <!-- jQuery -->
    <script defer src="js/jquery-3.6.4.js"></script>
    <!-- Bootstrap JS + Popper JS -->
    <script defer src="js/bootstrap.min.js"></script>
</head>

<body>
<div class="container-fluid back-container">
    <jsp:include page="/views/header.jsp" />
    <div class="container-fluid back-container">
        <div class="row justify-content-start ">
            <div class="col-8 border bg-light px-4">
                <h3>Список операций:</h3>
                <br>
                <table class="table">
                    <thead>
                    <th scope="col">Код</th>
                    <th scope="col">Сделка</th>
                    <th scope="col">Субсчет</th>
                    <th scope="col">Номер</th>
                    <th scope="col">Дата сделки</th>
                    <th scope="col">Тип операции</th>
                    <th scope="col">Приход/расход</th>
                    <th scope="col">Сальдо начальное</th>
                    <th scope="col">Сальдо конечное</th>
                    <th scope="col">Редактировать</th>
                    <th scope="col">Удалить</th>
                    </thead>
                    <tbody>
                    <c:forEach var="op" items="${operations}">
                        <tr>
                            <td>${op.getId()}</td>
                            <td>${op.getDeal().getAgreement()}</td>
                            <td>${op.getSubAccount().getName()}</td>
                            <td>${op.getNumber()}</td>
                            <td>${op.getData()}</td>
                            <td>${op.getType()}</td>
                            <td>${op.getSum()}</td>
                            <td>${op.getSaldoInput()}</td>
                            <td>${op.getSaldoOutput()}</td>

                            <td width="20"><a href="#" role="button"
                                              class="btn btn-outline-primary">
                                <img alt="Редактировать"
                                     src="img/edit.png"></a></td>
                            <td width="20"><a href="#" role="button"
                                              class="btn btn-outline-primary">
                                <img alt="Удалить"
                                     src="img/delete.png"></a></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-4 border px-4">
                <form method="POST" action="">
                    <h3 class="a-color">Новая операция</h3>
                    <div class="mb-3 row">
                        <label for="deal"
                               class="col-sm-3 col-form-label a-color">Сделка</label>
                        <div class="col-sm-7">
                            <select name="deal" class="form-control">
                                <option>Выберите сделку</option>
                                <c:forEach var="dl" items="${deals}">
                                    <option value="${dl}">
                                        <c:out value="${dl.getAgreement()}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="subAccount"
                               class="col-sm-3 col-form-label a-color">Субсчет</label>
                        <div class="col-sm-7">
                            <select name="subAccount" class="form-control">
                                <option>Выберите субсчет</option>
                                <c:forEach var="sub" items="${subAccounts}">
                                    <option value="${sub}">
                                        <c:out value="${sub.getName()}"/>
                                    </option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="inputNumber"
                               class="col-sm-3 col-form-label a-color">Номер операции</label>
                        <div class="col-sm-6">
                            <input type="text" name="number"
                                   class="form-control" id="inputNumber" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="inputDate"
                               class="col-sm-3 col-form-label a-color">Дата проведения операции</label>
                        <div class="col-sm-6">
                            <input type="text" name="date"
                                   class="form-control" id="inputDate" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="inputType"
                               class="col-sm-3 col-form-label a-color">Тип операции(покупка, продажа)</label>
                        <div class="col-sm-6">
                            <input type="text" name="type"
                                   class="form-control" id="inputType" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="inputSum"
                               class="col-sm-3 col-form-label a-color">Приход/расход по операции</label>
                        <div class="col-sm-6">
                            <input type="text" name="sum"
                                   class="form-control" id="inputSum" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="inputSaldo"
                               class="col-sm-3 col-form-label a-color">Сальдо начальное</label>
                        <div class="col-sm-6">
                            <input type="text" name="saldoInput"
                                   class="form-control" id="inputSaldo" />
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="outputSaldo"
                               class="col-sm-3 col-form-label a-color">Сальдо конечное</label>
                        <div class="col-sm-6">
                            <input type="text" name="saldoOutput"
                                   class="form-control" id="outputSaldo" />
                        </div>
                    </div>
                    <p>
                        <br> <br> <br>
                        <button type="submit"
                                class="btn btn-primary">Добавить</button>
                        <br>
                    </p>
                </form>
            </div>
        </div>
    </div>
    <jsp:include page="/views/footer.jsp" />
</div>
</body>
</html>