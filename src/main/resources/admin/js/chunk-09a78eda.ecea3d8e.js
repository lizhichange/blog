(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["chunk-09a78eda"], {
    "0972": function (t, e, a) {
    }, 1439: function (t, e, a) {
        "use strict";
        var i = a("0972"), s = a.n(i);
        s.a
    }, ac2a: function (t, e, a) {
        "use strict";
        a.r(e);
        var i = function () {
            var t = this, e = t.$createElement, a = t._self._c || e;
            return a("div", {staticClass: "container-wrapper"}, [t._m(0), a("div", {staticClass: "animated"}, [a("a-form", {
                attrs: {layout: "vertical"},
                nativeOn: {
                    keyup: function (e) {
                        return !e.type.indexOf("key") && t._k(e.keyCode, "enter", 13, e.key, "Enter") ? null : t.handleLogin(e)
                    }
                }
            }, [a("a-form-item", {
                staticClass: "animated fadeInUp",
                style: {"animation-delay": "0.1s"}
            }, [a("a-input", {
                attrs: {placeholder: "用户名/邮箱"}, model: {
                    value: t.username, callback: function (e) {
                        t.username = e
                    }, expression: "username"
                }
            }, [a("a-icon", {
                staticStyle: {color: "rgba(0,0,0,.25)"},
                attrs: {slot: "prefix", type: "user"},
                slot: "prefix"
            })], 1)], 1), a("a-form-item", {
                staticClass: "animated fadeInUp",
                style: {"animation-delay": "0.2s"}
            }, [a("a-input", {
                attrs: {type: "password", placeholder: "密码"},
                model: {
                    value: t.password, callback: function (e) {
                        t.password = e
                    }, expression: "password"
                }
            }, [a("a-icon", {
                staticStyle: {color: "rgba(0,0,0,.25)"},
                attrs: {slot: "prefix", type: "lock"},
                slot: "prefix"
            })], 1)], 1), a("a-form-item", {
                staticClass: "animated fadeInUp",
                style: {"animation-delay": "0.3s"}
            }, [a("a-button", {
                attrs: {type: "primary", block: !0},
                on: {click: t.handleLogin}
            }, [t._v("登录")])], 1), a("a-row", [a("router-link", {attrs: {to: {name: "ResetPassword"}}}, [t.resetPasswordButton ? a("a", {
                staticClass: "tip animated fadeInRight",
                attrs: {href: "javascript:void(0);"}
            }, [t._v("\n            找回密码\n          ")]) : t._e()]), a("a", {
                staticClass: "tip animated fadeInUp",
                style: {"animation-delay": "0.4s"},
                on: {click: t.handleApiModifyModalOpen}
            }, [t._v("\n          API 设置\n        ")])], 1), a("a-modal", {
                attrs: {
                    title: "API 设置",
                    visible: t.apiModifyVisible
                }, on: {ok: t.handleApiModifyOk, cancel: t.handleApiModifyCancel}
            }, [a("a-form", [a("a-form-item", {attrs: {extra: "如果 halo admin 不是独立部署，请不要更改此 API"}}, [a("a-input", {
                model: {
                    value: t.apiUrl,
                    callback: function (e) {
                        t.apiUrl = e
                    },
                    expression: "apiUrl"
                }
            })], 1), a("a-form-item", [a("a-button", {on: {click: t.handleApiUrlRestore}}, [t._v("\n              恢复默认\n            ")])], 1)], 1)], 1)], 1)], 1)])
        }, s = [function () {
            var t = this, e = t.$createElement, a = t._self._c || e;
            return a("div", {staticClass: "halo-logo animated fadeInUp"}, [a("span", [t._v("Halo")])])
        }], n = (a("a481"), a("cebc")), o = a("2f62"), r = {
            data: function () {
                return {
                    username: null,
                    password: null,
                    apiModifyVisible: !1,
                    defaultApiBefore: window.location.protocol + "//",
                    apiUrl: window.location.host,
                    resetPasswordButton: !1
                }
            },
            computed: Object(n["a"])({}, Object(o["c"])({defaultApiUrl: "apiUrl"})),
            created: function () {
                var t = this;
                document.addEventListener("keydown", function (e) {
                    72 === e.keyCode && e.altKey && e.shiftKey && t.toggleHidden()
                })
            },
            methods: Object(n["a"])({}, Object(o["b"])(["login", "loadUser", "loadOptions"]), Object(o["d"])({
                setApiUrl: "SET_API_URL",
                restoreApiUrl: "RESTORE_API_URL"
            }), {
                handleLogin: function () {
                    var t = this;
                    this.username ? this.password ? this.login({
                        username: this.username,
                        password: this.password
                    }).then(function (e) {
                        t.loginSuccess()
                    }) : this.$message.warn("密码不能为空！") : this.$message.warn("用户名不能为空！")
                }, loginSuccess: function () {
                    this.loadUser(), this.loadOptions(), this.$route.query.redirect ? this.$router.replace(this.$route.query.redirect) : this.$router.replace({name: "Dashboard"})
                }, handleApiModifyModalOpen: function () {
                    this.apiUrl = this.defaultApiUrl, this.apiModifyVisible = !0
                }, handleApiModifyOk: function () {
                    this.setApiUrl(this.apiUrl), this.apiModifyVisible = !1
                }, handleApiModifyCancel: function () {
                    this.apiModifyVisible = !1
                }, handleApiUrlRestore: function () {
                    this.restoreApiUrl(), this.apiUrl = this.defaultApiUrl
                }, toggleHidden: function () {
                    this.resetPasswordButton = !this.resetPasswordButton
                }
            })
        }, l = r, d = (a("1439"), a("2877")), c = Object(d["a"])(l, i, s, !1, null, null, null);
        e["default"] = c.exports
    }
}]);