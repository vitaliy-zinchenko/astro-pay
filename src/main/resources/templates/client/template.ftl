<#macro page_body>
<#--default page body-->
</#macro>


<#macro display_page>
<html>
<head>
    <script src="/libs/js/jquery-2.1.4.min.js"></script>
    <script src="/libs/js/jquery.validate.min.js"></script>
    <script src="https://secure.wayforpay.com/server/pay-widget.js"></script>
    <script src="/libs/css/materialize/js/materialize.min.js"></script>

    <#--<script src="http://jqueryvalidation.org/files/dist/jquery.validate.min.js"></script>-->
    <#--<script src="http://jqueryvalidation.org/files/dist/additional-methods.min.js"></script>-->

    <script src="/public/js/pay.js"></script>

    <link rel="stylesheet" type="text/css" href="/libs/css/materialize/css/materialize.min.css">
    <link rel="stylesheet" type="text/css" href="/public/css/pay.css">
</head>
<body>


<div class="content-wrapper">
    <@page_body/>
</div>



</body>
</html>
</#macro>