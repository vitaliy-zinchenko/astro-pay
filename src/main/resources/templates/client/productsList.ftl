<#include "template.ftl">

<#macro page_body>
<div class="products-content">
    <h5 class="products-title center">Products</h5>
    <table class="bordered highlight">
        <tbody class="products-list">
            <#list products as product>
            <tr>
                <td class="description">
                ${product.name}
                    <br/>
                ${product.description}
                </td>
                <td class="price">${product.price}</td>
                <td class="controls">
                    <a class="right btn" href="/pay/${product.productId}">Choose</a>
                </td>
            </tr>
            </#list>
        </tbody>
    </table>
</div>
</#macro>

<@display_page/>
