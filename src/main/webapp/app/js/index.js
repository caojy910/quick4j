$(function() {
    App.init();

    var Index = (function() {
        var me = {};

        // 处理一级菜单点击
        me.handleMenuClick = function() {
            $('#page-sidebar-menu li a').click(function(e) {
                e.preventDefault();
                var url = this.href;
                if (url != null && url != 'javascript:;') {
                    $.get(url, function(data) {
                        $('#main-content').html(data);
                    });
                }

            });
        };

        // 处理子菜单点击
        me.handleSubMenuClick = function() {
            $('#sub-menu li a').click(function(e) {
                e.preventDefault();
                var url = this.href;
                if (url != null && url != 'javascript:;') {
                    $.get(url, function(data) {
                        $('#main-content').html(data);
                    });
                }

            });
        };

        me.init = function() {
            me.handleMenuClick();
            me.handleSubMenuClick();
        };

        return me;
    })();

    Index.init();

    $('#btn-dashboard').trigger("click");
});