<#macro page_menu>
<#--default menu-->
</#macro>


<#macro page_body>
<#--default page body-->
</#macro>


<#macro display_page>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/libs/css/materialize/css/materialize.min.css">
    <link rel="stylesheet" type="text/css" href="/admin/css/admin/general.css">
</head>
<body>

<nav>
    <div class="nav-wrapper">
        <ul id="nav-mobile" class="left hide-on-med-and-down">
            <li><a href="/admin"><strong>Home</strong></a></li>
            <li><a href="/admin/product/list">Products</a></li>
            <li><a href="/admin/merchant/list">Merchants</a></li>
            <li><a href="/admin/order/list">Orders</a></li>
            <li><a href="/admin/user/list">Users</a></li>
        </ul>
        <ul id="nav-mobile" class="right hide-on-med-and-down">
            <@page_menu/>
            <li><a href="/logout">Logout</a></li>
        </ul>
    </div>
</nav>
<div class="content-wrapper">
    <@page_body/>
</div>
</body>
</html>
</#macro>