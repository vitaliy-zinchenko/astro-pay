<#include "../template/admin.ftl">

<#macro page_body>
<h4>User Info</h4>
<div class="section">
    <h5>ID</h5>
    <p>${user.userId}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Code</h5>
    <p>${user.firstName}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Name</h5>
    <p>${user.lastName}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Price</h5>
    <p>${user.email}</p>
</div>
<div class="divider"></div>
<div class="section">
    <h5>Phone</h5>
    <p>${user.phone}</p>
</div>
</#macro>

<@display_page/>
