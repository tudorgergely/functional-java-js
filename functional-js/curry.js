function add(x) {
    return y => x + y;
}

const numbers = [1, 2, 3, 4, 5];
// const add3 = add(3);
let number = 5;
let add5 = add(number);

console.log(
    numbers.map(add5)
);
number = 6;
console.log(
    numbers.map(add5)
);
function add2(x, y) {
    return x + y;
}

const add3 = add2.bind(this, 3);

console.log(
    numbers.map(add3)
);