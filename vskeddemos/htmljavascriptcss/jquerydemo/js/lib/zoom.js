'use strict';

var _typeof = typeof Symbol == "function" && typeof Symbol.iterator == "symbol" ? function (obj) {
    return typeof obj;
} : function (obj) {
    return obj && typeof Symbol == "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj;
};

function _newArrowCheck(innerThis, boundThis) {
    if (innerThis !== boundThis) {
        throw new TypeError("Cannot instantiate an arrow function");
    }
}

(function (global, factory) {
    (typeof exports == 'undefined' ? 'undefined' : _typeof(exports)) == 'object' && typeof module != 'undefined' ? factory(exports) : typeof define == 'function' && define.amd ? define(['exports'], factory) : factory(global.$solway = global.$solway || {});
})(window, function (exports) {
    _newArrowCheck(void 0, void 0);

    var zoom = function (_ref) {
        var _ref$scale = _ref.scale,
            _scale = _ref$scale === void 0 ? 1 : _ref$scale,
            _ref$minScale = _ref.minScale,
            minScale = _ref$minScale === void 0 ? 0.1 : _ref$minScale,
            _ref$maxScale = _ref.maxScale,
            maxScale = _ref$maxScale === void 0 ? 14 : _ref$maxScale,
            ele = _ref.ele,
            _ref$rate = _ref.rate,
            rate = _ref$rate === void 0 ? 0.1 : _ref$rate,
            _ref$translate = _ref.translate,
            translate = _ref$translate === void 0 ? [0, 0] : _ref$translate;

        _newArrowCheck(void 0, void 0);

        var obj = $(ele).css({
            transition: 'all 0.1s',
            "-moz-transition": 'all 0.1s',
            "-webkit-transition": 'all 0.1s',
            "-o-transition": 'all 0.1s',
            position: 'absolute',
            cursor: 'pointer',
            left: 0,
            top: 0
        }).on("mousewheel DOMMouseScroll", mouseWheelHandel);

        scaleFunc(0, !0);

        function mouseWheelHandel(e) {
            var delta = e.originalEvent.wheelDelta && (e.originalEvent.wheelDelta > 0 ? 1 : -1) || e.originalEvent.detail && (e.originalEvent.detail > 0 ? -1 : 1);
            if (delta > 0) return scaleFunc(rate); else if (delta < 0) return scaleFunc(-rate);
        }

        function scaleFunc(val, origin) {
            _scale += val * _scale;
            _scale = _scale <= minScale ? minScale : _scale;
            _scale = _scale >= maxScale ? maxScale : _scale;
            if (_scale <= minScale || _scale >= maxScale) return !1;
            obj.css({
                transform: 'matrix(' + _scale + ',0,0,' + _scale + ', ' + translate[0] + ',' + translate[1] + ')',
                "-ms-transform": 'matrix(' + _scale + ',0,0,' + _scale + ', ' + translate[0] + ',' + translate[1] + ')',
                "-moz-transform": 'matrix(' + _scale + ',0,0,' + _scale + ', ' + translate[0] + ',' + translate[1] + ')',
                "-webkit-transform": 'matrix(' + _scale + ',0,0,' + _scale + ', ' + translate[0] + ',' + translate[1] + ')',
                "-o-transform": 'matrix(' + _scale + ',0,0,' + _scale + ', ' + translate[0] + ',' + translate[1] + ')'
            });
            return !1;
        }

        return {
            scale: function () {
                function scale(n) {
                    scaleFunc(n - _scale);
                }

                return scale;
            }(),
            destroy: function () {
                function destroy() {
                    obj.off("mousewheel DOMMouseScroll", mouseWheelHandel);
                }

                return destroy;
            }()
        };
    }.bind(void 0);

    exports.zoom = zoom;
}.bind(void 0));