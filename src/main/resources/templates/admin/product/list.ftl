<#include "../template/admin.ftl">
<#include "common.ftl">

<#macro page_body>
<table class="highlight">
    <thead>
    <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Name</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    </thead>

    <tbody>
        <#list products as product>
        <tr>
            <td>${product.productId}</td>
            <td>${product.code}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <a href="info/${product.productId}" class="waves-effect waves-light btn">View</a>
            </td>
        </tr>
        </#list>
    </tbody>
</table>
</#macro>

<@display_page/>