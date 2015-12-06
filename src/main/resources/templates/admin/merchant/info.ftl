<#include "../template/admin.ftl">
<#include "common.ftl">

<#macro page_body>
<h4>Merchant Info</h4>
<div class="section">
    <h5>ID</h5>
    <p>${merchant.merchantId}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Code</h5>
    <p>${merchant.account}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Name</h5>
    <p>${merchant.domainName}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Authorization Type</h5>
    <p>${merchant.authorizationType}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Currency</h5>
    <p>${merchant.currency}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Private Key</h5>
    <p>${merchant.privateKey}</p>
</div>
</#macro>

<@display_page/>