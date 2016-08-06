/*
 - type constructor -> Monad<number>
 - unit function -> Monad(number)
 - bind function -> chains operations (then)
 */

abstract class Monad<T> {
    constructor(protected value:T) {
    }

    abstract bind <U>(transform:(value:T) => Monad<U>):Monad<U>;
}

class IdentityMonad extends Monad<number> {
    bind<U>(transform:(value:number)=>Monad<U>):Monad<U> {
        return transform(this.value);
    }
}

class Nothing extends Monad<any> {
    bind<U>(transform:(value:any)=>Monad<U>):Monad<U> {
        return this;
    }
}

const result = new IdentityMonad(5)
    .bind(value => new IdentityMonad(4))
    .bind(value => new IdentityMonad(3))
    .bind(value => new IdentityMonad(2))
    .bind(value => {
        // console.log(value);
        return new Nothing(3);
    });

// console.log(result);

class User {
    constructor(private profile:any) {

    }

    getName():any {
        return this.profile;
    }
}

class Same extends Monad<any> {
    bind<U>(transform:(value:any)=>Monad<U>):Monad<U> {
        return transform(this.value);
    }
}

class Http {
    get(url:string):Monad<any> {
        return new Same(new User(new Nothing(null)));
    }

    getNull(url:string):User {
        return new User(null);
    }
}

const http:Http = new Http();
const nNothing = http.get('abc')
        .bind((user:User) => user.getName())
    .bind(value => {
        console.log(value);
        return new Nothing(value);
    });



const nNull = http.getNull('abc');
if (nNull != null) {
    const name = nNull.getName();

    if (name != null) {
        console.log('isnull');
    } else {
        console.log('null');
    }
} else {
    console.log('user is null');
}