<#include "../template/admin.ftl">

<#macro page_body>
<table class="highlight">
    <thead>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
    </tr>
    </thead>

    <tbody>
        <#list users as user>
        <tr>
            <td>${user.userId}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
        </tr>
        </#list>
    </tbody>
</table>
</#macro>

<@display_page/>