<link rel="stylesheet" type="text/css" href="/libs/css/materialize/css/materialize.min.css">
<link rel="stylesheet" type="text/css" href="/public/css/loginAdmin.css">

<div class="login-form-wrapper row">
    <form class="col s12" action="/loginAdmin" method="post">
        <div class="row">
            <div class="input-field col s12">
                <input id="username" type="text" name="username"/>
                <label for="username">Username</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="password" type="password" name="password" class="validate">
                <label for="password">Password</label>
            </div>
        </div>
        <div class="row center">
            <div class="input-field col s12">
                <button class="btn waves-effect waves-light" type="submit">Sign In</button>
            </div>
        </div>
    </form>
</div>


<script src="/libs/js/jquery-2.1.4.min.js"></script>
<script src="/libs/css/materialize/js/materialize.min.js"></script>
