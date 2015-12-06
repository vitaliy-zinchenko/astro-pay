<#include "../template/admin.ftl">
<#include "common.ftl">

<#macro page_body>
<div class="row">
    <form class="col s12" action="/admin/product/save" method="POST">
        <div class="row">
            <div class="input-field col s12">
                <input id="code" name="code" type="text" class="validate">
                <label for="code">Code</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="name" name="name" type="text" class="validate">
                <label for="name">Name</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s12">
                <input id="price" name="price" type="text" class="validate">
                <label for="price">Price</label>
            </div>
        </div>
        <button class="btn waves-effect waves-light" type="submit" name="action">Save</button>
    </form>
</div>
</#macro>

<@display_page/>