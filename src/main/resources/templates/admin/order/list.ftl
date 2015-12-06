<#include "../template/admin.ftl">

<#macro page_body>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Date</th>
        <th>User email</th>
        <th>User name</th>
        <th>Products</th>
        <th>Merchant</th>
    </tr>
    </thead>

    <tbody>
    <#list orders as order>
    <tr>
        <td>${order.orderId}</td>
        <td>${order.orderDate}</td>
        <td>${order.user.email}</td>
        <td>
            <a href="/admin/user/info/${order.user.userId}">${order.user.firstName} ${order.user.lastName}</a>
        </td>
        <td>
            <#list order.products as product>
                <a href="/admin/product/info/${product.productId}">${product.name}</a>
            </#list>
        </td>
        <td>
            <a href="/admin/merchant/info/${order.merchant.merchantId}">${order.merchant.account}</a>
        </td>
    </tr>
    </#list>
    </tbody>
</table>
</#macro>

<@display_page/>