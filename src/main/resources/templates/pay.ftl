<script src="/js/jquery-2.1.4.min.js"></script>
<script src="https://secure.wayforpay.com/server/pay-widget.js"></script>

<script src="/js/main.js"></script>

<link rel="stylesheet" type="text/css" href="/css/materialize/css/materialize.min.css">
<link rel="stylesheet" type="text/css" href="/css/main.css">

<div class="row">
    <form class="col s12 payment-form" data-product-code="${productCode}">
        <div class="row">
            <div class="input-field col s12">
                <input id="code" class="js-user-first-name pay-input" name="userFirstName" type="text">
                <label for="code">First Name</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="name" class="js-user-last-name pay-input" name="userLastName" type="text">
                <label for="name">Last Name</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="price" class="js-user-phone pay-input" name="userPhone" type="text">
                <label for="price">Phone</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input class="js-user-email validate pay-input" name="userEmail" type="text">
                <label for="price">Email</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12 center">
                <button class="js-open-payment btn waves-effect waves-light" name="action">Pay</button>
            </div>
        </div>
    </form>
</div>

