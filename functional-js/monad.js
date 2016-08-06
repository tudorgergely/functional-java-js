/*
 - type constructor -> Monad<number>
 - unit function -> Monad(number)
 - bind function -> chains operations (then)
 */
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var Monad = (function () {
    function Monad(value) {
        this.value = value;
    }
    return Monad;
}());
var IdentityMonad = (function (_super) {
    __extends(IdentityMonad, _super);
    function IdentityMonad() {
        _super.apply(this, arguments);
    }
    IdentityMonad.prototype.bind = function (transform) {
        return transform(this.value);
    };
    return IdentityMonad;
}(Monad));
var Nothing = (function (_super) {
    __extends(Nothing, _super);
    function Nothing() {
        _super.apply(this, arguments);
    }
    Nothing.prototype.bind = function (transform) {
        return this;
    };
    return Nothing;
}(Monad));
var result = new IdentityMonad(5)
    .bind(function (value) { return new IdentityMonad(4); })
    .bind(function (value) { return new IdentityMonad(3); })
    .bind(function (value) { return new IdentityMonad(2); })
    .bind(function (value) {
    // console.log(value);
    return new Nothing(3);
});
// console.log(result);
var User = (function () {
    function User(profile) {
        this.profile = profile;
    }
    User.prototype.getName = function () {
        return this.profile;
    };
    return User;
}());
var Same = (function (_super) {
    __extends(Same, _super);
    function Same() {
        _super.apply(this, arguments);
    }
    Same.prototype.bind = function (transform) {
        return transform(this.value);
    };
    return Same;
}(Monad));
var Http = (function () {
    function Http() {
    }
    Http.prototype.get = function (url) {
        return new Same(new User(new Nothing(null)));
    };
    Http.prototype.getNull = function (url) {
        return new User(null);
    };
    return Http;
}());
var http = new Http();
var nNothing = http.get('abc')
    .bind(function (user) { return user.getName(); })
    .bind(function (value) {
    console.log(value);
    return new Nothing(value);
});
var nNull = http.getNull('abc');
if (nNull != null) {
    var name_1 = nNull.getName();
    if (name_1 != null) {
        console.log('isnull');
    }
    else {
        console.log('null');
    }
}
else {
    console.log('user is null');
}
//# sourceMappingURL=monad.js.map