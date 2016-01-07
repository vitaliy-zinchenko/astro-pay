Order was payed.

Order Id: ${order.orderId}
<#list order.products as product>
Product Name: ${product.name}
</#list>

User info:
First Name: ${order.user.firstName}
Last Name: ${order.user.lastName}
Email: ${order.user.email}
Phone: ${order.user.phone}