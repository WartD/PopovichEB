<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
<title>Сделки</title>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Deal</title>
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
                <h3>Список сделок:</h3>
                <table class="table">
                    <thead>
                    <th scope="col">Код</th>
                    <th scope="col">Номер договора</th>
                    <th scope="col">Тикер</th>
                    <th scope="col">Номер поручения</th>
                    <th scope="col">Номер сделки</th>
                    <th scope="col">Дата</th>
                    <th scope="col">Кол-во</th>
                    <th scope="col">Цена за шт.</th>
                    <th scope="col">Общая сумма</th>
                    <th scope="col">Код трейдера</th>
                    <th scope="col">Комиссия</th>
                    <th scope="col">Редактировать</th>
                    <th scope="col">Удалить</th>
                    </thead>
                    <tbody>
                    <c:forEach var="deal" items="${deals}">
                        <tr>
                            <td>${deal.getId()}</td>
                            <td>${deal.getAgreement()}</td>
                            <td>${deal.getTiker()}</td>
                            <td>${deal.getOrder()}</td>
                            <td>${deal.getNumber()}</td>
                            <td>${deal.getData()}</td>
                            <td>${deal.getQuantity()}</td>
                            <td>${deal.getPrice()}</td>
                            <td>${deal.getTotalCost()}</td>
                            <td>${deal.getTrader()}</td>
                            <td>${deal.getComission()}</td>
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
                    <h3>Новый план счета:</h3>
                    <br>
                    <div class="mb-3 row">
                        <label for="inputAgreement"
                               class="col-sm-3 col-form-label">Номер договора</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputAgreement" name="agreement" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputTiker"
                               class="col-sm-3 col-form-label">Тикер ценной бумаги</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputTiker" name="tiker" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputOrder"
                               class="col-sm-3 col-form-label">Номер поручения по сделке</label>
                        <div class="col-sm-7">
                            <input type="text"
                                   class="form-control" id="inputOrder"
                                   name="order" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputNumber"
                               class="col-sm-3 col-form-label">Номер сделки</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputNumber" name="number" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputDate"
                               class="col-sm-3 col-form-label">Дата заключения сделки</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputDate" name="date" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputQuantity"
                               class="col-sm-3 col-form-label">Кол-во ценных бумаг</label>
                        <div class="col-sm-7">
                            <input type="text"
                                   class="form-control" id="inputQuantity"
                                   name="quantity" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputPrice"
                               class="col-sm-3 col-form-label">Цена одной ценной бумаги</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputPrice" name="price" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputTotalCost"
                               class="col-sm-3 col-form-label">Общая сумма сделки</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputTotalCost" name="totalCost" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputTrader"
                               class="col-sm-3 col-form-label">Код трейдера</label>
                        <div class="col-sm-7">
                            <input type="text"
                                   class="form-control" id="inputTrader"
                                   name="trader" />
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <label for="inputCommission"
                               class="col-sm-3 col-form-label">Комиссия торговой площадки</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control"
                                   id="inputCommission" name="commission" />
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