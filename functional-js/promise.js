function doSomethingAsync(value, callback) {
    setTimeout(() => {
        try {
            const value2 = value + 1;
            throw '321';
            callback(undefined, value2);
        } catch (e) {
            callback(e);
        }
    }, 100);
}

function doSomethingPromise(value) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve(value + 1);
        }, 100);
    })
}

doSomethingPromise(5)
    .then(
        value => {
            console.log(value);
            throw  '12321';
            return doSomethingPromise(6);
        }
    )
    .then(value => console.log(value))
    .catch(error => console.log('error'));

