(function($) {
    $.fn.ySelect = function(options) {
      var defaultOptions={
          placeholder: '请选择',
          numDisplayed: 4,
          overflowText: '{n} selected',
          searchText: '搜索',
          showSearch: true
      }
        if (typeof options == 'string' ) {
          var  settings = options;
        }
        else {

          var  settings = $.extend(true,{},defaultOptions, options);
        }


        /**
         * Constructor
         */
        function ySelect(select, settings) {
            this.$select = $(select);
            this.settings = settings;
            this.create();
        }


        /**
         * Prototype class
         */
        ySelect.prototype = {
            create: function() {
                var multiple = this.$select.is('[multiple]') ? ' multiple' : '';
                this.$select.wrap('<div class="fs-wrap' + multiple + '"></div>');
                this.$select.before('<div class="fs-label-wrap"><div class="fs-label">' + this.settings.placeholder + '</div><span class="fs-arrow"></span></div>');
                this.$select.before('<div class="fs-dropdown hidden"><div class="fs-options"></div></div>');
                this.$select.addClass('hidden');
                this.$wrap = this.$select.closest('.fs-wrap');
                this.reload();
            },

            reload: function() {
                if (this.settings.showSearch) {
                    var search = '<div class="fs-search"><input type="search" placeholder="' + this.settings.searchText + '" /><span class="fs-selectAll"><i class="fa fa-check-square-o"></i></span></div>';
                    this.$wrap.find('.fs-dropdown').prepend(search);
                }
                var choices = this.buildOptions(this.$select);
                this.$wrap.find('.fs-options').html(choices);
                this.reloadDropdownLabel();
            },

            destroy: function() {
                this.$wrap.find('.fs-label-wrap').remove();
                this.$wrap.find('.fs-dropdown').remove();
                this.$select.unwrap().removeClass('hidden');
            },

            buildOptions: function($element) {
                var $this = this;

                var choices = '';
                $element.children().each(function(i, el) {
                    var $el = $(el);

                    if ('optgroup' == $el.prop('nodeName').toLowerCase()) {
                        choices += '<div class="fs-optgroup">';
                        choices += '<div class="fs-optgroup-label">' + $el.prop('label') + '</div>';
                        choices += $this.buildOptions($el);
                        choices += '</div>';
                    }
                    else {
                        var selected = $el.is('[selected]') ? ' selected' : '';
                        choices += '<div class="fs-option' + selected + '" data-value="' + $el.prop('value') + '"><span class="fs-checkbox"><i></i></span><div class="fs-option-label">' + $el.html() + '</div></div>';
                    }
                });

                return choices;
            },

            reloadDropdownLabel: function() {
                var settings = this.settings;
                var labelText = [];

                this.$wrap.find('.fs-option.selected').each(function(i, el) {
                    labelText.push($(el).find('.fs-option-label').text());
                });

                if (labelText.length < 1) {
                    labelText = settings.placeholder;
                }
                else if (labelText.length > settings.numDisplayed) {
                    labelText = settings.overflowText.replace('{n}', labelText.length);
                }
                else {
                    labelText = labelText.join(', ');
                }

                this.$wrap.find('.fs-label').html(labelText);
                this.$select.change();
            },
            setwrap: function() {
              // if(settings.isCheck==false)
              //   this.$wrap.find('.fs-dropdown').addClass('hidden');
              return "123";
            },
        }


        /**
         * Loop through each matching element
         */
        return this.each(function() {
            var data = $(this).data('ySelect');

            if (!data) {
                data = new ySelect(this, settings);
                $(this).data('ySelect', data);
            }

            if (typeof settings == 'string') {
                data[settings]();
            }
        });
    }


    /**
     * Events
     */
    window.ySelect = {
        'active': null,
        'idx': -1
    };

    function setIndexes($wrap) {
        $wrap.find('.fs-option:not(.hidden)').each(function(i, el) {
            $(el).attr('data-index', i);
            $wrap.find('.fs-option').removeClass('hl');
        });
        $wrap.find('.fs-search input').focus();
        window.ySelect.idx = -1;
    }

    function setScroll($wrap) {
        var $container = $wrap.find('.fs-options');
        var $selected = $wrap.find('.fs-option.hl');

        var itemMin = $selected.offset().top + $container.scrollTop();
        var itemMax = itemMin + $selected.outerHeight();
        var containerMin = $container.offset().top + $container.scrollTop();
        var containerMax = containerMin + $container.outerHeight();

        if (itemMax > containerMax) { // scroll down
            var to = $container.scrollTop() + itemMax - containerMax;
            $container.scrollTop(to);
        }
        else if (itemMin < containerMin) { // scroll up
            var to = $container.scrollTop() - containerMin - itemMin;
            $container.scrollTop(to);
        }
    }

    $(document).on('click', '.fs-selectAll', function() {
        $(this).parent().next().find('.fs-option.selected').click();
        $(this).parent().next().find('.fs-option').click();
        $(this).addClass('selected');
    });
    $(document).on('click', '.fs-selectAll.selected', function() {
        $(this).parent().next().find('.fs-option.selected').click();
        $(this).removeClass('selected');
    });

    $(document).on('click', '.fs-option', function() {
        var $wrap = $(this).closest('.fs-wrap');

        if ($wrap.hasClass('multiple')) {
            var selected = [];

            $(this).toggleClass('selected');
            $wrap.find('.fs-option.selected').each(function(i, el) {
                selected.push($(el).attr('data-value'));
            });
        }
        else {
            var selected = $(this).attr('data-value');
            $wrap.find('.fs-option').removeClass('selected');
            $(this).addClass('selected');
            $wrap.find('.fs-dropdown').hide();
        }

        $wrap.find('select').val(selected);
        $wrap.find('select').ySelect('reloadDropdownLabel');
        $wrap.find('select').ySelect('setwrap');
    });
    $(document).on('keyup', '.fs-search input', function(e) {
        if (40 == e.which) {
            $(this).blur();
            return;
        }

        var $wrap = $(this).closest('.fs-wrap');
        var keywords = $(this).val();

        $wrap.find('.fs-option, .fs-optgroup-label').removeClass('hidden');

        if ('' != keywords) {
            $wrap.find('.fs-option').each(function() {
                var regex = new RegExp(keywords, 'gi');
                if (null === $(this).find('.fs-option-label').text().match(regex)) {
                    $(this).addClass('hidden');
                }
            });

            $wrap.find('.fs-optgroup-label').each(function() {
                var num_visible = $(this).closest('.fs-optgroup').find('.fs-option:not(.hidden)').length;
                if (num_visible < 1) {
                    $(this).addClass('hidden');
                }
            });
        }

        setIndexes($wrap);
    });

    $(document).on('click', function(e) {
        var $el = $(e.target);
        var $wrap = $el.closest('.fs-wrap');

        if (0 < $wrap.length) {
            if ($el.hasClass('fs-label')||$el.hasClass('fs-arrow')) {
                window.ySelect.active = $wrap;
                var is_hidden = $wrap.find('.fs-dropdown').hasClass('hidden');
                $('.fs-dropdown').addClass('hidden');

                if (is_hidden) {
                    $wrap.find('.fs-dropdown').removeClass('hidden');
                }
                else {
                    $wrap.find('.fs-dropdown').addClass('hidden');
                }

                setIndexes($wrap);
            }
        }
        else {
            $('.fs-dropdown').addClass('hidden');
            window.ySelect.active = null;
        }
    });

    $(document).on('keydown', function(e) {
        var $wrap = window.ySelect.active;

        if (null === $wrap) {
            return;
        }
        else if (38 == e.which) { // up
            e.preventDefault();

            $wrap.find('.fs-option').removeClass('hl');

            if (window.ySelect.idx > 0) {
                window.ySelect.idx--;
                $wrap.find('.fs-option[data-index=' + window.ySelect.idx + ']').addClass('hl');
                setScroll($wrap);
            }
            else {
                window.ySelect.idx = -1;
                $wrap.find('.fs-search input').focus();
            }
        }
        else if (40 == e.which) { // down
            e.preventDefault();

            var last_index = $wrap.find('.fs-option:last').attr('data-index');
            if (window.ySelect.idx < parseInt(last_index)) {
                window.ySelect.idx++;
                $wrap.find('.fs-option').removeClass('hl');
                $wrap.find('.fs-option[data-index=' + window.ySelect.idx + ']').addClass('hl');
                setScroll($wrap);
            }
        }
        else if (32 == e.which || 13 == e.which) { // space, enter
            $wrap.find('.fs-option.hl').click();
        }
        else if (27 == e.which) { // esc
            $('.fs-dropdown').addClass('hidden');
            window.ySelect.active = null;
        }
    });

    //update by ycx,for this plugin to get selected values
    $.fn.ySelectedValues=function (splitString)
      {
        var result="";
        var $selects=this.find("option:selected");
        for (var i = 0; i < $selects.length; i++) {
          result+=$selects[i].value+((i==$selects.length-1)?"":splitString);
        }
        return result;
      }
    $.fn.ySelectedTexts=function (splitString)
      {
        var result="";
        var $selects=this.find("option:selected");
        for (var i = 0; i < $selects.length; i++) {
          result+=$selects[i].text+((i==$selects.length-1)?"":splitString);
        }
        return result;
      }

})(jQuery);
