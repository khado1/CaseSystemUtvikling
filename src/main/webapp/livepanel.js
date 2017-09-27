$(document).ready(function () {
    $.get("rest/restaurant/live", function (text) {
        $("#myTable").append(text);
    })
});