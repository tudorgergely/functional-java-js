function compose(...functions) {
    return result => functions
        .reverse()
        .reduce((res, func) => func(res), result);
}

function length(text) {
    return text.length;
}

function isOdd(number) {
    return number % 2 === 1;
}

function take(number) {
    return array => array.slice(0, number);
}

function* odd() {
    let first = 1;
    while (true) {
        yield first;
        first += 2;
    }
}

const number = compose(Math.round, parseFloat);
const hasOddLength = compose(isOdd, length);
const emptyArray = [...Array(45).keys()];
const take5 = take(5);
const generator = odd();

console.log(number('73.5'));
console.log(hasOddLength('1223'));
console.log(take(8)(emptyArray.map(() => generator.next().value)));