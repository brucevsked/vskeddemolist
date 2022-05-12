'use strict';

var _typeof = typeof Symbol == "function" && typeof Symbol.iterator == "symbol" ? function (obj) { return typeof obj; } : function (obj) { return obj && typeof Symbol == "function" && obj.constructor === Symbol && obj !== Symbol.prototype ? "symbol" : typeof obj; };

function _newArrowCheck(innerThis, boundThis) { if (innerThis !== boundThis) { throw new TypeError("Cannot instantiate an arrow function"); } }

(function (global, factory) {
    (typeof exports == 'undefined' ? 'undefined' : _typeof(exports)) == 'object' && typeof module != 'undefined' ? factory(exports) : typeof define == 'function' && define.amd ? define(['exports'], factory) : factory(global.$solway = global.$solway || {});
})(window, function (exports) {
    _newArrowCheck(void 0, void 0);

    var drag = function (_ref) {
        var dv = _ref.ele;

        _newArrowCheck(void 0, void 0);

        dv.setAttribute('style', (dv.getAttribute('style') || '') + 'position: absolute;transition: all 0.1s ease 0s;-webkit-transition: all 0.1s ease 0s;-o-transition: all 0.1s ease 0s;-moz-transition: all 0.1s ease 0s;-moz-user-select: -moz-none; -moz-user-select: none; -o-user-select: none; -webkit-user-select: none; -ms-user-select: none; user-select: none;');
        var x = 0,
            y = 0,
            l = 0,
            t = 0,
            isDown = !1;

        dv.addEventListener('mousedown', eleMousedown);
        document.addEventListener('mousemove', eleMousemove);
        dv.addEventListener('mouseup', eleMouseup);

        function eleMousedown(e) {
            x = e.clientX;
            y = e.clientY;

            l = dv.offsetLeft;
            t = dv.offsetTop;

            isDown = !0;

            dv.style.cursor = 'move';
            return !1;
        }

        function eleMousemove(e) {
            if (isDown == !1) {
                return;
            }

            var nx = e.clientX,
                ny = e.clientY,
                nl = nx - (x - l),
                nt = ny - (y - t);


            dv.style.left = nl + 'px';
            dv.style.top = nt + 'px';
            return !1;
        }

        function eleMouseup() {
            isDown = !1;
            dv.style.cursor = 'default';
            return !1;
        }
        return {
            destroy: function () {
                function destroy() {
                    if (dv){
                        dv.removeEventListener('mousedown', eleMousedown);
                        document.removeEventListener('mousemove', eleMousemove);
                        dv.removeEventListener('mouseup', eleMouseup);
                        dv = null;
                    }
                }

                return destroy;
            }()
        };
    }.bind(void 0);

    exports.drag = drag;
}.bind(void 0));