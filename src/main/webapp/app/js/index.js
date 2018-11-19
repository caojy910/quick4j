$(function() {
    App.init();

    var Index = (function() {
        var me = {};

        // 处理一级菜单点击
        me.activeMenuClick = function() {
            $('#page-sidebar-menu > li').click(function(e) {
                var menu = $('#page-sidebar-menu');
                var li = menu.find('li.active').removeClass('active');

                $('#index-page-title').text($(this).find(".title").html());
                // 添加选中 打开的样式
                $(this).addClass('active');
            });
        };

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

        me.handlePageContentClick = function() {
            // $('.page-content li a').click(function(e) {
            //     e.preventDefault();
            //     var url = this.href;
            //     if (url != null && url != 'javascript:;') {
            //         $.get(url, function(data) {
            //             $('#main-content').html(data);
            //         });
            //     }
            // });
        };

        me.init = function() {
            me.activeMenuClick();
            me.handleMenuClick();
            me.handleSubMenuClick();
            // me.handlePageContentClick()
        };

        return me;
    })();

    Index.init();

    $('#btn-dashboard').trigger("click");
});

