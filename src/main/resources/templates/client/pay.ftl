<#include "template.ftl">

<#macro page_body>
<div class="user-detail-wrapper">
    <h5 class="products-title center">User info</h5>
    <p class="center">Please fill your name and contact data.</p>
    <form class="col s12 payment-form" data-product-id="${productId}">
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
</#macro>

<@display_page/>

