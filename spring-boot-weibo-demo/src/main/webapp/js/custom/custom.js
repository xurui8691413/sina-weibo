/**
 * Make js modularization
 * @type {{paging_fun}}
 */
var Custom_JS = (function(){
    return {

        /**
         * do pagination for result list
         */
        paging_fun : function() {
            $('.demo2').bootpag({
                total: $('#pageSize').val(),
                page: 1,
                maxVisible: 10
            }).on('page', function(event, num){
                $.ajax({
                    url: $('#contextPath').val() + "/weibo/" + num,
                    type: "POST",
                    success: function (data) {
                        $(".content2").html(data + num);
                    },
                    error: function (data, status, err) {
                        alert('Error', data.responseText);
                    }
                });
            });
        }
    };
})();
$(function() {
    Custom_JS.paging_fun();
});