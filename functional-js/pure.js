let importantGlobalObject = {
    importantFunction: () => 42
};

function impureFunction(innocentNumber) {
    return importantGlobalObject.importantFunction() + innocentNumber;
}

function pureFunction(number) {
    return number + 1;
}

function evilImpureFunction() {
    importantGlobalObject.importantFunction = undefined;
}

setTimeout(() => evilImpureFunction(), 250);
setInterval(() => {
    console.log('impure', impureFunction(25));
    console.log('pure', pureFunction(25));
}, 10);
