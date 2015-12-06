<#include "../template/admin.ftl">
<#include "common.ftl">

<#macro page_body>
<table class="highlight">
    <thead>
    <tr>
        <th>ID</th>
        <th>Account</th>
        <th>Domain Name</th>
        <th>Authorization Type</th>
        <th>Currency</th>
        <th>Private Key</th>
        <th>Actions</th>
    </tr>
    </thead>

    <tbody>
    <#list merchants as merchant>
    <tr>
        <td>${merchant.merchantId}</td>
        <td>${merchant.account}</td>
        <td>${merchant.domainName}</td>
        <td>${merchant.authorizationType}</td>
        <td>${merchant.currency}</td>
        <td>${merchant.privateKey}</td>
        <td>
            <a href="info/${merchant.merchantId}" class="waves-effect waves-light btn">View</a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</#macro>

<@display_page/>