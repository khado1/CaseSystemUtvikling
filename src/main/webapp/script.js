function getData() {
    var pers = parseInt($("#persons").val());
    var dateTime = $("#dateTime").val();
    var courses = ($("#ddlAppetizers").val() == "0" ? 0 : 1) + ($("#ddlMains").val() == "0" ? 0 : 1) + ($("#ddlDesserts").val() == "0" ? 0 : 1);

    var firstName = $("#forNavn").val();
    var lastName = $("#etterNavn").val();
    var cardNr = parseInt($("#cNumber").val());
    var edMonth = parseInt($("#edMnd").val());
    var edYear = parseInt($("#edAar").val());
    var cvc = parseInt($("#cvc").val());

    var b = {
        forNavn: firstName,
        etterNavn: lastName,
        kortNummer: cardNr,
        edMnd: edMonth,
        edAar: edYear,
        cvc: cvc
    };

    var order = {
        forRetter: parseInt($("#ddlAppetizers").val()) - 1,
        hovedRetter: parseInt($("#ddlMains").val()) - 1,
        desserts: parseInt($("#ddlDesserts").val()) - 1,
        mineralVann: parseInt($("#ddlDrinks").val()) - 1,
        c: pers
    }

    var a = JSON.stringify({
        bookingId: 0,
        persons: pers,
        bookingStart: dateTime,
        order: order,
        paymentCard: b
    });
    return a;
}

$(document).ready(function() {
    var appetizer;
    var main;
    var dessert;
    var drink;
    $.get("rest/restaurant/menu", function (menu) {
        var htmlAppetizer = "<option value='0'>Forretter</option>";
        var htmlMains = "<option value='0'>Hovedretter</option>";
        var htmlDesserts = "<option value='0'>Desserer</option>";
        var htmlDrinks = "<option value='0'>Drinkker</option>";
        appetizer = menu.forRetter;
        main = menu.hovedRetter;
        dessert = menu.desserts;
        drink = menu.mineralVann;
        for(var i = 0; i < menu.forRetter.length; i++) htmlAppetizer+="<option value='" + (i + 1) + "'>" + menu.forRetter[i] + "</option>";
        for(var i = 0; i < menu.hovedRetter.length; i++) htmlMains+="<option value='" + (i + 1) + "'>" + menu.hovedRetter[i] + "</option>";
        for(var i = 0; i < menu.desserts.length; i++) htmlDesserts+="<option value='" + (i + 1) + "'>" + menu.desserts[i] + "</option>";
        for(var i = 0; i < menu.mineralVann.length; i++) htmlDrinks+="<option value='" + (i + 1) + "'>" + menu.mineralVann[i] + "</option>";
        $("#ddlAppetizers").html(htmlAppetizer);
        $("#ddlMains").html(htmlMains);
        $("#ddlDesserts").html(htmlDesserts);
        $("#ddlDrinks").html(htmlDrinks);
    })

    $("#order").click(function () {
        $.ajax({
            url: 'rest/restaurant/booking',
            type: 'POST',
            data: getData(),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            success: function (id) {
                if(id == null) alert("Booking not possible");
                else{
                    var t = "Your order: \n";
                    for(var i = 0; i < appetizer.length; i++){
                        if(id.order.forRetter[i] != 0){
                            t += id.order.forRetter[i] + " x " + appetizer[i] + "\n";
                        }
                    }
                    for(var i = 0; i < main.length; i++){
                        if(id.order.hovedRetter[i] != 0){
                            t += id.order.hovedRetter[i] + " x " + main[i] + "\n";
                        }
                    }
                    for(var i = 0; i < dessert.length; i++){
                        if(id.order.desserts[i] != 0){
                            t += id.order.desserts[i] + " x " + dessert[i] + "\n";
                        }
                    }
                    for(var i = 0; i < drink.length; i++){
                        if(id.order.mineralVann[i] != 0){
                            t += id.order.mineralVann[i] + " x " + drink[i] + "\n";
                        }
                    }
                    alert(t);
                }
            }
        });
    });
});