const loremIpsum = require('lorem-ipsum');

function countEvenWords(text) {
    let counter = 0;
    const words = text.split(' ');
    for (let i = 0; i < words.length; ++i) {
        if (words[i].length % 2 === 0) {
            counter ++;
        }
    }
    return counter;
}

function countEvenWordsFunctional(text) {
    return text
        .split(' ')
        .filter(word => word.length % 2 === 0)
        .length;
}

const text = loremIpsum();

console.log(countEvenWords(text), countEvenWordsFunctional(text));