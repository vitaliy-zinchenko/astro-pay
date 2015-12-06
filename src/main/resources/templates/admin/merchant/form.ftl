<#include "../template/admin.ftl">
<#include "common.ftl">

<#macro page_body>
<div class="row">
    <form class="col s12" action="/admin/merchant/save" method="POST">
        <div class="row">
            <div class="input-field col s12">
                <input id="account" name="account" type="text" class="validate">
                <label for="account">Account</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="domainName" name="domainName" type="text" class="validate">
                <label for="domainName">Domain Name</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="authorizationType" name="authorizationType" type="text" class="validate">
                <label for="authorizationType">Authorization Type</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="currency" name="currency" type="text" class="validate">
                <label for="currency">Currency</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="privateKey" name="privateKey" type="text" class="validate">
                <label for="privateKey">Private Key</label>
            </div>
        </div>
        <button class="btn waves-effect waves-light" type="submit" name="action">Save</button>
    </form>
</div>
</#macro>

<@display_page/>