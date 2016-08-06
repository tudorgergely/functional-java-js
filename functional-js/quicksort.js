function quicksortFunc(x, ...xs) {
    return !x ? [ ] : [ ].concat(
        quicksortFunc(...xs.filter(a => a <= x)),
        [x],
        quicksortFunc(...xs.filter(a => a > x))
    )
}

function quicksortIter(...items) {
    return quickSort(items, 0, items.length - 1);
}

function quickSort(items, left, right) {
    let index;
    if (items.length > 1) {
        index = partition(items, left, right);
        if (left < index - 1) {
            quickSort(items, left, index - 1);
        }
        if (index < right) {
            quickSort(items, index, right);
        }
    }
    return items;
}

function partition(items, left, right) {
    var pivot = items[left],
        i = left,
        j = right;
    while (i <= j) {
        while (items[i] < pivot) {
            i++;
        }
        while (items[j] > pivot) {
            j--;
        }
        if (i <= j) {
            swap(items, i, j);
            i++;
            j--;
        }
    }
    return i;
}

function swap(items, firstIndex, secondIndex) {
    var temp = items[firstIndex];
    items[firstIndex] = items[secondIndex];
    items[secondIndex] = temp;
}

console.log(quicksortFunc(...[2, 1, 3, 5, 4]));
console.log(quicksortIter(...[2, 1, 3, 5, 4]));