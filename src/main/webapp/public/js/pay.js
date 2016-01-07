$(document).ready(function() {
    $('select').material_select();
});

$(function () {

    var payment = new app.Payment($('.payment-form'));


});

console.log("initializing...");
app = {
    consts : {
        ORDER_GENERATE_URL : '/api/order/generate'
    }
};

app.Payment = function ($elPaymentForm) {
    var self = this;

    this.wayforpay = new Wayforpay();
    this.$elPaymentForm = $elPaymentForm;
    this.productId = this.$elPaymentForm.data('product-id');
    this.$elPaymentForm.validate({
        submitHandler: function(form) {
            self.pay();
        }
    });
};

app.Payment.prototype = {
    pay: function () {
        this.generateOrderResponse(this.callWayForPay);
    },
    callWayForPay: function(orderResponse) {
        this.wayforpay.run({
                merchantAccount: orderResponse.merchantAccount,
                merchantDomainName: orderResponse.merchantDomainName,
                authorizationType: orderResponse.authorizationType,
                merchantSignature: orderResponse.merchantSignature,
                orderReference: orderResponse.order.id,
                orderDate: orderResponse.order.orderDate,
                amount: orderResponse.order.amount,
                currency: orderResponse.currency,
                productName: orderResponse.productName,
                productPrice: orderResponse.productPrice,
                productCount: orderResponse.productCount,
                clientFirstName: this.$elPaymentForm.find('.js-user-first-name').val(),
                clientLastName: this.$elPaymentForm.find('.js-user-last-name').val(),
                clientEmail: this.$elPaymentForm.find('.js-user-email').val(),
                clientPhone: this.$elPaymentForm.find('.js-user-phone').val()
            },
            function (response) {
                window.location = '/apy/successful/' + orderResponse.order.id;
            },
            function (response) {
                console.log("fail");
            },
            function (response) {
                console.log("in progress");
            }
        );
    },
    generateOrderResponse: function (orderResponseHandler) {
        var self = this;
        $.ajax({
            url:app.consts.ORDER_GENERATE_URL + '/' + this.productId,
            method: 'POST',
            data: {
                firstName: this.$elPaymentForm.find('.js-user-first-name').val(),
                lastName: this.$elPaymentForm.find('.js-user-last-name').val(),
                email: this.$elPaymentForm.find('.js-user-email').val(),
                phone: this.$elPaymentForm.find('.js-user-phone').val()
            },
            success: function(data) {
                orderResponseHandler.call(self, data);
            },
            error: function() {
                //TODO notify administrator
                console.log('fail during loading order data');
            }
        });
    }

};

console.log("initialized.");