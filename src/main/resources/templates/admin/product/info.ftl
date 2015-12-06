<#include "../template/admin.ftl">
<#include "common.ftl">

<#macro page_body>
<h4>Product Info</h4>
<div class="section">
    <h5>ID</h5>
    <p>${product.productId}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Code</h5>
    <p>${product.code}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Name</h5>
    <p>${product.name}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Price</h5>
    <p>${product.price}</p>
</div>
</#macro>

<@display_page/>
