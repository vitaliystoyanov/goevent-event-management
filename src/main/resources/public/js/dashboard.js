$('#link-overview').on("click", function () {
    $("#dashboard-content").load("/fragments/overview");
});
$("#link-details").on("click", function () {
    $.ajax({
        url: "/fragments/details",
        type: "GET",
        success: function(response){
            $('#dashboard-content').html(response);
            componentHandler.upgradeAllRegistered();
        },
        error: function(){
            alert("Error");
        }
    });
});
$("#link-attendees").on("click", function () {
    $("#dashboard-content").load("/fragments/attendees");
});
$("#link-add-attendees").on("click", function () {
    $.ajax({
        url: "/fragments/addattendees",
        type: "GET",
        success: function(response){
            $('#dashboard-content').html(response);
            componentHandler.upgradeAllRegistered();
        },
        error: function(){
            alert("Error");
        }
    });
});
$("#link-orders").on("click", function () {
    $.ajax({
        url: "/fragments/orders",
        type: "GET",
        success: function(response){
            $('#dashboard-content').html(response);
            componentHandler.upgradeAllRegistered();
        },
        error: function(){
            alert("Error");
        }
    });
});
$("#link-tickets").on("click", function () {
    $("#dashboard-content").load("/fragments/tickets");
});
$("#link-email-invitations").on("click", function () {
    $("#dashboard-content").load("/fragments/emailinvitations");
});