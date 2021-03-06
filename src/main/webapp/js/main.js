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
    this.$el = $elPaymentForm;
    this.productCode = this.$el.data('product-code');
    this.$el.find('.js-open-payment').on('click', function (event) {
        event.preventDefault();
        event.stopPropagation();
        self.pay();
    })
};

app.Payment.prototype = {
    pay: function () {
        var orderResponse = this.loadOrderResponse();
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
                clientFirstName: this.$el.find('.js-user-first-name').val(),
                clientLastName: this.$el.find('.js-user-last-name').val(),
                clientEmail: this.$el.find('.js-user-email').val(),
                clientPhone: this.$el.find('.js-user-phone').val()
            },
            function (response) {
                console.log("ok");
            },
            function (response) {
                console.log("fail");
            },
            function (response) {
                console.log("in progress");
            }
        );
    }
    , loadOrderResponse: function () {
        var result;
        $.ajax({
            url:app.consts.ORDER_GENERATE_URL + '/' + this.productCode,
            async: false,
            method: 'POST',
            data: {
                firstName: this.$el.find('.js-user-first-name').val(),
                lastName: this.$el.find('.js-user-last-name').val(),
                email: this.$el.find('.js-user-email').val(),
                phone: this.$el.find('.js-user-phone').val()
            },
            success: function(data) {
                result = data;
            },
            fail: function() {
                //TODO notify administrator
                console.log('fail during loading order data');
            }
        });
        return result;
    }

};

console.log("initialized.");