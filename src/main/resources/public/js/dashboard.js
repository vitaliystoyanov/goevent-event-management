$('#link-overview').on("click", function () {
    $("#dashboard-content").load("/overview");
});
$("#link-details").on("click", function () {
    $.ajax({
        url: "/details",
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
    $("#dashboard-content").load("/attendees");
});
$("#link-add-attendees").on("click", function () {
    $.ajax({
        url: "/addattendees",
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
        url: "/orders",
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
    $("#dashboard-content").load("/tickets");
});
$("#link-email-invitations").on("click", function () {
    $("#dashboard-content").load("/emailinvitations");
});