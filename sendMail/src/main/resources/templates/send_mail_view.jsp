<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js" integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn" crossorigin="anonymous"></script>
    <script src="https://use.fontawesome.com/5b5fa05dbf.js"></script>
</head>
<body>
<div class="container">
    <div class="card">
        <div class="jumbotron">
            <h1 style="text-align: center;">Enviar e-mail</h1>
        </div>
        <form method="POST" th:action="@{/sendMail}" id="emailForm" class="container">
            <div class="form-group">
                <label>Nombre</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <div class="input-group-addon"><i class="fa fa-fw fa-user" aria-hidden="true"></i></div>
                    <input type="text" class="form-control" name="name" placeholder="Nombre"/>
                </div>
            </div>
            <div class="form-group">
                <label>Correo</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <div class="input-group-addon">@</div>
                    <input type="text" class="form-control" name="mail" placeholder="Correo electónico"/>
                </div>
            </div>
            <div class="form-group">
                <label>Assunto</label>
                <div class="input-group mb-2 mr-sm-2 mb-sm-0">
                    <div class="input-group-addon"><i class="fa fa-fw fa-envelope-open" aria-hidden="true"></i></div>
                    <input type="text" class="form-control" name="subject" placeholder="Assunto"/>
                </div>
            </div>
            <div class="form-group">
                <label>Mensaje</label>
                <textarea class="form-control" rows="5" name="body"></textarea>
            </div>
            <div style="margin-bottom: 10px">
                <button type="submit" class="btn btn-success">Enviar</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>