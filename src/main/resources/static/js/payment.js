$(document).ready(function () {

    // shippingAddress.billingAddress.billFullName
    // shippingAddress.billingAddress.billEmail
    // shippingAddress.billingAddress.billStreet
    // shippingAddress.billingAddress.billCity
    // shippingAddress.billingAddress.billState
    // shippingAddress.billingAddress.billZip

    $('input[id^="sameadr"]').click(function () {
        if ($(this).prop('checked')) {
            var billFullName = $("#shippingAddress\\.billingAddress\\.billFullName").val();
            var billEmail = $("#shippingAddress\\.billingAddress\\.billEmail").val();
            var billStreet = $("#shippingAddress\\.billingAddress\\.billStreet").val();
            var billCity = $("#shippingAddress\\.billingAddress\\.billCity").val();
            var billState = $("#shippingAddress\\.billingAddress\\.billState").val();
            var billZip = $("#shippingAddress\\.billingAddress\\.billZip").val();
            //alert(billFullName + "|" + billEmail + "|" + billStreet + "|" + billCity + "|" + billState + "|" + billZip);

            $("#shippingAddress\\.fullName").val(billFullName);
            $("#shippingAddress\\.email").val(billEmail);
            $("#shippingAddress\\.street").val(billStreet);
            $("#shippingAddress\\.city").val(billCity);
            $("#shippingAddress\\.state").val(billState);
            $("#shippingAddress\\.zip").val(billZip);
        } else {
            $("#shippingAddress\\.fullName").val('');
            $("#shippingAddress\\.email").val('');
            $("#shippingAddress\\.street").val('');
            $("#shippingAddress\\.city").val('');
            $("#shippingAddress\\.state").val('');
            $("#shippingAddress\\.zip").val('');
        }
    });

});
