<script src="/libs/js/jquery-2.1.4.min.js"></script>
<script src="https://secure.wayforpay.com/server/pay-widget.js"></script>
<script src="/libs/css/materialize/js/materialize.min.js"></script>

<script src="/public/js/main.js"></script>

<link rel="stylesheet" type="text/css" href="/libs/css/materialize/css/materialize.min.css">
<link rel="stylesheet" type="text/css" href="/public/css/main.css">

<div class="row">
    <form class="col s12 payment-form">
        <div class="row">
            <div class="input-field col s12">
                <select>
                    <option value="" disabled selected>Choose your option</option>
                    <option value="1">Option 1</option>
                    <option value="2">Option 2</option>
                    <option value="3">Option 3</option>
                </select>
                <label>Product</label>
            </div>
        </div>
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

